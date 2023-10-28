package com.sample.core.util;

import com.sample.persistence.service.impl.BikerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = Base64Cryptor.class)
public class CryptorTest {

    @SpyBean
    private Cryptor cryptor;

    @Test
    public void testEncrypt() {
        Long id = 123456789L;
        String encryptedId = cryptor.encrypt(id);

        Assertions.assertNotNull(encryptedId);
        Assertions.assertNotEquals(id.toString(), encryptedId);
    }

    @Test
    public void testDecrypt() {
        String encryptedId = "MTIzNDU2Nzg5"; // Base64 encoded value of 123456789

        Long decryptedId = cryptor.decrypt(encryptedId);

        Assertions.assertNotNull(decryptedId);
        Assertions.assertEquals(123456789L, decryptedId);
    }
}
