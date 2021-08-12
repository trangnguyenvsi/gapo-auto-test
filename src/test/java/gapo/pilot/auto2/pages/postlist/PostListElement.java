package gapo.pilot.auto2.pages.postlist;

import gapo.pilot.auto2.helper.ElementHelper;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.lang.annotation.ElementType;

public class PostListElement extends PageObject {
    @Steps
    ElementHelper elementHelper;

    public static By VIEW_MORE_OPTION = By.xpath("//div[@class='post-item '][1]//i[@class='gapo-icon icon-more-option']");
    public static By VIEW_MORE_OPTION_LIST = By.xpath("//i[@class='gapo-icon icon-more-option']");
    public static By EDIT_POST_OPTION = By.xpath("//a[contains(text(),'Chỉnh sửa bài viết')]");
    public static By COPY_POST_CONTENT_OPTION = By.linkText("Sao chép nội dung bài viết");
    public static By COPY_POST_LINK_OPTION = By.linkText("Sao chép link bài viết");

    public static By PRIVACY_POST_ICON = By.xpath("//div[@class='post-item '][1]//i[@data-toggle='tooltip']");

    public static By SHARE_POST_OPTION = By.cssSelector("#post-share");
    public static By CONFIRM_YES_POST = By.xpath("//button[contains(text(),'Có')]");
    public static By DELETE_POST_OPTION = By.xpath("//a[contains(text(),'Xóa bài viết')]");
    public static By SHARE_POST_ICON =By.xpath("//div[@class='post-item '][1]//a[contains(text(),'Chia sẻ')]");

    public static By MEDIA_LIST_POST = By.xpath("//div[@class='post-item '][1]//div[contains(@class,'attachment__item')]");
    public static By MORE_PHOTO_LABEL = By.xpath("//span[@class='more-photo']");

    //****************************************************************************************
    public static By STATUS_OF_POST = By.xpath("//a[@class='text-secondary']");
    public static By POST_CONTENT_TEXT = By.xpath("//div[@class='post-item '][1]//div[contains(@class,'text-display is-feed')]/div");
    public static By POST_HASHTAG_LINK = By.xpath("//div[@class='post-item '][1]//a[contains(@href,'hashtags')]");
    public static By PREVIEW_LINK_TITLE = By.xpath("//div[@class='post-item '][1]//div[@class='img']");
    public static By PREVIEW_LINK_THUMB = By.xpath("//div[@class='post-item '][1]//p[@class='title']");
    public static By BACKGROUND_OF_POST = By.xpath(" //div[@class='post-item '][1]//div[@class='post-item__content']");

    public static By getMentionedName(String name){
        String xpathMentionedName = "//div[@class='post-item '][1]//div[@class='post-item__content']//a[contains(@class,'is-mention ') and contains(text(),'${name}')]";
        return ElementHelper.get_element_by(name,xpathMentionedName);
    }

    public static By getPostByContent(String name){
        String xpathPost = "//div[contains(text(),'${name}')]";
        return ElementHelper.get_element_by(name,xpathPost);
    }

    public static By getButtonShareByPostContent(String name){
        String xpathPost = "//div[text()='${name}']/../../../..//a[@id='post-share']";
        return ElementHelper.get_element_by(name,xpathPost);
    }
    public static By getDateOfPost(String name){
        String xpathPost = "//div[text()='${name}']/../../../..//a[@class='text-secondary']";
        return ElementHelper.get_element_by(name,xpathPost);
    }
    //******************************************************************************************
    public static By CONTENT_POST_LIST = By.xpath("//div[@class='post-item__content']//div[@class='text-display is-feed']");
    public static By CONFIRM_POPUP_YES = By.xpath("//button[text()='Có']");
    public static By CONFIRM_POPUP_NO = By.xpath("//button[text()='Không']");
    public static By END_OF_PAGE = By.xpath("//div[text()='Bạn chưa có bài viết nào']");
    //*****************************************************************************************
    public static By AVATAR_USER_CREATE_POST = By.xpath("//div[@class='post-item '][1]//img[contains(@class,'post-item')]");
    public static By USER_NAME_CREATE_POST = By.xpath("//div[@class='post-item '][1]//span[@class='post-item__author']/a");
    public static By AVATAR_USER_ON_QUESTION_POST = By.xpath("//div[@class='post-item '][1]//div[contains(@style,'background-image')]/img");
    public static By USER_NAME_ON_QUESTION_POST = By.xpath("//div[@class='post-item '][1]//b");
    public static By QUESTION_BUTTON_ON_QUESTION_POST = By.xpath("//div[@class='post-item '][1]//button[text()='Hỏi ngay']");
    public static By AUTHOR_OF_FIRST_POST = By.xpath("//div[@class='post-item '][1]//span[@class='post-item__author']");
    public static By OTHER_AUTHOR_POST = By.xpath("//div[@class='post-item '][1]//span[@class='post-item__author']//span[@class='font-weight-bold cursor']");
    public static By TAG_LIST_DETAIL = By.xpath("//div[@class='search-result-item is-link']//a/div[@class='text-name']");
    public static By CLOSE_TAG_LIST_DETAIL_ICON = By.cssSelector(".close-btn > svg");


  //********************************************************************************************








}
