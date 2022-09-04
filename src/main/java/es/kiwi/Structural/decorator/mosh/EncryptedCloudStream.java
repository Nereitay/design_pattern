package es.kiwi.Structural.decorator.mosh;

public class EncryptedCloudStream extends CloudStream{

    @Override
    public void write(String data) {
        String encrypted = encrypt(data);
        super.write(encrypted);
    }

    private String encrypt(String data)  {
        return "!@*&$%&^$@%&";
    }
}
