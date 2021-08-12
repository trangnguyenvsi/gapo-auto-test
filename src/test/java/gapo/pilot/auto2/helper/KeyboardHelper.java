package gapo.pilot.auto2.helper;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardHelper {
    public static void pressEnterKey() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void pressSpaceKey() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }



}
