package es.kiwi.Behavioral.state.mosh.abuse;

public class StoppedState implements State {

    private StopWatch2 stopWatch;

    public StoppedState(StopWatch2 stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void click() {
        stopWatch.setCurrentState(new RunningState(stopWatch));
        System.out.println("Running");
    }
}
