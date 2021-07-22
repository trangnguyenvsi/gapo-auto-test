package gapo.pilot.auto2.steps;

import gapo.pilot.auto2.CucumberTestSuite;
import gapo.pilot.auto2.helper.StringHelper;
import gapo.pilot.auto2.helper.WebNavigationHelper;
import gapo.pilot.auto2.openurl.UserProfileUrlAction;
import gapo.pilot.auto2.pages.*;
import gapo.pilot.auto2.pages.createnewpost.CreatePostAction;
import gapo.pilot.auto2.pages.navigation.NavigationAction;
import gapo.pilot.auto2.pages.notification.NotificationAction;
import gapo.pilot.auto2.pages.notification.NotificationVerify;
import gapo.pilot.auto2.pages.postlist.PostListAction;
import gapo.pilot.auto2.pages.postlist.PostListVerify;
import gapo.pilot.auto2.pages.search.SearchAction;
import gapo.pilot.auto2.pages.usertimeline.UserTimelineAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.util.Map;


public class CommonPostTest {
    @Steps
    UserTimelineAction userTimelineAction;
    LoginAction loginAction;
    NavigationAction navigationAct;
    SearchAction searchAction;
    CreatePostAction createPostAct;
    PostListAction postListAct;
    PostListVerify postListVerify;
    NotificationVerify notificationVerify;
    NotificationAction notificationAct;
    WebNavigationHelper webNavigationHelper;


    int uploadSize;
    String mentionedUser;
    String inputPrivacy;


