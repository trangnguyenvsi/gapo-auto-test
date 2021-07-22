//package gapo.pilot.auto2.pages;
//
//import gapo.pilot.auto2.helper.ClickHelper;
//import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Step;
//import net.thucydides.core.annotations.Steps;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//
//public class ReactAction extends UIInteractionSteps {
//    @Steps
//    ClickHelper clickHelper;
//
//    @Step("click react post")
//    public void click_react_post() throws InterruptedException {
//        clickHelper.click_by_js($(React.REACT_BTN_LIKE_POST), getDriver());
//        clickHelper.click_by_js($(React.REACT_CHECK_BTN_POST), getDriver());
//        $(PagePage.EXIT_BTN).click();
//    }
//
//    @Step("click react cmt")
//    public void click_react_cmt() throws InterruptedException {
//        clickHelper.click_by_js($(React.REACT_BTN_LOVE_CMT), getDriver());
//        clickHelper.click_by_js($(React.REACT_CHECK_BTN_CMT), getDriver());
//        $(PagePage.EXIT_BTN).click();
//    }
//
//    @Step("click react reply cmt")
//    public void click_react_reply_cmt() throws InterruptedException {
//        clickHelper.click_by_js($(React.VIEW_MORE_COMMENT), getDriver());
//        clickHelper.click_by_js($(React.REACT_BTN_HAHA_REPLY_CMT), getDriver());
//        clickHelper.click_by_js($(React.REACT_CHECK_BTN_REPLY_CMT),getDriver());
//        $(PagePage.EXIT_BTN).click();
//    }
//
//    @Step ("click change react on post")
//    public void click_change_react_on_post() throws InterruptedException {
//        clickHelper.click_by_js($(UserTimelineElement.STATUS_OF_POST),getDriver());
//        Actions builder = new Actions(getDriver());
//        Actions hoverReactPost = builder.moveToElement($(React.REACT_ACTIVE_POST));
//        hoverReactPost.perform();
//        clickHelper.click_by_js($(React.REACT_BTN_LOVE_POST), getDriver());
//    }
//
//    @Step ("click change react on cmt")
//    public void click_change_react_on_cmt() throws InterruptedException {
//        Actions builder = new Actions(getDriver());
//        Actions hoverReactPost = builder.moveToElement($(React.UNREACT_CMT));
//        hoverReactPost.perform();
//        clickHelper.click_by_js($(React.REACT_BTN_LIKE_CMT), getDriver());
//    }
//
//    @Step ("click change react on reply cmt")
//    public void click_change_react_on_reply_cmt() throws InterruptedException {
//        Actions builder = new Actions(getDriver());
//        Actions hoverReactPost = builder.moveToElement($(React.UNREACT_REPLY_CMT));
//        hoverReactPost.perform();
//        clickHelper.click_by_js($(React.REACT_BTN_WOW_REPLY_CMT), getDriver());
//    }
//
//    @Step("click unreact on post")
//    public void click_unreact_on_post() throws InterruptedException {
//        clickHelper.click_by_js($(React.REACT_ACTIVE_POST),getDriver());
//    }
//
//    @Step("click unreact on cmt")
//    public void click_unreact_on_cmt() throws InterruptedException {
//        clickHelper.click_by_js($(React.UNREACT_CMT), getDriver());
//    }
//
//    @Step("click unreact on reply cmt")
//    public void click_unreact_on_reply_cmt() throws InterruptedException {
//        clickHelper.click_by_js($(React.UNREACT_REPLY_CMT), getDriver());
//    }
//}
