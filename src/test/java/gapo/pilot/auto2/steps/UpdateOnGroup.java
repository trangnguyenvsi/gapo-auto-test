//package gapo.pilot.auto2.steps;
//
//import gapo.pilot.auto2.pages.group.GroupAtion;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Steps;
//
//public class UpdateOnGroup extends UIInteractionSteps {
//    @Steps
//    GroupAtion groupAtion;
//
//
//    @When("the user update noti")
//    public void the_user_update_noti() {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.noti_setting_on_group();
//    }
//
//    @When("the user update follow")
//    public void the_user_update_follow() {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.follow_setting_on_group();
//    }
//
//    @Given("the user update intro")
//    public void the_user_update_intro() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.edit_intro_group();
//    }
//
//    @When("the user invite fr join group")
//    public void the_user_invite_fr_join_group() {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.invite_fr_join_group();
//    }
//
//    @Given("the user go to setting group")
//    public void the_user_go_to_setting_group() {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.go_to_setting_group();
//    }
//
//    @When("the user edit name of group")
//    public void the_user_edit_name_of_group() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.edit_name_of_group();
//    }
//
//    @When("the user edit rule of group")
//    public void the_user_edit_rule_of_group() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.change_rule_group();
//    }
//
//    @Given("the user accept requets")
//    public void the_user_accept_requets() {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.accept_requets_join_group();
//    }
//
//    @When("the user delete member group")
//    public void the_user_delete_member_group() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.delete_member_group();
//    }
//
//    @Given("the user accept post")
//    public void the_user_accept_post() {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.the_user_accept_post();
//    }
//
//    @When("the user pin post")
//    public void the_user_pin_post() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        groupAtion.the_user_pin_and_check_post();
//    }
//}
