package com.coorge.userandtransaction.service;

public interface EncryptionDecryptionService {


  String encrypt(String password);

  String decrypt(String encryptedtext);

}
