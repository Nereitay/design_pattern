package es.kiwi.structural.decorator.mosh;


public class Main {

    public static void main(String[] args) {
        CloudStream cloudStream = new CloudStream();
        cloudStream.write("Here's some data");

        CloudStream cloudStream1 = new EncryptedCloudStream();
        cloudStream1.write("Here's some data");

        System.out.println("---------------Decorator Pattern---------------");

        storeCreditCard(new CloudStreamD());
        storeCreditCard(new EncryptedCloudStreamD(new CloudStreamD()));
        storeCreditCard(new CompressedCloudStreamD(new CloudStreamD()));

        storeCreditCard(new EncryptedCloudStreamD(new CompressedCloudStreamD(new CloudStreamD())));



    }

    public static void storeCreditCard(Stream stream) {
        stream.write("1234-1234-1234-1234");
    }
}
