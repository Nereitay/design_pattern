package es.kiwi.behavioral.observer.mosh;

public class ChartPull implements Observer{
    private DataSource dataSource;

    public ChartPull(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Chart got notified: " + dataSource.getValue());
    }
}
