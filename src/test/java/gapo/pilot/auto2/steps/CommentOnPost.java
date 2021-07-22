//package gapo.pilot.auto2.steps;
//
//import gapo.pilot.auto2.pages.CommentAction;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import net.thucydides.core.annotations.Steps;
//
//import java.awt.*;
//
//public class CommentOnPost {
//    @Steps
//    CommentAction commentAction;
//
//    @Given("the user create new comment on {string}")
//    public void the_user_create_new_comment_on(String comment) throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.create_new_comment(comment);
//    }
//
//    @Given("the user create new comment with sticker")
//    public void the_user_create_new_comment_with_sticker() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.create_new_comment_with_sticker();
//    }
//
//    @Given("the user create new comment with emoji")
//    public void the_user_create_new_comment_with_emoji() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.create_new_comment_with_emoji();
//    }
//
//    @Given("the user create new comment with media {string}")
//    public void the_user_create_new_comment_with_media(String src) throws AWTException, InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.create_new_comment_with_image(src);
//    }
//
//    @Given("the user create new comment mention other user")
//    public void the_user_create_new_comment_mention_other_user() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.create_new_mention_comment("@Trang");
//    }
//
//    @When("the user click delete comment")
//    public void the_user_click_delete_comment() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.click_del_comment();
//    }
//
//    @When("the user click edit comment")
//    public void the_user_click_edit_comment() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.click_edit_nearly_comment();
//    }
//
//    @When("the user remove media of comment and update text")
//    public void the_user_remove_media_of_comment_and_update_text() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.remove_media_comment("remove media and update text");
//    }
//
//    @When("the user clear and input new comment")
//    public void the_user_clear_and_input_new_comment() {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.clear_and_input_new_comment("new comment auto edit");
//    }
//
//    @When("the user reply comment")
//    public void the_user_reply_comment() {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.reply_mention_comment("reply cmt");
//    }
//
//    @When("the user click pin comment")
//    public void the_user_click_pin_comment() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.pin_comment_on_page();
//    }
//
//    @When("the user click unpin comment")
//    public void the_user_click_unpin_comment() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.unpin_comment_on_page();
//    }
//
//    @Given("the user create new reply comment {string}")
//    public void the_user_create_new_reply_comment(String comment) throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        commentAction.reply_comment(comment);
//    }
//
//
//
//}
