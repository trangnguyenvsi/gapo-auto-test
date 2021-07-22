package gapo.pilot.auto2.pages.notification;

import gapo.pilot.auto2.helper.ElementHelper;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NotificationAction extends UIInteractionSteps {
    ElementHelper elementHelper;

    @Step("get first avatar notification")
    public String getFirstAvatarNotification() {
        return $(NotificationElement.FIRST_NOTI_AVATAR).getAttribute("src");
    }

    @Step("get first content notification")
    public String getFirstContentNotification() {
        return $(NotificationElement.FIRST_NOTI_CONTENT).getText();
    }

    @Step("get content of first noti tag from list")
    public String getFirstContentOfTagNotiList() {
        List<WebElement> contentList = elementHelper.getListElement(NotificationElement.NOTI_TAG_CONTENT_LIST);
        String firstContent = contentList.get(0).getText();
        return firstContent;
    }

    public Boolean getPresentStatusOfTagNoti(){
       return $(NotificationElement.NOTI_TAG_CONTENT_LIST).isPresent();
    }

    @Step("get size of tag noti list")
    public int getSizeOfTagNotiList() {
        return elementHelper.getSizeOfListElement(NotificationElement.NOTI_TAG_CONTENT_LIST);

    }

    @Step("get size of post noti list")
    public int getSizeOfPostNotiList() {
        return elementHelper.getSizeOfListElement(NotificationElement.NOTI_POST_CONTENT_LIST);

    }
    @Step("get content of first noti post from list")
    public String getFirstContentOfPostNotiList() {
        List<WebElement> contentList = elementHelper.getListElement(NotificationElement.NOTI_POST_CONTENT_LIST);
        String firstContent = contentList.get(0).getText();
        return firstContent;
    }

    @Step("click to first notification")
    public NotificationAction clickToFirstNotification() {
        $(NotificationElement.FIRST_NOTI_CONTENT).click();
        return this;
    }

}
