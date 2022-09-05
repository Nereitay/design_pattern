package es.kiwi.behavioral.observer.mosh;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        Observer sheet1 = new SpreadSheet();
        Observer sheet2 = new SpreadSheet();
        Observer chart = new Chart();
        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);

        System.out.println("---------------Communication Styles: PUSH-----------------");

        DataSourcePush dataSource1 = new DataSourcePush();
        ObserverPush sheet3 = new SpreadSheetPush();
        ObserverPush sheet4 = new SpreadSheetPush();
        ObserverPush chart1 = new ChartPush();
        dataSource1.addObserver(sheet3);
        dataSource1.addObserver(sheet4);
        dataSource1.addObserver(chart1);

        dataSource1.setValue(1);

        System.out.println("---------------Communication Styles: PULL-----------------");

        DataSource dataSource2 = new DataSource();
        Observer sheet5 = new SpreadSheetPull(dataSource2);
        Observer sheet6 = new SpreadSheetPull(dataSource2);
        Observer chart2 = new ChartPull(dataSource2);
        dataSource2.addObserver(sheet5);
        dataSource2.addObserver(sheet6);
        dataSource2.addObserver(chart2);

        dataSource2.setValue(1);

    }
}
