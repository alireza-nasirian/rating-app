package com.sample.core.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Cryptor implements Cryptor{


    @Override
    public String encrypt(Long id) {
        return Base64.getEncoder().encodeToString(id.toString().getBytes());
    }

    @Override
    public Long decrypt(String id) {
        return Long.decode(new String(Base64.getDecoder().decode(id)));
    }
}
