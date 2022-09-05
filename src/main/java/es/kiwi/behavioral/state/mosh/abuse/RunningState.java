package es.kiwi.behavioral.state.mosh.abuse;

public class RunningState implements State{

    private StopWatch2 stopWatch;

    public RunningState(StopWatch2 stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void click() {
        stopWatch.setCurrentState(new StoppedState(stopWatch));
        System.out.println("Stopped");
    }
}
