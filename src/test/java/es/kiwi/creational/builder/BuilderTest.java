package es.kiwi.creational.builder;

import es.kiwi.creational.builder.mosh.PdfDocument;
import es.kiwi.creational.builder.mosh.PdfDocumentBuilder;
import es.kiwi.creational.builder.mosh.Presentation1;
import es.kiwi.creational.builder.mosh.Slide;
import org.junit.Test;

public class BuilderTest {

    /*To separate the construction of an object from its representation*/
    @Test
    public void mainMosh() {
        Presentation1 presentation = new Presentation1();
        presentation.addSlide(new Slide("Slide 1"));
        presentation.addSlide(new Slide("Slide 2"));

        PdfDocumentBuilder builder = new PdfDocumentBuilder();
        presentation.export(builder);
        PdfDocument pdf = builder.getPdfDocument();
    }
}
