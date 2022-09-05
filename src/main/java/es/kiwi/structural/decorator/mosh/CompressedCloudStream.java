package es.kiwi.structural.decorator.mosh;

public class CompressedCloudStream extends CloudStream{

    @Override
    public void write(String data) {
        String compressed = compress(data);
        super.write(compressed);
    }


    private String compress(String data)  {
        return data.substring(0, 5);
    }




}
