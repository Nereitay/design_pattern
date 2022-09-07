package es.kiwi.creational.builder.mosh;

public class MovieBuilder implements PresentationBuilder{

   private Movie movie = new Movie();

    @Override
    public void addSlide(Slide slide) {
        movie.addFrame(slide.getText(), 3);
    }

    public Movie getPdfDocument() {
        return movie;
    }
}
