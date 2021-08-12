package gapo.pilot.auto2.pages.login;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static By PHONE_TXT = By.name("email");
//      public static By CONTINUE_BTN = By.xpath("//*[@id='root']/div[3]/div[1]/div[1]/button");
    public static By CONTINUE_BTN = By.xpath("//button[text()='Tiếp tục']");
//    public static By WORK_CONTINUE_BTN = By.xpath("//button[text()='Bắt đầu miễn phí']");

    public static By PASS_TXT = By.xpath("//input[@type='password']");
    public static By LOGIN_BTN = By.xpath("//button[@type = 'submit']");

}
