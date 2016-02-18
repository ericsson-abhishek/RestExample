package com.abhi.rest.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jboss.resteasy.security.DerUtils;

public class TestRestCrypto {
	
	public static void main(String[] args) throws Exception{
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postReq = new HttpPost("http://localhost:8090/secure-rest/rest/sendKey");
		
		
		
		String ip = "Abhishek";
		File f = new File("C:/workspaces/java/couchbasePoc/secure-rest/RestExampleTutorial/src/main/resources/abhishek_choudhury.cer");
		FileInputStream fis  = new FileInputStream(f);
		X509Certificate cert = DerUtils.decodeCertificate(fis);
		
		org.bouncycastle.jce.provider.BouncyCastleProvider bcp =new org.bouncycastle.jce.provider.BouncyCastleProvider();
		Security.addProvider(bcp);
		RSAPublicKey rsaPublicKey = (RSAPublicKey)cert.getPublicKey();
		Cipher encryptCipher = Cipher.getInstance("RSA", bcp);
		encryptCipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
		byte [] encrypted= encryptCipher.doFinal(ip.getBytes());
		ByteArrayInputStream bis = new ByteArrayInputStream(encrypted);
		BasicHttpEntity entity = new BasicHttpEntity();
		entity.setContent(bis);
		//entity.setContent(new ByteArrayInputStream("abhishek".getBytes()));
		postReq.setEntity(entity);
		client.execute(postReq);
	}

}
