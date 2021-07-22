package gapo.pilot.auto2.pages.createnewpost;

import gapo.pilot.auto2.helper.ElementHelper;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CreatePostElement extends PageObject {

    @Steps
    ElementHelper elementHelper;

    // public static By CREATE_POST_BTN = By.xpath( "//button[text()='Đăng bài viết']");
    public static By CREATE_POST_BTN = By.xpath("//span[text()='Bạn muốn chia sẻ điều gì?']");
    public static By POST_TEXT_AREA = By.xpath("//div[@class='create-post__box__input ']//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");

    public static By POST_LINK_TITLE = By.xpath("//div[contains(@class,'create-post')]//p[@class='title']");
    public static By POST_LINK_IMAGE = By.xpath("//div[contains(@class,'create-post')]//div[@class='img']");
    public static By POST_MEDIA = By.xpath("//div[contains(@class,'create-post__tooltip-icon')]//span[contains(text(),'Ảnh')]/..");

    public static By POST_EMOJI_ICON = By.xpath("//img[@alt='smile-icon']");
    public static By EMOJI_GRINNING = By.xpath("//*[@id='root']/main/div[2]/div/div/div[2]/div[2]/div[1]/div/div/section/div[2]/section[3]/ul/li[1]/button/span");
    public static By EMOJI_GRIN = By.xpath("//*[@id='root']/main/div[2]/div/div/div[2]/div[2]/div[1]/div/div/section/div[2]/section[3]/ul/li[2]/button/span");

    public static By SHARE_BTN = By.xpath("//button[text()='Chia sẻ']");
    public static By UPDATE_BTN = By.xpath("//button[text()='Cập nhật']");
    public static By MEDIA_UPLOAD_LIST = By.xpath("//div[@class='photo-upload-item mr-2']");
    public static By PRIVACY_BTN = By.xpath("//span[@class='triangle-down']");
    public static By PRIVACY = By.xpath("//label[text()='Bạn bè']");
    public static By REMOVE_MEDIA = By.xpath("//div[@class='photo-upload-item mr-2']//i[@class='gapo-icon icon-close icon-2x']");
    public static By PROGRESS_UPLOAD = By.xpath("//span[@class='progress-indicator']");


    public static By BACKGROUND_BTN = By.xpath("//span[@class='icon toggle-background ']");
    public static By NO_BACKGROUND_OPTION = By.xpath("//div[contains(@class,'background-options')]//div[contains(@class,'item-default')]");

    public static By SEARCH_USER_TO_TAG_TXT = By.xpath("//div[@class='tag-input-wrapper']//input[@type='search']");
    public static By Done_ON_SEARCH_TAG_BTN = By.xpath("//button[text()='Xong']");


    public static By getUserNameInSearchResults(String name) {
        String xpathMentionUser = "//div[@class='search-result-item']/div[text()='${name}']";
        return ElementHelper.get_element_by(name, xpathMentionUser);
    }


    public static By getBackgroundByIndex(String index) {
        String xpathBackground = "//div[contains(@class,'background-options')]//div[contains(@style,'${name}')]";
        return ElementHelper.get_element_by(index, xpathBackground);
    }

    public static By getMentionUserByName(String name) {
        String xpathMentionUser = "//div[contains(text(),'${name}')]";
        return ElementHelper.get_element_by(name, xpathMentionUser);
    }

    public static By getPrivacyPost(String privacy) {
        String xpathPrivacy = "//label[@for='${name}']";
        return ElementHelper.get_element_by(privacy, xpathPrivacy);
    }

    public static By getPostTypeBtn(String postType) {
        String xpathPostType = "//div[contains(@class,'create-post__tooltip-icon')]//span[contains(text(),'${name}')]/..";
        return ElementHelper.get_element_by(postType, xpathPostType);
    }


}
