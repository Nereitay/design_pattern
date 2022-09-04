package es.kiwi.Structural.adapter.mosh;

import es.kiwi.Structural.adapter.mosh.avaFilters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {

    @Override
    public void apply(Image image) {
        init();
        render(image);
    }
}
