package gapo.pilot.auto2.pages.createnewpost;

import gapo.pilot.auto2.constant.BackgroundPost;
import gapo.pilot.auto2.constant.Timeout;
import gapo.pilot.auto2.helper.InteractionHelper;
import gapo.pilot.auto2.helper.KeyboardHelper;
import gapo.pilot.auto2.helper.UploadMedia;
import gapo.pilot.auto2.pages.navigation.NavigationAction;
import gapo.pilot.auto2.pages.navigation.NavigationElement;
import gapo.pilot.auto2.pages.postlist.PostListElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

import static gapo.pilot.auto2.pages.createnewpost.CreatePostElement.MEDIA_UPLOAD_LIST;

public class CreatePostAction extends UIInteractionSteps {

    @Steps
    InteractionHelper interactionHelper;
    UploadMedia uploadMedia;
    NavigationAction navigationAct;

    //click create new post
    public CreatePostAction clickCreateNewPost() {
        interactionHelper.waitAndClick(CreatePostElement.CREATE_POST_BTN);
        return this;
    }

    //click share post
    public CreatePostAction clickSharePost() {
        interactionHelper.clickByJs($(CreatePostElement.SHARE_BTN), getDriver());
        return this;
    }

    //click update post
    public CreatePostAction clickUpdatePost() {
        interactionHelper.clickByJs($(CreatePostElement.UPDATE_BTN), getDriver());
        return this;
    }

    //click background icon
    public CreatePostAction clickBackgroundIcon() {
        interactionHelper.clickByJs($(CreatePostElement.BACKGROUND_BTN), getDriver());
        return this;
    }

    //select background by index
    public CreatePostAction selectBackgroundByIndex(String background) {
        String backgroundId = "";
        //get backgroundId by name
        switch (background) {
            case "covid":
                backgroundId = BackgroundPost.COVID.getId();
                break;
            case "white_leaf":
                backgroundId = BackgroundPost.WHILE_LEAF.getId();
                break;
            case "orange":
                backgroundId = BackgroundPost.ORANGE.getId();
                break;
            case "white_cloud":
                backgroundId = BackgroundPost.WHITE_CLOUD.getId();
                break;
            default:
                break;
        }
        interactionHelper.clickByJs($(CreatePostElement.getBackgroundByIndex(backgroundId)), getDriver());

        return this;
    }

    //click mention name
    public CreatePostAction selectMentionedName(String name) {
        interactionHelper.clickByJs($(CreatePostElement.getMentionUserByName(name)), getDriver());
        return this;
    }

    //select privacy of post
    public CreatePostAction selectPostPrivacy(String privacy) {
        $(CreatePostElement.PRIVACY_BTN).click();
        $(CreatePostElement.getPrivacyPost(privacy)).click();
        return this;
    }

    //select type to post
    public CreatePostAction selectTypeToPost(String name) {
        interactionHelper.waitAndClick(CreatePostElement.getPostTypeBtn(name));
        waitFor(Timeout.SHORT_TIME.getTimeOut()).milliseconds();
        return this;
    }


    //input text to post area
    public CreatePostAction inputTextToPostArea(String type, String content) throws AWTException {
        KeyboardHelper.pressSpaceKey();
        $(CreatePostElement.POST_TEXT_AREA).sendKeys(content);

        //If the content is link, need to wait until the thumb and title displayed
        switch (type) {
            case "link":
                interactionHelper.waitUntilElementPresent(CreatePostElement.POST_LINK_TITLE);
                interactionHelper.waitUntilElementPresent(CreatePostElement.POST_LINK_IMAGE);
                break;
            case "mention":
                int index = content.indexOf("@");
                content = content.substring(index + 1, content.length());
                selectMentionedName(content);
                break;
            default:
        }
        return this;
    }

    //wait until success upload
    public CreatePostAction waitForUploadSuccess() {
        waitFor(Timeout.LONG_TIME.getTimeOut()).milliseconds();
        waitFor(ExpectedConditions.invisibilityOfElementLocated(CreatePostElement.PROGRESS_UPLOAD));
        return this;
    }

    //upload media to post
    public int uploadMediaToPost(String total, String imageName, String mediaType) throws AWTException {
        selectTypeToPost("Ảnh");
        uploadMedia.robot_upload_media(total, imageName, mediaType);
        waitForUploadSuccess();
        //get list of uploaded media
        java.util.List<WebElement> uploadList = getDriver().findElements(MEDIA_UPLOAD_LIST);
        System.out.println("Upload Size:" + uploadList.size());
        return uploadList.size();
    }

