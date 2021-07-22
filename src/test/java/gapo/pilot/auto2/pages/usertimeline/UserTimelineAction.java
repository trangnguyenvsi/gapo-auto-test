package gapo.pilot.auto2.pages.usertimeline;

import gapo.pilot.auto2.helper.InteractionHelper;
import gapo.pilot.auto2.pages.postlist.PostListElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class UserTimelineAction extends UIInteractionSteps {
    @Steps
    InteractionHelper interactionHelper;


    @Step("Get profile name")
    public String get_profile_name(){
        return $(UserTimelineElement.USER_NAME).getText();
    }

    @Step("click view detail")
    public void view_post_detail() throws InterruptedException {
        interactionHelper.clickByJs($(PostListElement.STATUS_OF_POST),getDriver());
        getDriver().navigate().back();
    }

    @Step("del post on timeline")
    public void del_post_on_timeline() throws InterruptedException {
        interactionHelper.clickByJs($(PostListElement.DELETE_POST_OPTION),getDriver());
        $(PostListElement.CONFIRM_YES_POST).click();
    }

//    @Step("share post on timeline")
//    public void share_post(String content) throws InterruptedException {
//        clickHelper.click_by_js($(PostListElement.SHARE_POST_OPTION),getDriver());
//        $(CreateNewPost.POST_TEXT_AREA).sendKeys(content);
//        $(PostListElement.SHARE_POST_BTN).click();
//        TimeUnit.SECONDS.sleep(2);
//        clickHelper.click_by_js($(PagePage.EXIT_BTN), getDriver());
////        String pop_up_share = $(PagePage.POPUP_SHARE).getText();
//        assertThat(pop_up_share);
//    }

    @Step("go to update info")
    public void go_to_update_info() throws InterruptedException {
        interactionHelper.clickByJs($(UserTimelineElement.UPDATE_INFO_PROFILE), getDriver());
    }

    @Step("update favourite")
    public void update_favourite() throws InterruptedException {
        interactionHelper.clickByJs($(UserTimelineElement.FAVOURITE), getDriver());
        interactionHelper.clickByJs($(UserTimelineElement.FAVOURITE_CHOICE), getDriver());
        interactionHelper.clickByJs($(UserTimelineElement.SAVE_INFO_BTN), getDriver());
    }

    @Step("update cover")
    public void update_cover(String src) throws InterruptedException, AWTException {
        $(UserTimelineElement.UPDATE_COVER).click();
        $(UserTimelineElement.UPADTE_COVER_LOAD).click();
        Robot robot = new Robot();
        StringSelection str = new StringSelection(src);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        TimeUnit.SECONDS.sleep(3);
        interactionHelper.clickByJs($(UserTimelineElement.SAVE_BTN),getDriver());
    }

    @Step("update avt")
    public void update_avt(String src) throws InterruptedException, AWTException {
        interactionHelper.clickByJs($(UserTimelineElement.AVT_UPDATE), getDriver());
        Robot robot = new Robot();
        StringSelection str = new StringSelection(src);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        TimeUnit.SECONDS.sleep(3);
        interactionHelper.clickByJs($(UserTimelineElement.SAVE_BTN), getDriver());
    }

    @Step("view avt")
    public void click_view_avt() throws InterruptedException {
        interactionHelper.clickByJs($(UserTimelineElement.AVT_VIEW_BTN), getDriver());
    }
}