    /*
     *********************************** Create post text ************************************
     */
    @When("the user create new text post {string} and {string}")
    public void the_user_create_new_post(String postType, String content) throws AWTException {
        createPostAct.clickCreateNewPost()
                .inputTextToPostArea(postType, content)
                .clickSharePost();
        Serenity.setSessionVariable("content").to(content);
        Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());
        Serenity.setSessionVariable("postType").to(postType);
    }

    @Then("the post content is correct")
    public void the_post_content_is_correct() {
        postListVerify.verifyPostText(getPostContent());
        String postType = getPostType();
        switch (postType) {
            case "hashtag":
                postListVerify.verifyPostHashtag(getPostContent());
                break;
            case "link":
                postListVerify.verifyPostPreviewLink();
                break;
        }

    }

    @When("the user create new long text post")
    public void the_user_create_new_long_text_post() {

    }

    @And("the user input new content to update post {string} and {string}")
    public void the_user_input_new_content_to_update_post(String updatedType, String updatedContent) throws AWTException {
        Serenity.setSessionVariable("postType").to(updatedType);
        createPostAct.inputTextToPostArea(updatedType, updatedContent)
                .clickUpdatePost();
    }

    public String getPostContent() {
        return Serenity.sessionVariableCalled("content").toString();
    }

    public String getPostType() {
        return Serenity.sessionVariableCalled("postType").toString();
    }

    @Then("the user see the updated content correctly")
    public void the_user_see_the_updated_content_correctly() {
        String postType = getPostType();
        postListVerify.verifyPostText(getPostContent());
        switch (postType) {
            case "hashtag":
                postListVerify.verifyPostHashtag(getPostContent());
                break;
            case "link":
                postListVerify.verifyPostPreviewLink();
                break;
        }
    }

    /*
     ***************************** Create post media *****************************
     */
    @When("the user create new media post {string} and {string} and {string} and {string} and {string}")
    public void the_user_create_new_media_post(String total, String mediaName, String mediaType, String textType, String content) throws AWTException {
        createPostAct.clickCreateNewPost()
                .inputTextToPostArea(textType, content);
        uploadSize = createPostAct.uploadMediaToPost(total, mediaName, mediaType);
        createPostAct.waitForUploadSuccess()
                .clickSharePost()
                .waitForNewMediaPost(mediaName);
        Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());

    }

    @When("the user view post detail")
    public void the_user_view_post_detail() {
        postListAct.viewPostDetail();
    }

    @Then("the user see the correct media number on the post")
    public void the_user_see_the_correct_media_number_on_the_post() {
        int actualSize = postListAct.getListMediaPost();
        postListVerify.verifyPostMedia(uploadSize, actualSize);
    }

    @And("the user update the media post {string} and {string} and {string} and {string}")
    public void the_user_update_the_media_post(String action, String numberOfMedia, String mediaName, String mediaType) throws AWTException {
        switch (action) {
            case "remove":
                uploadSize = createPostAct.removeMedia(numberOfMedia);
                System.out.println("upload size when remove:" + uploadSize);
                break;
            case "add":
                uploadSize = createPostAct.addNewMediaOnPost(numberOfMedia, mediaName, mediaType);
                System.out.println("upload size when update by adding:" + uploadSize);
                break;
        }
    }

    /*
     ************************* Post Background ****************************
     */
    @When("the user create new post with background {string} and {string} and {string}")
    public void the_user_create_new_post_with_background_and_and(String textType, String content, String background) throws AWTException {
        createPostAct.clickCreateNewPost()
                .inputTextToPostArea(textType, content)
                .clickBackgroundIcon()
                .selectBackgroundByIndex(background)
                .clickSharePost();
        Serenity.setSessionVariable("background").to(background);
        Serenity.setSessionVariable("content").to(background);
        Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());

    }

    @Then("the user see correct background on post")
    public void the_user_see_correct_background_on_post() {
        String inputBackground = Serenity.sessionVariableCalled("background");
        postListVerify.verifyPostBackground(inputBackground)
                .verifyPostText(getPostContent());
    }

    @And("the user update background and share post {string}")
    public void the_user_update_background_and_share_post(String background) {
        Serenity.setSessionVariable("background").to(background);
        createPostAct.clickBackgroundIcon()
                .selectBackgroundByIndex(background)
                .clickUpdatePost();
    }

    @And("the user remove background")
    public void the_user_remove_background() throws InterruptedException {
        createPostAct.removeBackgroundPost()
                .clickUpdatePost();
    }

    @Then("the user see that the post has no background")
    public void the_user_see_that_the_post_has_no_background() {
        postListVerify.verifyPostNoBackground();

    }

    /*
     ************************** Post Mention *******************************
     */
    @When("the user create new post and mention another user {string} and {string}")
    public void the_user_create_new_post_and_mention_another_user(String textType, String mentionName) throws AWTException {
        mentionedUser = mentionName;
        createPostAct.clickCreateNewPost()
                .inputTextToPostArea(textType, mentionName)
                .clickSharePost();
        Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());
    }

    @When("the user click mention")
    public void the_user_click_mention() {
        String userName = StringHelper.removeSpecialText(mentionedUser);
        System.out.println("User cut @:" + userName);
        postListAct.clickMentionPost(userName);
    }

    @Then("the user see profile name correctly")
    public void the_user_see_profile_name_correctly() {
        String userName = userTimelineAction.get_profile_name();
        postListVerify.verifyMentionedUser(mentionedUser, userName);
    }

    @And("the user add more mention name {string} and {string}")
    public void the_user_add_more_mention_name(String textType, String updatedMentionedName) throws AWTException {
        mentionedUser = updatedMentionedName;
        createPostAct.inputTextToPostArea(textType, updatedMentionedName)
                .clickUpdatePost();
    }


    /*
     ****************************** Post Emoji *****************************************
     */
    @When("the user create new post with emoji")
    public void the_user_create_new_post_with_emoji() {
//        createNewPostAction.create_emoji_post();
    }

    @Then("the post content contains correct emoji")
    public void the_post_content_contains_correct_emoji() {
    }

    /*
     ********************************* Post Privacy ********************************
     */
    @When("the first user create post with privacy")
    public void the_first_user_create_post_with_privacy(DataTable table) throws AWTException {
        java.util.List<Map<String, String>> postList = table.asMaps(String.class, String.class);

        for (Map<String, String> post : postList) {
            String privacy = post.get("privacy");
            String content = post.get("content");
            createPostAct.clickCreateNewPost()
                    .inputTextToPostArea("text", content)
                    .selectPostPrivacy(privacy)
                    .clickSharePost();
            Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());

        }
    }

    public void another_user_login(DataTable dataTable) {
        navigationAct.logout();
        java.util.List<Map<String, String>> accountList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> account : accountList) {
            String email = account.get("email");
            String pass = account.get("pass");
            System.out.println("Email Friend:" + email);
            System.out.println("Pass:" + pass);
            loginAction.login(email, pass);
        }
    }

    @When("the friend login")
    public void the_friend_login_with_account(DataTable dataTable) {
        another_user_login(dataTable);
    }

    @When("the colleague login")
    public void theColleagueLogin(DataTable dataTable) {
        another_user_login(dataTable);
    }

    @And("search the first user and view post list")
    public void search_the_first_user_and_view_post_list(DataTable dataTable) throws AWTException {
        java.util.List<Map<String, String>> searchInputList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> searchInput : searchInputList) {
            String searchText = searchInput.get("searchText");
            String name = searchInput.get("name");
            searchAction.searchOnHomePage(searchText)
                    .selectProfileNameOnSearchResults(name);
        }
    }

    @Then("the friend can view the post with correct privacy")
    public void the_friend_can_view_the_post_with_correct_privacy(DataTable account) {
        postListVerify.verifyViewPostByPrivacy(account);
    }

    @Then("the colleague can view the post with correct privacy")
    public void the_colleague_can_view_the_post_with_correct_privacy(DataTable account) {
        postListVerify.verifyViewPostByPrivacy(account);
    }

    @When("the first user login again")
    public void the_first_user_login_again(DataTable account) {
        another_user_login(account);
    }

    /*
     ******************************* Post Question *************************************
     */
    @When("the user create the question post {string} and {string}")
    public void the_user_create_the_question_post(String textType, String content) throws AWTException {
        Serenity.setSessionVariable("content").to(content);
        createPostAct.clickCreateNewPost()
                .selectTypeToPost("Hỏi đáp")
                .inputTextToPostArea(textType, content)
                .clickSharePost();
        Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());
    }

    @Then("the user see the correct question post")
    public void the_user_see_the_correct_question_post() {
        String inputPostContentText = Serenity.sessionVariableCalled("content").toString();
        postListVerify.verifyPostText(inputPostContentText)
                .verifyPostQuestion();
    }

    @And("the user input new content to update question post {string} and {string}")
    public void theUserInputNewContentToUpdateQuestionPostAnd(String textType, String content) throws AWTException {
        createPostAct.inputTextToPostArea(textType, content)
                .clickUpdatePost();
    }

    /*
     ********************************* Edit  Privacy **********************************
     */
    @And("the user update privacy {string}")
    public void the_user_update_privacy(String privacy) {
        createPostAct.selectPostPrivacy(privacy)
                .clickUpdatePost();
        inputPrivacy = privacy;
    }

    @Then("the privacy is update correctly")
    public void the_privacy_is_update_correctly() {
        String actualPrivacyName = postListAct.getPrivacyNameFromIcon();
        System.out.println("actual privacy:" + actualPrivacyName);
        postListVerify.verifyPrivacyOfPostByIcon(inputPrivacy, actualPrivacyName);
    }

    /*
     ******************************** Edit post ***************************************
     */
    @And("the user select view more option of new post")
    public void the_user_select_view_more_option_of_the_newly_crated_post() {
        postListAct.selectViewMoreOption();
    }

    @When("the user select edit option")
    public void the_user_select_edit_option() {
        postListAct.selectEditPostOption();
    }

    @And("the user select delete option")
    public void the_user_select_delete_option() {
        postListAct.selectDeletePostOption();
    }

    @And("the user confirm")
    public void the_user_confirm_delete_post() {
        postListAct.deleteNewPost();
    }

    @Then("the post is deleted successfully")
    public void the_post_is_delete_successfully() {
        int sizeAfterDelete = postListAct.getSizeOfPostList();
        String sizeBefore = Serenity.sessionVariableCalled("sizeBeforeDelete").toString();
        int sizeBeforeDelete = Integer.parseInt(sizeBefore);
        System.out.println("Before Delete:" + sizeBeforeDelete);
        System.out.println("After Delete:" + sizeAfterDelete);
        postListVerify.verifyDeletePost(sizeAfterDelete, sizeBeforeDelete);
    }

    @And("the user decide to delete all post")
    public void the_user_decide_to_delete_all_post() {
        postListAct.deleteAllPost("Yes");
    }

    @When("the user go to timeline page")
    public void user_go_to_timeline_page(){
        navigationAct.goToTimeline();
    }

    @When("the user go to home page")
    public void the_user_go_to_the_home_page() {
        navigationAct.goToHomePgae();
    }

    @And("the user delete all new posts")
    public void the_user_delete_all_new_posts(DataTable dataTable) {
        String numberDeletePost = dataTable.asList().get(0);
        postListAct.deletePostByNumber(numberDeletePost);
    }

    /*
     ********************************** Post Tag **********************************************************
     */

    @When("the user click create post")
    public void the_user_click_create_post() {
        createPostAct.clickCreateNewPost();
    }

    @And("the user input text {string} and {string} and choose privacy {string}")
    public void the_user_input_text(String postType, String content, String privacy) throws AWTException {
        createPostAct.inputTextToPostArea(postType, content)
                .selectPostPrivacy(privacy);
        Serenity.setSessionVariable("content").to(content);
        Serenity.setSessionVariable("postType").to(postType);

    }
    @And("the user click tag icon")
    public void the_user_click_tag_icon() {
        createPostAct.selectTypeToPost("Gắn thẻ đồng nghiệp");
    }

    @And("the user search name and select search results {string}")
    public void the_user_search_name_and_select_search_results(String inputTagList) {
        java.util.List<String> tagList = StringHelper.separateStringToList(inputTagList);
        Serenity.setSessionVariable("sizeOfTagList").to(tagList.size());
        Serenity.setSessionVariable("firstTagName").to(tagList.get(0));

        for (String s : tagList) {
            createPostAct.inputTextToSearchTag(s)
                    .selectUserNameFromSearchResults(s);
        }
        //remove first tagged user
        tagList.remove(0);
        System.out.println("tag list after remove:" + tagList);
        //get the other author
        Serenity.setSessionVariable("tagList").to(tagList);
    }

    @And("the user click done")
    public void the_user_click_done() {
        createPostAct.clickDone();
    }

    @And("the user click share post")
    public void the_user_click_share_post() {
        createPostAct.clickSharePost();
        Serenity.setSessionVariable("sizeBeforeDelete").to(postListAct.getSizeOfPostList());
        Serenity.setSessionVariable("userNameCreatePost").to(postListAct.getUserNameCreatePost());
        Serenity.setSessionVariable("avatarCreatePost").to(postListAct.getAvatarImageIdOfUserCreatePost());

    }

    @Then("the user see correct tag list")
    public void the_user_see_correct_tag_list() {
        String size = Serenity.sessionVariableCalled("sizeOfTagList").toString();
        int tagSize = Integer.parseInt(size) - 1;
        String firstTagName = Serenity.sessionVariableCalled("firstTagName").toString();
        Serenity.setSessionVariable("tagSize").to(tagSize);
        postListVerify.verifyAuthorOfPost(firstTagName, String.valueOf(tagSize));
    }

    @When("the user click to tag list")
    public void the_user_click_to_tag_list() {
        postListAct.clickToOtherAuthor();
    }

    @Then("the tag list is correct")
    public void the_tag_list_is_correct() {
        java.util.List<String> expectedTagList = Serenity.sessionVariableCalled("tagList");
        System.out.println("expected tag list:"+expectedTagList);
        postListVerify.verifyDetailTagList(expectedTagList);
    }

    @When("the user close tag list detail popup")
    public void the_user_close_tag_list_detail_popup() {
        postListAct.closeTagListDetail();
    }

    @And("select notification tab")
    public void select_notification_tab() {
        navigationAct.clickNotiMenu();
    }

    @Then("see content of tag notification {string}")
    public void see_content_of_tag_notification(String receivedNoti) {
        String expectedUserName = Serenity.sessionVariableCalled("userNameCreatePost").toString();
        String expectedAvatar = Serenity.sessionVariableCalled("avatarCreatePost").toString();
        String expectedTagSize = Serenity.sessionVariableCalled("tagSize").toString();
        String expectedContent = Serenity.sessionVariableCalled("content").toString();

        notificationVerify.verifyNotificationContent(receivedNoti, expectedUserName, expectedTagSize, "tag", expectedContent);
        //if user get noti, click to noti to check post content
        if (receivedNoti.equalsIgnoreCase("yes")) {
            notificationAct.clickToFirstNotification();
            the_post_content_is_correct();
        }
    }

    @And("see content of post notification {string}")
    public void see_content_of_post_notification(String receivedNoti) {
        String expectedUserName = Serenity.sessionVariableCalled("userNameCreatePost").toString();
        String expectedAvatar = Serenity.sessionVariableCalled("avatarCreatePost").toString();
        String expectedTagSize = Serenity.sessionVariableCalled("tagSize").toString();
        String expectedContent = Serenity.sessionVariableCalled("content").toString();

        notificationVerify.verifyNotificationContent(receivedNoti, expectedUserName, expectedTagSize, "post", expectedContent);
    }


    @And("the friend login {string} and {string}")
    public void the_friend_login(String email, String pass) {
        navigationAct.logout();
        loginAction.login(email, pass);
        System.out.println("friend login");
    }

    @When("the colleague login {string} and {string}")
    public void the_colleague_login(String email, String pass) {
        navigationAct.logout();
        loginAction.login(email, pass);
        System.out.println("colleague login");
    }

    @And("click to first notification")
    public void click_to_first_notification() {
        notificationAct.clickToFirstNotification();
    }

    @When("the first user login again {string} and {string}")
    public void theFirstUserLoginAgainAnd(String email, String pass) {
        navigationAct.logout();
        loginAction.login(email, pass);
    }


    @When("the user go back to previous page")
    public void the_user_go_back_to_previous_page() {
        webNavigationHelper.backward();
    }
}
