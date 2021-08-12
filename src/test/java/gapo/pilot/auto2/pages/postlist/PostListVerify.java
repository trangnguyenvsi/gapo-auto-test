package gapo.pilot.auto2.pages.postlist;

import gapo.pilot.auto2.constant.BackgroundPost;
import gapo.pilot.auto2.constant.PrivacyPost;
import gapo.pilot.auto2.helper.ElementHelper;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PostListVerify extends UIInteractionSteps {

    PrivacyPost privacyPost;
    PostListAction postListAct;
    ElementHelper elementHelper;


    @Step("verify post text")
    public PostListVerify verifyPostText(String expectedText) {
        String actualPostContentText = postListAct.getContentTextOfPost();
        System.out.println("Actual:" + actualPostContentText);
        System.out.println("Expected:" + expectedText);
        assertThat(actualPostContentText.equals(expectedText)).isTrue();
        return this;
    }

    @Step("verify post hashtag")
    public PostListVerify verifyPostHashtag(String expectedText) {
        System.out.println("Post Hashtag");
        String hashtagUrl = postListAct.getUrlOfHashtagPage();
        assertThat(hashtagUrl.contains(expectedText));
        return this;
    }

    @Step("verify post media")
    public PostListVerify verifyPostMedia(int uploadSize, int actualSize) {

        if (uploadSize <= 5) {
            assertThat(uploadSize == actualSize).isTrue();
        } else {
            int morePhoto = uploadSize - 5;
            String expectedMorePhoto = String.valueOf(morePhoto);
            assertThat(actualSize == 5).isTrue();
            assertThat(postListAct.getMorePhoto().contains(expectedMorePhoto));

        }
        return this;
    }

    @Step("verify preview link")
    public PostListVerify verifyPostPreviewLink() {
        System.out.println("Preview link");
        boolean imagePresent = postListAct.getStatusOfPreviewLinkThumb();
        boolean titlePresent = postListAct.getStatusOfPreviewLinkTitle();
        assertThat(imagePresent).isTrue();
        assertThat(titlePresent).isTrue();
        return this;
    }

    @Step("verify after delete post")
    public PostListVerify verifyDeletePost(int sizeAfterDelete, int sizeBeforeDelete) {
        System.out.println("after:" + sizeAfterDelete);
        System.out.println("before:" + sizeBeforeDelete);
        assertThat(sizeAfterDelete == sizeBeforeDelete - 1).isTrue();
        return this;
    }

    @Step("verify background of post")
    public PostListVerify verifyPostBackground(String inputName) {
        String actualBackgroundId = postListAct.getBackgroundIdOfPost();
        for (BackgroundPost background : BackgroundPost.values()) {
            if (inputName.equalsIgnoreCase(background.getName())) {
                assertThat(actualBackgroundId.contains(background.getId()));
            }
        }
        return this;
    }

    @Step("verify no background of post")
    public PostListVerify verifyPostNoBackground() {
        String actualBackgroundId = postListAct.getBackgroundIdOfPost();
        assertThat(actualBackgroundId.contains("")).isTrue();
        return this;
    }

    @Step("verify mention user")
    public PostListVerify verifyMentionedUser(String userName, String mentionedUser) {
        assertThat(mentionedUser.contains(userName));
        return this;
    }

    @Step("verify privacy of post")
    public PostListVerify verifyViewPostByPrivacy(DataTable dataTable) {
        java.util.List<Map<String, String>> viewPosByPrivacyList = dataTable.asMaps(String.class, String.class);
        boolean viewPost;

        for (Map<String, String> viewPostByPrivacy : viewPosByPrivacyList) {
            String view = viewPostByPrivacy.get("view");
            String content = viewPostByPrivacy.get("postContent");
            System.out.println("View:" + view);
            System.out.println("Content:" + content);

            viewPost = postListAct.viewPostStatus(content);
            if (view.equalsIgnoreCase("Yes")) {
                assertThat(viewPost).isTrue();
            } else
                assertThat(viewPost).isFalse();
        }
        return this;

    }

    @Step("verify post question")
    public PostListVerify verifyPostQuestion() {
        String userNameCreatePost = postListAct.getUserNameCreatePost();
        String userNameOnQuestion = postListAct.getUserNameOnQuestion();
        String avatarImageIdOfUserCreatePost = postListAct.getAvatarImageIdOfUserCreatePost();
        String avatarImageIdOnQuestion = postListAct.getAvatarImageIdOnQuestion();
        Boolean presentOfButton = postListAct.getStatusPresentOfButtonOnQuestion();
        //verify avatar
        assertThat(avatarImageIdOfUserCreatePost.equals(avatarImageIdOnQuestion)).isTrue();
        //verify name
        assertThat(userNameOnQuestion.contains(userNameCreatePost)).isTrue();
        //verify button
        assertThat(presentOfButton).isTrue();
        return this;
    }

    @Step("verify privacy icon")
    public PostListVerify verifyPrivacyOfPostByIcon(String privacy, String actualPrivacyName) {

        String privacyName = "";
        switch (privacy) {
            case "only_me":
                privacyName = PrivacyPost.PRIVATE.getPrivacy();
                System.out.println("privacy:" + privacyName);
                break;
            case "friends":
                privacyName = PrivacyPost.FRIENDS.getPrivacy();
                break;
            case "in_company":
                privacyName = PrivacyPost.IN_COMPANY.getPrivacy();
                break;
        }
        assertThat(privacyName.equals(actualPrivacyName)).isTrue();
        return this;
    }

    @Step("verify author of post ")
    public PostListVerify verifyAuthorOfPost(String tagName, String tagNumber) {
        String author = postListAct.getUserNameCreatePost();
        String fullAuthor = author + " cùng với " + tagName + " và " + tagNumber + " người khác";
        String actualFullAuthor = postListAct.getFullAuthorListOfFirstPost();
        System.out.println("Actual Author:" + actualFullAuthor);
        System.out.println("full Author:" + fullAuthor);
        assertThat(actualFullAuthor.equals(fullAuthor)).isTrue();
        return this;
    }

    @Step("verify detail tag list")
    public PostListVerify verifyDetailTagList(List<String> expectedTagList) {
        List<String> actualTagList = elementHelper.getValueListByElement(PostListElement.TAG_LIST_DETAIL, "textContent");
        System.out.println("Actual Tag List:" + actualTagList);
//        assertThat(actualTagList.equals(expectedTagList)).isTrue();
        assertThat(actualTagList.containsAll(expectedTagList) && expectedTagList.containsAll(actualTagList)).isTrue();
        return this;
    }

    @Step("verify post content by privacy")
    public PostListVerify verifyPostContentByView(String view, String content) {
        if (view.equalsIgnoreCase("yes")) {
            assertThat(postListAct.viewPostStatus(content)).isTrue();
        } else {
            assertThat(postListAct.viewPostStatus(content)).isFalse();
        }
        return this;
    }
}
