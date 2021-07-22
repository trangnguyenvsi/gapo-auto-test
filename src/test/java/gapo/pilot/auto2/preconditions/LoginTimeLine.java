//package gapo.pilot.auto2.preconditions;
//
//import gapo.pilot.auto2.pages.navigation.NavigationAction;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Steps;
//
//import java.awt.*;
//
//public class LoginTimeLine extends UIInteractionSteps {
//    private static boolean beforeFeature = false;
//    @Steps
//    Login login;
//    NavigationAction navigationAct;
//
//    @Before("@posttextontimeline and not @posttext")
//    @Given("User login successfully and is on Time Line")
//    public void user_is_on_Time_Line(Scenario scenario) throws InterruptedException, AWTException {
//        if (!beforeFeature) {
//            beforeFeature = true;
//            login.user_is_on_home_page_and_login_successfully();
//            navigationAct.goToTimeline();
//        }
//    }
//
//
//}
//
//
