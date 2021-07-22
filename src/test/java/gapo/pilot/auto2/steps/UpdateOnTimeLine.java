//package gapo.pilot.auto2.steps;
//
//import gapo.pilot.auto2.pages.usertimeline.UserTimelineAction;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import net.thucydides.core.annotations.Steps;
//
//import java.awt.*;
//
//public class UpdateOnTimeLine {
//    @Steps
//    UserTimelineAction userTimelineAction;
//
//    @Given("the user go to update info")
//    public void the_user_go_to_update_info() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        userTimelineAction.go_to_update_info();
//    }
//
//    @When("the user update favourite")
//    public void the_user_update_favourite() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        userTimelineAction.update_favourite();
//    }
//    @Given("the user go to update cover")
//    public void the_user_go_to_update_cover() throws AWTException, InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        userTimelineAction.update_cover("D:\\DOWNLOAD\\KIU_7198.JPG");
//    }
//
//    @Given("the user go to update avt")
//    public void the_user_go_to_update_avt() throws AWTException, InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        userTimelineAction.update_avt("D:\\DOWNLOAD\\KAZUMAMIT.png");
//    }
//
//    @When("the user view avt")
//    public void the_user_view_avt() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        userTimelineAction.click_view_avt();
//    }
//}
