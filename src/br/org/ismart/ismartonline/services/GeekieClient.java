package br.org.ismart.ismartonline.services;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class GeekieClient {

	public static void main(String[] args) {

		String baseString = "POST&https%3A%2F%2Fwww.geekielab.com.br%2Flogin%2Flaunch&oauth_consumer_key%3D10000000000000182%26oauth_nonce%3D5ledh45pgfirudi%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1457117982%26oauth_version%3D1.0%26user_id%3D10000000000915752";
		String signinKey = "hSCgLA3cjMPbifEDsPB7GWnuOWygVpeUSsYlWdknAvO3xmoj7W&";

		System.out.println(new GeekieClient().generateHmacSha(baseString, signinKey));

	}

	public String generateHmacSha(String baseString, String signinKey) {

		try {

			String value = baseString;// "GET
										// /organizations/10000000000000215/who-am-i\n2016-03-03T16:12:02.223Z\nda39a3ee5e6b4b0d3255bfef95601890afd80709\n";
			String key = signinKey;// "80z5Bz9xi2xOXgtxmz1lXD4ILJKscYHV6xdV3vHaVled4Z1U2g";

			// Get an hmac_sha1 key from the raw key bytes
			byte[] keyBytes = key.getBytes();
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

			// Get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);

			// Compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(value.getBytes());

			// Convert raw bytes to Hex
			//byte[] hexBytes = new Hex().encode(rawHmac);
			
			
			byte[] result = Base64.encodeBase64(rawHmac);

			// Covert array of Hex bytes to a String
			return new String(result, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
