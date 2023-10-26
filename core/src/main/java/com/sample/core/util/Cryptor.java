package com.sample.core.util;

public interface Cryptor {

    String encrypt(Long id);

    Long decrypt(String id);
}
