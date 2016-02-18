package com.abhi.rest.intercept.validator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.spi.HttpRequest;

public class CertificateValidator implements BaseValidator{

	@Override
	public void validate(HttpRequest req) {
		// TODO Auto-generated method stub
		try {
//			byte [] inpbytes = new byte[req.getInputStream().r];
//			req.getInputStream().read(inpbytes);
//			System.out.println(">> "+ new String(inpbytes));
			byte [] inpbytes = IOUtils.toByteArray(req.getInputStream());
			System.out.println("Received ip from client "+ new String(inpbytes));
			org.bouncycastle.jce.provider.BouncyCastleProvider bcp =new org.bouncycastle.jce.provider.BouncyCastleProvider();
			Security.addProvider(bcp);
//			File fp = new File("C:/workspaces/java/couchbasePoc/secure-rest/RestExampleTutorial/src/main/resources/abhishek.jks");
//			FileInputStream fpis  = new FileInputStream(fp);
			
			PrivateKey pKey = getPrivateKey(CertificateValidator.class.getResourceAsStream("/abhishek.jks"));
			Cipher decryptCipher = Cipher.getInstance("RSA", bcp);
			decryptCipher.init(Cipher.DECRYPT_MODE, pKey);
			byte[] messageDecrypted = decryptCipher.doFinal(inpbytes);
			System.out.println(new String(messageDecrypted));
			req.setInputStream(new ByteArrayInputStream(messageDecrypted));
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static PrivateKey getPrivateKey(InputStream inStream) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException
	{
		KeyStore myKeyStore = KeyStore.getInstance("JKS");
        myKeyStore.load(inStream, "abhishek".toCharArray());
        PrivateKey privatekey = (PrivateKey) myKeyStore.getKey("abhicert", "abhishek".toCharArray());
        return privatekey;
	}
	
	
	

}
