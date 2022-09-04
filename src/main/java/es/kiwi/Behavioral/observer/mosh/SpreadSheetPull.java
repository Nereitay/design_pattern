package es.kiwi.Behavioral.observer.mosh;

public class SpreadSheetPull implements Observer{

    private DataSource dataSource;

    public SpreadSheetPull(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("SpreadSheet got notified: " + dataSource.getValue());
    }
}
