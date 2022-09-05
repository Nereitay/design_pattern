package es.kiwi.behavioral.state.mosh;

import es.kiwi.behavioral.state.mosh.abuse.StopWatch;
import es.kiwi.behavioral.state.mosh.abuse.StopWatch2;

public class Main {

    public static void main(String[] args) {
//        drawUIControl(new TextBox());

//        state();

        StopWatch stopWatch = new StopWatch();
        stopWatch.click();
        stopWatch.click();
        stopWatch.click();

        System.out.println("Abuse pattern..............");

        StopWatch2 stopWatch2 = new StopWatch2();
        stopWatch2.click();
        stopWatch2.click();
        stopWatch2.click();


    }

    private static void state() {
        /*Open( for extension) Closed( for modification) Principle*/
        Canvas2 canvas = new Canvas2();
        canvas.setCurrentTool(new EraserTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }

    private static void drawUIControl(UIControl control) {
        control.draw();
    }
}
