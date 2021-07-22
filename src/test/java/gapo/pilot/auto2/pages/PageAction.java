//package gapo.pilot.auto2.pages;
//
//import gapo.pilot.auto2.helper.ClickHelper;
//import gapo.pilot.auto2.helper.UploadMedia;
//import gapo.pilot.auto2.pages.usertimeline.UserTimelineElement;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Step;
//import net.thucydides.core.annotations.Steps;
//import org.openqa.selenium.JavascriptExecutor;
//
//import java.awt.*;
//import java.util.concurrent.TimeUnit;
//
//public class PageAction extends UIInteractionSteps {
//    @Steps
//    ClickHelper clickHelper;
//    UploadMedia uploadMedia;
//
//    @Step("Create new post")
//    public void create_new_post(String content) throws InterruptedException {
//        $(CreateNewPost.CREATE_POST_BTN).click();
//        $(CreateNewPost.POST_TEXT_AREA).sendKeys(content);
//        clickHelper.click_by_js($(PagePage.SHARE_NOW_BTN),getDriver());
//    }
//
//    @Step("Draft post")
//    public void draft_post(String content) throws InterruptedException {
//        $(CreateNewPost.CREATE_POST_BTN).click();
//        $(CreateNewPost.POST_TEXT_AREA).sendKeys(content);
//        clickHelper.click_by_js($(PagePage.DRAFT_BTN),getDriver());
//        $(PagePage.CONFIRM_YES_BTN).click();
//    }
//
//    @Step("go to setting draft")
//    public void setting_draf_post() throws InterruptedException {
//        $(PagePage.SETTING_BTN).click();
//        clickHelper.click_by_js($(PagePage.DRAFT_POST_LIST), getDriver());
//        getDriver().navigate().back();
//    }
//
//    @Step("Event post")
//    public void event_post(String content) throws InterruptedException {
//        $(CreateNewPost.CREATE_POST_BTN).click();
//        $(CreateNewPost.POST_TEXT_AREA).sendKeys(content);
//        clickHelper.click_by_js($(PagePage.EVENT_BTN),getDriver());
//        clickHelper.click_by_js($(PagePage.CONFIRM_EVENT_BTN),getDriver());
//        clickHelper.click_by_js($(PagePage.EVENT_SHARE_BTN), getDriver());
//        $(PagePage.CONFIRM_YES_BTN).click();
//    }
//
//    @Step("go to setting event")
//    public void setting_event_post() throws InterruptedException {
//        clickHelper.click_by_js($(PagePage.SETTING_BTN), getDriver());
//        clickHelper.click_by_js($(PagePage.EVENT_POST_LIST), getDriver());
//        getDriver().navigate().back();
//    }
//
//    @Step("Create background post on page")
//    public void create_new_background_post_on_page(String content) throws InterruptedException {
//        clickHelper.click_by_js($(CreateNewPost.CREATE_POST_BTN), getDriver());
//        clickHelper.click_by_js($(CreateNewPost.BACKGROUND_BTN), getDriver());
//        clickHelper.click_by_js($(CreateNewPost.get_background_by_index("")), getDriver());
//        $(CreateNewPost.POST_TEXT_AREA).sendKeys(content);
//        clickHelper.click_by_js($(PagePage.SHARE_NOW_BTN),getDriver());
//    }
//
//    @Step("Create new media post on page")
//    public void create_new_media_post_on_page(String src) throws AWTException, InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
////        js.executeScript("window.scrollBy(0,1200)");
//        clickHelper.click_by_js($(CreateNewPost.CREATE_POST_BTN),getDriver());
//        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0,"+$(CreateNewPost.POST_MEDIA).getLocation().x+")");
//        $(CreateNewPost.POST_MEDIA).click();
//    //    uploadMedia.robot_upload_media(src);
//        clickHelper.click_by_js($(PagePage.SHARE_NOW_BTN),getDriver());
//        TimeUnit.SECONDS.sleep(5);
//        getDriver().navigate().refresh();
//    }
//
//    @Step("update avatar page")
//    public void update_avt_page() throws AWTException, InterruptedException {
//        $(PagePage.AVATAR_PAGE).click();
//      //  uploadMedia.robot_upload_media("D:\\DOWNLOAD\\KAZUMAMIT.png");
//        $(PagePage.CONFIRM_YES_BTN).click();
//    }
//
//    @Step("update cover page")
//    public void update_cover_page() throws InterruptedException, AWTException {
//        $(PagePage.COVER_PAGE).click();
//        $(PagePage.CHANGE_PIC_PAGE).click();
//      //  uploadMedia.robot_upload_media("D:\\DOWNLOAD\\KIU_7198.JPG");
//        $(UserTimelineElement.SAVE_BTN).click();
//        $(PagePage.CONFIRM_YES_BTN).click();
//    }
//
//    @Step("delete cover page")
//    public void delete_cover_page(){
//        $(PagePage.COVER_PAGE).click();
//        $(PagePage.DEL_PIC_PAGE).click();
//        $(PagePage.YES_BTN).click();
//    }
//
//    @Step("update bg page")
//    public void update_background_page() throws InterruptedException, AWTException {
//        $(PagePage.BACKGROUND_PAGE).click();
//        clickHelper.click_by_js($(PagePage.CHANGE_PIC_PAGE), getDriver());
//     //   uploadMedia.robot_upload_media("D:\\DOWNLOAD\\EQbEEPQVAAIUem4.jpg");
//        $(PagePage.SAVE_BG_BTN).click();
//        $(PagePage.CONFIRM_YES_BTN).click();
//        getDriver().navigate().refresh();
//    }
//
//    @Step("del bg page")
//    public void delete_background_page() throws InterruptedException {
//        $(PagePage.BACKGROUND_PAGE).click();
//        clickHelper.click_by_js($(PagePage.DEL_PIC_PAGE), getDriver());
//        $(PagePage.YES_BTN).click();
//        getDriver().navigate().refresh();
//    }
//
//    @Step("add admin page")
//    public void add_admin_page() throws InterruptedException {
//        $(PagePage.SETTING_BTN).click();
//        $(PagePage.ADMIN_TEXT).click();
//        $(PagePage.ADMIN_TEXT).sendKeys("Trang");
//        clickHelper.click_by_js($(PagePage.CHOICE_ADMIN), getDriver());
//        $(PagePage.ADD_ADMIN_BTN).click();
//        $(PagePage.YES_BTN).click();
//    }
//
//}
