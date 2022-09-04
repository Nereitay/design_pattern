package es.kiwi.Behavioral.state.mosh.abuse;

public class StopWatch2 {

    private State CurrentState = new StoppedState(this);

    public State getCurrentState() {
        return CurrentState;
    }

    public void setCurrentState(State currentState) {
        CurrentState = currentState;
    }

    public void click() {
        CurrentState.click();
    }

    /* private boolean isRunning;

    public void click() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Stopped");
        } else {
            isRunning = true;
            System.out.println("Running");
        }
    }*/
}
