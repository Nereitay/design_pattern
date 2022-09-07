package es.kiwi.creational.builder.mosh;

import java.util.ArrayList;
import java.util.List;

public class Presentation {

    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public void export(PresentationFormat format) {

        if (format == PresentationFormat.PDF) {
            PdfDocument pdf = new PdfDocument();
            for (Slide slide : slides) {
                pdf.addPage(slide.getText());
            }
        } else if (format == PresentationFormat.MOVIE) {
            Movie movie = new Movie();
            for (Slide slide : slides) {
                movie.addFrame(slide.getText(), 3);
            }
        }

    }
}
