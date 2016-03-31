package br.org.ismart.ismartonline.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.org.ismart.ismartonline.models.GeekieStudent;
import br.org.ismart.ismartonline.models.User;

@Component
public class GeekieLab {
	
	private Map<String, String> geekieTags;
	
	public GeekieLab(){
		this.geekieTags = new HashMap<>();
		
		this.geekieTags.put("SJC_1", "10000000000011368");
		this.geekieTags.put("RJ_1", "10000000000011367");
		this.geekieTags.put("SP_1", "10000000000011366");
		this.geekieTags.put("Sorocaba_1", "10000000000011402");
		this.geekieTags.put("Cotia_1", "10000000000011401");
		this.geekieTags.put("2016_1", "10000000000011365");
		this.geekieTags.put("1", "5749781167079424");
		this.geekieTags.put("Manhã_1", "5766239481757696");
		this.geekieTags.put("Tarde_1", "5634985281191936");
		
		
		this.geekieTags.put("SP_8", "5094248355463168");
		this.geekieTags.put("SP_9", "5094248355463168");
		this.geekieTags.put("SJC_8", "6525724515106816");
		this.geekieTags.put("SJC_9", "6525724515106816");
		this.geekieTags.put("RJ_8", "6454287834021888");
		this.geekieTags.put("RJ_9", "6454287834021888");
		this.geekieTags.put("2016_8", "10000000000011364");
		this.geekieTags.put("2016_9", "10000000000011364");
		this.geekieTags.put("8", "5075454121738240");
		this.geekieTags.put("9", "5194957291782144");
		this.geekieTags.put("Manhã_8", "5766239481757696");
		this.geekieTags.put("Manhã_9", "5766239481757696");
		this.geekieTags.put("Tarde_8", "5634985281191936");
		this.geekieTags.put("Tarde_9", "5634985281191936");			
			
		
	}

	public String createTagsString(User user) {
		
		StringBuilder tags = new StringBuilder("");
		
		tags.append("\"" + geekieTags.get(user.getUnidade() + "_" + user.getAno()) + "\", " );
		tags.append("\"" + geekieTags.get(user.getTurma() + "_" + user.getAno()) + "\", " );
		tags.append("\"" + geekieTags.get(user.getAno()) + "\", " );
		tags.append("\"" + geekieTags.get(user.getTurno() + "_" + user.getAno()) + "\"" );
		
		return tags.toString();
	}
	

	public static void main(String[] args) {

		GeekieStudent student = new GeekieLab().createStudent("", "Julio Vidal2", "10000000000000215", "123", "80z5Bz9xi2xOXgtxmz1lXD4ILJKscYHV6xdV3vHaVled4Z1U2g");
		//GeekieStudent student = new GeekieLab().getStudentByExternalId("10000000000000215", "-2", "80z5Bz9xi2xOXgtxmz1lXD4ILJKscYHV6xdV3vHaVled4Z1U2g");

	}

	public GeekieStudent createStudent(String tags, String fullName, String organizationId, String externalId, String key) {

		String body = "{\"roles\": [\"student\"], \"tags\": [" + tags + "], \"full_name\": \"" + fullName
				+ "\", \"content_group_ids\": []}";
		System.out.println("BODY: " + body + "\n");

		String hashBody = DigestUtils.sha1Hex(body);
		// alvo "ef4ee6b7a9e30b9cee871d87b2f50a65ddd6db9a"

		//System.out.println("Hash do Body: " + hashBody + "\n");

		try {

			String time = new DateTime(DateTimeZone.UTC).toString();

			String value = "PUT /organizations/" + organizationId + "/members/by-external-id/" + externalId + "\n"
					+ time + "\n" + hashBody + "\n";
			//System.out.println(value);

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
			//System.out.println(signature);

			String aluno = sendPut(body, time, signature, organizationId, externalId);

			ObjectMapper mapper = new ObjectMapper();

			return mapper.readValue(aluno, GeekieStudent.class);
			

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public GeekieStudent getStudentByExternalId(String organizationId, String externalId, String key) {

		try {

			String time = new DateTime(DateTimeZone.UTC).toString();
			
			String value = "GET /organizations/" + organizationId + "/members/by-external-id/" + externalId + "\n"
					+ time + "\nda39a3ee5e6b4b0d3255bfef95601890afd80709\n";

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
			
			String signature = new String(hexBytes, "UTF-8");

			String aluno = sendGet(organizationId, externalId, time, signature );

			ObjectMapper mapper = new ObjectMapper();

			return mapper.readValue(aluno, GeekieStudent.class);
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
	
	private String sendGet(String organizationId, String externalId, String time, String signature) throws ClientProtocolException, IOException{
		
		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://api.geekielab.com.br/organizations/" + organizationId
				+ "/members/by-external-id/" + externalId);

		//System.out.println("TIME: " + time);
		//System.out.println("SIGNATURE: " + signature);

		get.addHeader("X-Geekie-Requested-At", time);
		get.addHeader("X-Geekie-Signature", signature);
		get.addHeader("Content-Type", "application/json");
		get.addHeader("X-Requested-With", "XMLHttpRequest");

		HttpResponse response = client.execute(get);
		System.out.println(response);

		String result = EntityUtils.toString(response.getEntity());
		System.out.println(result);
		return result;
	}

	private String sendPut(String body, String time, String signature, String organizationId, String externalId)
			throws Exception {

		HttpClient client = new DefaultHttpClient();
		HttpPut put = new HttpPut("http://api.geekielab.com.br/organizations/" + organizationId
				+ "/members/by-external-id/" + externalId);

		//System.out.println("TIME: " + time);
		//System.out.println("SIGNATURE: " + signature);

		put.addHeader("X-Geekie-Requested-At", time);
		put.addHeader("X-Geekie-Signature", signature);
		put.addHeader("Content-Type", "application/json");
		put.addHeader("X-Requested-With", "XMLHttpRequest");

		String json = body;
		HttpEntity entity = new ByteArrayEntity(json.getBytes("UTF-8"));

		put.setEntity(entity);
		HttpResponse response = client.execute(put);
		System.out.println(response);

		String result = EntityUtils.toString(response.getEntity());
		System.out.println(result);
		return result;

	}

	private static void sendPost(String body, String time, String signature) throws Exception {

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://api.geekielab.com.br/organizations/10000000000000182/members/");

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

	public String getOrganizationId(User user) {
		return user.getAno().equals("1") ? "10000000000000215" : "5829241142771712";
	}

	public String getSigninKey(User user) {
		return user.getAno().equals("1") ? "80z5Bz9xi2xOXgtxmz1lXD4ILJKscYHV6xdV3vHaVled4Z1U2g" : "dLOWIw1aniQkkBW6BozIKh9ZJNycr0taEfSheXexQmIQQGu53aS2FylKhUOyFGzk";
	}

	public String getOauthSigninKey(User user) {
		
		return getSigninKey(user) + "&";
	}
}
