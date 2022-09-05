package es.kiwi.structural.adapter.mosh;

import es.kiwi.structural.adapter.mosh.avaFilters.Caramel;

public class CaramelFilter implements Filter{

    private Caramel caramel;

    public CaramelFilter(Caramel caramel) {
        this.caramel = caramel;
    }

    @Override
    public void apply(Image image) {
        caramel.init();
        caramel.render(image);
    }
}
