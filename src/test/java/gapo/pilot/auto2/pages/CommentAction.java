//package gapo.pilot.auto2.pages;
//
//import gapo.pilot.auto2.helper.ClickHelper;
//import gapo.pilot.auto2.pages.postlist.PostListElement;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Step;
//import net.thucydides.core.annotations.Steps;
//import org.openqa.selenium.Keys;
//
//import java.awt.*;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.util.concurrent.TimeUnit;
//
//public class CommentAction extends UIInteractionSteps {
//    @Steps
//    ClickHelper clickHelper;
//
//    @Step("Create new comment")
//    public void create_new_comment(String comment) throws InterruptedException {
////        clickHelper.click_by_js($(UserTimelineElement.STATUS_OF_POST), getDriver());
//        $(Comment.CMT_TEXT).sendKeys(comment);
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Create new comment with sticker")
//    public void create_new_comment_with_sticker() throws InterruptedException {
//        clickHelper.click_by_js($(Comment.CMT_STICKER_BTN), getDriver());
//        $(Comment.STICKER).click();
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Create new comment with emoji")
//    public void create_new_comment_with_emoji() throws InterruptedException {
//        clickHelper.click_by_js($(Comment.CMT_EMOJI_BTN), getDriver());
//        $(Comment.EMOJI).click();
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Create new media comment")
//    public void create_new_comment_with_image(String src) throws InterruptedException, AWTException {
//        clickHelper.click_by_js($(Comment.CMT_IMAGE_BTN), getDriver());
//        Robot robot = new Robot();
//        StringSelection str = new StringSelection(src);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//        robot.delay(250);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
////        settime waiting for media upload
//        TimeUnit.SECONDS.sleep(5);
//        $(Comment.CMT_TEXT).sendKeys("day la text");
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Create new metion comment")
//    public void create_new_mention_comment(String comment) throws InterruptedException {
//        $(Comment.CMT_TEXT).sendKeys(comment);
//        $(CreateNewPost.MENTION_USER).click();
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Click edit comment")
//    public void click_edit_nearly_comment() throws InterruptedException {
//        clickHelper.click_by_js($(Comment.VIEW_MORE_OPTION), getDriver());
//        clickHelper.click_by_js($(Comment.EDIT_CMT_BTN), getDriver());
//    }
//
//    @Step("Click del comment")
//    public void click_del_comment() throws InterruptedException {
//        clickHelper.click_by_js($(Comment.VIEW_MORE_OPTION), getDriver());
//        clickHelper.click_by_js($(Comment.DEL_CMT_BTN), getDriver());
//        $(PostListElement.CONFIRM_YES_POST).click();
//    }
//
//    @Step("remove media of comment")
//    public void remove_media_comment(String newt) throws InterruptedException {
//        clickHelper.click_by_js($(CreateNewPost.MEDIA),getDriver());
//        $(Comment.CMT_TEXT).sendKeys(newt);
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("clear and input new comment")
//    public void clear_and_input_new_comment(String newt){
//        $(Comment.CMT_TEXT).clear();
//        $(Comment.CMT_TEXT).sendKeys(newt);
//        $(Comment.CMT_TEXT).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Reply mention comment")
//    public void reply_mention_comment(String content){
//        $(Comment.REPLY_BTN).click();
//        $(Comment.CMT_TEXT_REPLY).sendKeys(content);
//        $(Comment.CMT_TEXT_REPLY).sendKeys(Keys.ENTER);
//    }
//
//    @Step("Reply comment")
//    public void reply_comment(String content) throws InterruptedException {
//        clickHelper.click_by_js($(Comment.REPLY_BTN), getDriver());
//        $(Comment.CMT_TEXT_REPLY).sendKeys(content);
//        $(Comment.CMT_TEXT_REPLY).sendKeys(Keys.ENTER);
//    }
//
//    @Step("pin comment on page")
//    public void pin_comment_on_page() throws InterruptedException {
//        clickHelper.click_by_js($(Comment.VIEW_MORE_OPTION), getDriver());
//        clickHelper.click_by_js($(Comment.PIN_CMT_BTN), getDriver());
//        $(PostListElement.CONFIRM_YES_POST).click();
//    }
//
//    @Step("unpin comment on page")
//    public void unpin_comment_on_page() throws InterruptedException {
//        getDriver().navigate().refresh();
//        clickHelper.click_by_js($(Comment.VIEW_MORE_OPTION2), getDriver());
//        clickHelper.click_by_js($(Comment.UNPIN_CMT_BTN), getDriver());
//        $(PostListElement.CONFIRM_YES_POST).click();
//    }
//
//}
