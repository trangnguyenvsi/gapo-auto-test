//package gapo.pilot.auto2.preconditions;
//import gapo.pilot.auto2.pages.PostListOnHomeAction;
//import io.cucumber.java.Before;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Steps;
//
//public class LoginPage extends UIInteractionSteps {
//    private static boolean beforeFeature = false;
//    @Steps
//    Login login;
//    PostListOnHomeAction postListOnHomeAction;
//
//    @Before("@UpdateOnPage")
//    public void user_login_on_home_page() throws InterruptedException {
//        if(!beforeFeature){
//            beforeFeature = true;
//            login.user_is_on_home_page_and_login_successfully();
//            postListOnHomeAction.go_to_page();
//        }
//    }
//}
