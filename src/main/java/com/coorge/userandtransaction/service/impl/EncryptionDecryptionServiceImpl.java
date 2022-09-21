package com.coorge.userandtransaction.service.impl;

import com.coorge.userandtransaction.service.EncryptionDecryptionService;
import java.nio.charset.Charset;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptionDecryptionServiceImpl implements EncryptionDecryptionService {


  @Value("${blowfish.key:abc123}")
  private String blowfishKey;

  public  String encrypt(String password) {
    try {
      byte[] KeyData = blowfishKey.getBytes();
      SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
      Cipher cipher = Cipher.getInstance("Blowfish");
      cipher.init(Cipher.ENCRYPT_MODE, KS);
      String encryptedtext = Base64.getEncoder().
          encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
      return encryptedtext;
    }catch (Exception e){
      return null;
    }

  }

  public String decrypt(String encryptedtext) {
    try {
      byte[] KeyData = blowfishKey.getBytes();
      SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
      byte[] ecryptedtexttobytes = Base64.getDecoder().
          decode(encryptedtext);
      Cipher cipher = Cipher.getInstance("Blowfish");
      cipher.init(Cipher.DECRYPT_MODE, KS);
      byte[] decrypted = cipher.doFinal(ecryptedtexttobytes);
      String decryptedString =
          new String(decrypted, Charset.forName("UTF-8"));
      return decryptedString;
    }catch (Exception e){
      return null;
    }
  }

}
