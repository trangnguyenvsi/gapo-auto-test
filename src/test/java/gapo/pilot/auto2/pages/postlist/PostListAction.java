package gapo.pilot.auto2.pages.postlist;

import gapo.pilot.auto2.helper.ElementHelper;
import gapo.pilot.auto2.helper.InteractionHelper;
import gapo.pilot.auto2.helper.WebNavigationHelper;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;

import java.util.List;

import static gapo.pilot.auto2.pages.postlist.PostListElement.MEDIA_LIST_POST;

public class PostListAction extends UIInteractionSteps {
    @Steps
    InteractionHelper interactionHelper;
    ElementHelper elementHelper;
    WebNavigationHelper webNavigationHelper;

    @Step("click view detail")
    public PostListAction viewPostDetail() {
        interactionHelper.clickByJs($(PostListElement.STATUS_OF_POST), getDriver());
        return this;
    }

    @Step("del post on timeline")
    public PostListAction delPostOnTimeline() {
        interactionHelper.clickByJs($(PostListElement.DELETE_POST_OPTION), getDriver());
        $(PostListElement.CONFIRM_YES_POST).click();
        return this;
    }

    //*******************************************************************************
    //get media number of new post
    @Step("get number of media in one post")
    public int getListMediaPost() {
        List<WebElement> mediaList = getDriver().findElements(MEDIA_LIST_POST);
        return mediaList.size();
    }

    //Get more photo
    public String getMorePhoto() {
        String more_photo = $(PostListElement.MORE_PHOTO_LABEL).getText();
        System.out.println("More photo:" + more_photo);
        return more_photo;
    }

    //Get content text of post
    public String getContentTextOfPost() {
        String content = $(PostListElement.POST_CONTENT_TEXT).getText();
        return content;
    }

    @Step("Get url of hashtag page")
    public String getUrlOfHashtagPage() {
        interactionHelper.clickByJs($(PostListElement.POST_HASHTAG_LINK), getDriver());
        String currentUrl = getDriver().getCurrentUrl();
        webNavigationHelper.backward();
        return currentUrl;
    }

    @Step("click to other author")
    public PostListAction clickToOtherAuthor() {
//        interactionHelper.waitAndClick(PostListElement.OTHER_AUTHOR_POST);
        interactionHelper.clickByJs($(PostListElement.OTHER_AUTHOR_POST),getDriver());
        return this;
    }

    @Step("close tag list detail")
    public PostListAction closeTagListDetail() {
//        interactionHelper.waitAndClick(PostListElement.CLOSE_TAG_LIST_DETAIL_ICON);
        $(PostListElement.CLOSE_TAG_LIST_DETAIL_ICON).click();
        return this;
    }

    @Step("Get status of preview link thumb")
    public boolean getStatusOfPreviewLinkThumb() {
        return $(PostListElement.PREVIEW_LINK_THUMB).isPresent();
    }

    @Step("Get status of preview link title")
    public boolean getStatusOfPreviewLinkTitle() {
        return $(PostListElement.PREVIEW_LINK_TITLE).isPresent();
    }

    @Step("Get background ID of post")
    public String getBackgroundIdOfPost() {
        String id = $(PostListElement.BACKGROUND_OF_POST).getAttribute("style");
        System.out.println("Background ID:" + id);
        return id;
    }

    @Step("Click mention post")
    public void clickMentionPost(String name) {
        interactionHelper.clickByJs($(PostListElement.getMentionedName(name)), getDriver());
    }

    @Step("Get list of post content")
    public List<String> getListOfPostContent() {
        return elementHelper.getValueListByElement(PostListElement.CONTENT_POST_LIST, "textContent");
    }

    @Step("View post content by privacy")
    public boolean viewPostContentByPrivacy(String content) {
        List<String> contentList = getListOfPostContent();
        System.out.println("List content:" + contentList);
        return contentList.contains(content);
    }

    @Step("Select view more option")
    public PostListAction selectViewMoreOption() {
        interactionHelper.clickByJs($(PostListElement.VIEW_MORE_OPTION), getDriver());
        return this;
    }

    @Step("Select delete post option")
    public PostListAction selectDeletePostOption() {
        interactionHelper.clickByJs($(PostListElement.DELETE_POST_OPTION), getDriver());
        return this;
    }

    @Step("Delete new post")
    public PostListAction deleteNewPost() {
        interactionHelper.clickByJs($(PostListElement.CONFIRM_POPUP_YES), getDriver());
        return this;
    }


    @Step("Delete Post")
    public PostListAction deleteAllPost(String confirmation) {
        List<WebElement> postList = getDriver().findElements(PostListElement.VIEW_MORE_OPTION_LIST);

        int postListSize = postList.size();
        while (postListSize > 0) {
            System.out.println($(PostListElement.END_OF_PAGE).isPresent());
            System.out.println("Size:" + postList.size());
            for (int i = 0; i < postList.size(); i++) {
                selectViewMoreOption();
                selectDeletePostOption();
                deleteNewPost();
                postListSize = postListSize - 1;
            }
        }
        return this;
    }

    @Step("Select edit post")
    public PostListAction selectEditPostOption() {
        interactionHelper.clickByJs($(PostListElement.EDIT_POST_OPTION), getDriver());
        return this;
    }

    @Step("Get size of post list")
    public int getSizeOfPostList() {
        waitForAbsenceOf("//button[text()='Chia sẻ']");
        return elementHelper.getSizeOfListElement(PostListElement.CONTENT_POST_LIST);
    }

    //****************************************** Get information of post **********************************************

    public String getUserNameCreatePost() {
        return $(PostListElement.USER_NAME_CREATE_POST).getText();
    }

    public String getAvatarImageIdOfUserCreatePost() {
        return $(PostListElement.AVATAR_USER_CREATE_POST).getAttribute("src");
    }

    public String getAvatarImageIdOnQuestion() {
        return $(PostListElement.AVATAR_USER_ON_QUESTION_POST).getAttribute("src");
    }

    public String getUserNameOnQuestion() {
        return $(PostListElement.USER_NAME_ON_QUESTION_POST).getText();
    }

    public boolean getStatusPresentOfButtonOnQuestion() {
        return $(PostListElement.QUESTION_BUTTON_ON_QUESTION_POST).isPresent();
    }

    public String getPrivacyNameFromIcon() {
        return $(PostListElement.PRIVACY_POST_ICON).getAttribute("data-title");
    }

    public String getFullAuthorListOfFirstPost() {
        return $(PostListElement.AUTHOR_OF_FIRST_POST).getText();
    }

    public PostListAction deletePostByNumber(String number) {
        int numberOfPost = Integer.parseInt(number);
        for (int i = 0; i < numberOfPost; i++) {
            selectViewMoreOption();
            selectDeletePostOption();
            deleteNewPost();
        }
        return this;
    }
}
