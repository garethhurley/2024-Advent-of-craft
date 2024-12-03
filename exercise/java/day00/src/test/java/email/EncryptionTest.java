package email;

import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Base64;

import static email.FileUtils.loadFile;
import static io.vavr.test.Arbitrary.of;
import static org.assertj.core.api.Assertions.assertThat;

class EncryptionTest {
    private final Encryption encryption = createEncryption();

    @Test
    void encryptString() throws Exception {
        String encryptedText = encryption.encrypt("Unlock Your Potential with the Advent Of Craft Calendar!");
        assertThat(encryptedText)
                .isEqualTo("L7wht/YddOoTvYvrc+wFcZhtXNvZ2cHFxq9ND27h1Ovv/aWLxN8lWv1xMsguM/R4Yodk3rn9cppI+YarggtPjA==");
    }

    @Test
    void decryptString() throws Exception {
        String encrypted = loadFile("EncryptedEmail.txt");
        String decrypted = encryption.decrypt(encrypted);
        Files.writeString(Path.of("DecryptedEmail.txt"), decrypted);
        assertThat(decrypted).isNotNull();
        assertThat(decrypted).isEqualTo(loadFile("DecryptedEmail.txt"));
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @Test
    void encryptDecrypt_shouldReturnOriginalString() {
        // It is a Property-Based test that checks the below property
        // I'm pretty sure we will talk about this concept during our Journey 🎅
        Property.def("decrypt(encrypt(x)) == x for all x")
                .forAll(of("foo", "bar", "baz", "qux"))
                .suchThat(plainText ->
                        encryption.decrypt(
                                encryption.encrypt(plainText)
                        ).equals(plainText)
                )
                .check()
                .assertIsSatisfied();
    }

    private static Encryption createEncryption() {
        try {
            return new Encryption(
                    new Configuration(convertKey("Advent Of Craft"), convertIv("2024"))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertKey(String key) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha256.digest(key.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    private static String convertIv(String iv) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] ivBytes = md5.digest(iv.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(ivBytes);
    }
}
