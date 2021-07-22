package gapo.pilot.auto2.preconditions;

import gapo.pilot.auto2.openurl.GapoHomePageURLAction;
import gapo.pilot.auto2.pages.LoginAction;
import gapo.pilot.auto2.pages.navigation.NavigationAction;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

import java.awt.*;


public class Login extends UIInteractionSteps {
    @Steps
    GapoHomePageURLAction gapoHomePageURLAction;
    LoginAction loginPageAction;
    NavigationAction navigationAct;

    public void user_is_on_home_page_and_login_successfully() throws InterruptedException, AWTException {
        gapoHomePageURLAction.open_home_page();
        loginPageAction.login("trangnguyenpro21@mailinator.com", "12345678a");
        navigationAct.navigateOnHomepage();
    }
}
