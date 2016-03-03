package br.org.ismartonline.lab;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class GeekieLab {

	public static void main(String[] args) {
		
		createStudent();

	}

	private static void createStudent() {	

		String body = "{\"roles\": [\"student\"], \"tags\": [], \"full_name\": \"Julio Vidal\", \"content_group_ids\": []}";
		System.out.println("BODY: " + body + "\n");
		
		String hashBody = DigestUtils.sha1Hex(body);
		// alvo "ef4ee6b7a9e30b9cee871d87b2f50a65ddd6db9a"
		
		System.out.println("Hash do Body: " + hashBody + "\n");

		try {
			
			String time = new DateTime(DateTimeZone.UTC).toString();

			String value = "POST /organizations/10000000000000182/members\n"+time+"\n"+hashBody+"\n";
			System.out.println(value);
			String key = "hSCgLA3cjMPbifEDsPB7GWnuOWygVpeUSsYlWdknAvO3xmoj7W";

			// Get an hmac_sha1 key from the raw key bytes
			byte[] keyBytes = key.getBytes();
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

			// Get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);

			// Compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(value.getBytes());

			// Convert raw bytes to Hex
			byte[] hexBytes = new Hex().encode(rawHmac);

			// Covert array of Hex bytes to a String
			
			String signature = new String(hexBytes, "UTF-8");
			System.out.println(signature);
			
			
			sendPost(body, time, signature);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void whoAmI() {
		System.out.println(DigestUtils.sha1Hex(""));

		try {

			String value = "GET /organizations/10000000000000215/who-am-i\n2016-03-03T16:12:02.223Z\nda39a3ee5e6b4b0d3255bfef95601890afd80709\n";
			String key = "80z5Bz9xi2xOXgtxmz1lXD4ILJKscYHV6xdV3vHaVled4Z1U2g";

			// Get an hmac_sha1 key from the raw key bytes
			byte[] keyBytes = key.getBytes();
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

			// Get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);

			// Compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(value.getBytes());

			// Convert raw bytes to Hex
			byte[] hexBytes = new Hex().encode(rawHmac);

			// Covert array of Hex bytes to a String
			System.out.println(new String(hexBytes, "UTF-8"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void sendPost(String body, String time, String signature) throws Exception {

		HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://api.geekielab.com.br/organizations/10000000000000182/members");

        
        System.out.println("TIME: " + time);
        System.out.println("SIGNATURE: " + signature);
        
        post.addHeader("X-Geekie-Requested-At", time);
		post.addHeader("X-Geekie-Signature", signature);
        post.addHeader("Content-Type", "application/json");
        post.addHeader("X-Requested-With", "XMLHttpRequest");
        
        String json = body;
        HttpEntity entity = new ByteArrayEntity(json.getBytes("UTF-8"));
        
        
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        
        System.out.println(response.toString());
        
        String result = EntityUtils.toString(response.getEntity());
        
        System.out.println(result);

	}
}
