package es.kiwi.structural.decorator.mosh;

public class CompressedCloudStreamD implements Stream{

    private Stream stream;

    public CompressedCloudStreamD(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        String compressed = compress(data);
        stream.write(compressed);
    }


    private String compress(String data)  {
        return data.substring(0, 5);
    }




}
