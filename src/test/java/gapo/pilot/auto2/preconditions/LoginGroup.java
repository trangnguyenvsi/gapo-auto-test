//package gapo.pilot.auto2.preconditions;
//
//import gapo.pilot.auto2.pages.PostListOnHomeAction;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Steps;
//
//public class LoginGroup extends UIInteractionSteps {
//    private static boolean beforeFeature = false;
//    @Steps
//    Login login;
//    PostListOnHomeAction postListOnHomeAction;
//
//    @Before("@UpdateOnGroup")
//    @Given("User is on Group and Login successfully")
//    public void user_is_on_group() throws InterruptedException {
//        if(!beforeFeature){
//            beforeFeature = true;
//            login.user_is_on_home_page_and_login_successfully();
//            postListOnHomeAction.go_to_group();
//        }
//    }
//}