    //handle video post: need to wait for having notification badge then reload page to see new post
    public CreatePostAction waitForNewMediaPost(String imageName) {
        //handle video
        if (imageName.equalsIgnoreCase("video")) {

            getDriver().navigate().refresh();
            //wait for badge of notification and click to it
            if ($(NavigationElement.NOTIFICATION_BADGE).isPresent()) {
                navigationAct.clickNotificationBadge();
                //close the notification
                navigationAct.clickNotiMenu();
                //reload to see new post
            } else {
                waitFor(Timeout.LONG_TIME.getTimeOut()).milliseconds();
            }
            getDriver().navigate().refresh();
        }
        return this;
    }

    @Step("Create new mention post")
    public CreatePostAction selectNameToMention(String mentionedName) {
        //remove @
        int index = mentionedName.indexOf("@");
        mentionedName = mentionedName.substring(index + 1, mentionedName.length());
        System.out.println("Selected Mention:" + mentionedName);
        return this;
    }

    @Step("create emoji post")
    public void create_emoji_post() throws InterruptedException {
        clickCreateNewPost();
        $(CreatePostElement.POST_EMOJI_ICON).click();
        interactionHelper.clickByJs($(CreatePostElement.EMOJI_GRINNING), getDriver());
        interactionHelper.clickByJs($(CreatePostElement.EMOJI_GRIN), getDriver());
        clickSharePost();
    }

    /*
     ****************************************** Edit post *********************************************
     */

    //action: remove media then return the size of media list
    @Step("Remove media")
    public int removeMedia(String numberOfMedia) {
        java.util.List<WebElement> removeMediaList = getDriver().findElements(CreatePostElement.REMOVE_MEDIA);
        if (numberOfMedia.equalsIgnoreCase("all")) {
            for (WebElement e : removeMediaList) {
                interactionHelper.clickByJs(e, getDriver());
            }
        } else {
            int number = Integer.parseInt(numberOfMedia);
            for (int i = 0; i < number; i++) {
                interactionHelper.clickByJs(removeMediaList.get(i), getDriver());
            }
        }
        java.util.List<WebElement> uploadMediaList = getDriver().findElements(MEDIA_UPLOAD_LIST);
        int sizeUploadAfterRemove = uploadMediaList.size();
        clickUpdatePost();
        return sizeUploadAfterRemove;
    }

    //action: edit post by adding new media then return the new media list
    @Step("Add new media on post")
    public int addNewMediaOnPost(String total, String imageName, String mediaType) throws AWTException {
        int uploadSize = uploadMediaToPost(total, imageName, mediaType);
        clickUpdatePost();
        waitForNewMediaPost(imageName);
        return uploadSize;
    }

    @Step("Edit privacy post")
    public void edit_privacy_post() throws InterruptedException {
        interactionHelper.clickByJs($(PostListElement.EDIT_POST_OPTION), getDriver());
        interactionHelper.clickByJs($(CreatePostElement.PRIVACY_BTN), getDriver());
        $(CreatePostElement.PRIVACY).click();
        interactionHelper.clickByJs($(CreatePostElement.UPDATE_BTN), getDriver());
    }

    @Step("Remove background on post")
    public CreatePostAction removeBackgroundPost() throws InterruptedException {
        interactionHelper.clickByJs($(CreatePostElement.BACKGROUND_BTN), getDriver());
        interactionHelper.clickByJs($(CreatePostElement.NO_BACKGROUND_OPTION), getDriver());
        return this;
    }

    /*
     *********************************** Tag User ********************************************
     */
    @Step
    public CreatePostAction inputTextToSearchTag(String name) {
        interactionHelper.waitAndType(name, CreatePostElement.SEARCH_USER_TO_TAG_TXT);
        return this;
    }

    @Step
    public CreatePostAction selectUserNameFromSearchResults(String name) {
        $(CreatePostElement.getUserNameInSearchResults(name)).click();
        return this;
    }

    @Step
    public CreatePostAction clickDone() {
        $(CreatePostElement.Done_ON_SEARCH_TAG_BTN).click();
        return this;
    }

    public void pasteContentToPostArea(){
        $(CreatePostElement.POST_TEXT_AREA).sendKeys(Keys.CONTROL+ "v");
    }


}
