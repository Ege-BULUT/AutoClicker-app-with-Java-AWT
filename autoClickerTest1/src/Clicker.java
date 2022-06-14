import java.awt.*;
import java.awt.event.InputEvent;

enum clickTypes{
    RIGHT,
    LEFT,
    MIDDLE
        }

public class Clicker {

    private Robot robot;
    private int delay;

    public Clicker(){
        try {robot = new Robot();}catch (AWTException ignored) {}
        delay = 100; //default delay
    }


 //
    public void clickMouse(clickTypes mouseButton, int clickAmount){
        int button = InputEvent.BUTTON1_DOWN_MASK; //default left
        switch (mouseButton){
            case LEFT:
                button = InputEvent.BUTTON1_DOWN_MASK;
                break;
            case RIGHT:
                button = InputEvent.BUTTON3_DOWN_MASK;
                break;
            case MIDDLE:
                button = InputEvent.BUTTON2_DOWN_MASK;
                break;
        }

        try{
            for(int i = 0; i<clickAmount; i++) {
                robot.mousePress(button);
                robot.delay(delay);
                robot.mouseRelease(button);
                robot.delay(delay);
            }
        }catch (Exception ignored){}
    }

    public void setDelay(int delay) {
        this.delay = delay/2;
    }
}
