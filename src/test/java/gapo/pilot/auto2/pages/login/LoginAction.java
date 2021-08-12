package gapo.pilot.auto2.pages.login;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {

    @Step("Login")
    public void login(String phone, String pass) {
        $(LoginPage.PHONE_TXT).type(phone);
        $(LoginPage.CONTINUE_BTN).click();
        $(LoginPage.PASS_TXT).type(pass);
        $(LoginPage.LOGIN_BTN).click();
        waitFor(2000).milliseconds();
    }
}
