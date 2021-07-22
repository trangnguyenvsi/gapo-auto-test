package gapo.pilot.auto2.helper;

import net.serenitybdd.core.steps.UIInteractionSteps;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class UploadMedia extends UIInteractionSteps {

    public String get_path() {
        String path = "src/test/resources/testdata/images/";
        File filePath = new File(path);
        String absolutePath = filePath.getAbsolutePath();
        System.out.println("Current Path:" + absolutePath);
        return absolutePath;
    }

    public void robot_upload_media(String totalImage, String imageName, String imageType) throws AWTException {
        String src = "";
//        String path = get_path();
        String path = "G:\\Testdata\\Images";
        int totalImageNumber = Integer.parseInt(totalImage);
        for (int i = 1; i <= totalImageNumber; i++) {
            String imageIndex = String.valueOf(i);
            //path of one image
            String s = path + "\\" + imageName + imageIndex + imageType;
            //list all image in one string
            //  src = src + "" + "\"" + s + "\"";
            src = src + "\"" + s + "\"";
            System.out.println(s);
        }
        System.out.println(src);


        Robot robot = new Robot();

        StringSelection str = new StringSelection(src);
        System.out.println("String selection:" + str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//        TimeUnit.SECONDS.sleep(3);
    }
}
