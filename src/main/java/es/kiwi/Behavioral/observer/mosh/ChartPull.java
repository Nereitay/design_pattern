package es.kiwi.Behavioral.observer.mosh;

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
