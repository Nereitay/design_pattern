package es.kiwi.structural.adapter.mosh;

import es.kiwi.structural.adapter.mosh.avaFilters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {

    @Override
    public void apply(Image image) {
        init();
        render(image);
    }
}
