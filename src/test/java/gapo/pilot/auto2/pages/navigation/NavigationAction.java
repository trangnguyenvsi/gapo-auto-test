package gapo.pilot.auto2.pages.navigation;

import gapo.pilot.auto2.helper.InteractionHelper;
import gapo.pilot.auto2.pages.createnewpost.CreatePostElement;
import gapo.pilot.auto2.pages.postlist.PostListElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class NavigationAction extends UIInteractionSteps {
    @Steps
    InteractionHelper interactionHelper;

    @Step("ignore suggest friend and select subject on home page")
    public NavigationAction navigateOnHomepage() throws InterruptedException {
        if ($(NavigationElement.IGNORE_BTN).isPresent()) {
            $(NavigationElement.IGNORE_BTN).click();
            Thread.sleep(1000);
        }
        if ($(NavigationElement.IGNORE_BTN).isPresent()) {
            $(NavigationElement.IGNORE_BTN).click();
            interactionHelper.clickByJs($(NavigationElement.GIFT_BTN), getDriver());
        }
        return this;
    }

    @Step("go to timeline")
    public NavigationAction goToTimeline(){
        interactionHelper.waitAndClick(NavigationElement.AVATAR_LINK);
        interactionHelper.waitAndClick(NavigationElement.PROFILE_LINK);
        return this;
    }

    @Step("logout")
    public NavigationAction logout() {
        interactionHelper.waitAndClick(NavigationElement.AVATAR_LINK);
        interactionHelper.waitAndClick(NavigationElement.LOGOUT_BTN);
        return this;
    }

    @Step("select Home icon")
    public NavigationAction goToHomePgae(){
        interactionHelper.waitAndClick(NavigationElement.HOME_ICON);
        return this;
    }

    @Step("click to notification badge")
    public void clickNotificationBadge(){
        waitFor(3000).milliseconds();
        interactionHelper.waitAndClick(NavigationElement.NOTIFICATION_BADGE);
    }
    @Step("click Noti tab")
    public void clickNotiMenu(){
        interactionHelper.waitAndClick(NavigationElement.NOTIFICATION_MENU);
    }

}
