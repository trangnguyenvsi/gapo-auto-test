package gapo.pilot.auto2.preconditions;

import gapo.pilot.auto2.pages.navigation.NavigationAction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class LoginHomePage extends UIInteractionSteps {
    private static boolean beforeFeature = false;
    private static boolean beforeTimeline = false;


    @Steps
    Login login;
    NavigationAction navigationAct;

    @Before
    public void user_login_on_home_page(Scenario scenario) throws InterruptedException, AWTException {
        if (!beforeFeature) {
            login.user_is_on_home_page_and_login_successfully();
            beforeFeature = true;
        }
    }

    @Before("@posttexttimeline or @postmediatimeline or @postbackgroundtimeline or @postmentiontimeline or @checkpostprivacytimeline " +
            "or @postquestiontimeline or @editprivacytimeline or @posttagtimeline")
    public void goToTimeline() {
        if (!beforeTimeline) {
            navigationAct.goToTimeline();
            beforeTimeline = true;
        }
    }

    @After("@posttagtimeline")
    public void afterPostTagOnTimeline() {
        navigationAct.goToTimeline();
    }


}
