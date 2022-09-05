package es.kiwi.structural.decorator.mosh;

public class EncryptedCloudStreamD implements Stream{

    private Stream stream;

    public EncryptedCloudStreamD(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        String encrypted = encrypt(data);
        stream.write(encrypted);
    }

    private String encrypt(String data)  {
        return "!@*&$%&^$@%&";
    }
}
