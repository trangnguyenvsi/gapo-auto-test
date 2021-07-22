package gapo.pilot.auto2.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class Comment extends PageObject {
    public static By CMT_BTN =By.xpath("//a[contains(text(),'Bình luận')]");
    public static By CMT_TEXT = By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
    public static By CMT_TEXT_REPLY = By.xpath("//div[@class='comment__item__form']//div[@role='textbox']");
    public static By CMT_STICKER_BTN = By.xpath("//i[@class='gapo-icon icon-sticker-alt ']");
    public static By STICKER = By.xpath("//div[@class='item-sticker'][2]");
    public static By CMT_EMOJI_BTN = By.xpath("//i[@class='gapo-icon icon-emotion-alt']");
    public static By EMOJI = By.xpath("//button[@title='smirk']");
    public static By CMT_IMAGE_BTN = By.xpath("//div[@class='comment__form__meta']//i[@class='gapo-icon icon-camera-alt']");
    public static By VIEW_MORE_OPTION = By.xpath("//div[@class='comment__item']//span[text()='vừa xong']/../../../../../..//i[@class='gapo-icon icon-more-option float-left']");
    public static By VIEW_MORE_OPTION2 = By.xpath("//i[@class='gapo-icon icon-more-option float-left']");
    public static By UNPIN_CMT_BTN = By.xpath("//a[contains(text(),'Bỏ ghim bình luận')]");
    public static By EDIT_CMT_BTN = By.xpath("//div[@class='comment__item'][last()]//a[contains(text(),'Chỉnh sửa bình luận')]");
    public static By DEL_CMT_BTN = By.xpath("//div[@class='comment__item'][last()]//a[contains(text(),'Xoá bình luận')]");
    public static By REPLY_BTN = By.xpath("//div[@class='comment__item'][last()]//a[contains(text(),'Trả lời')]");
    public static By PIN_CMT_BTN = By.xpath("//div[@class='comment__item'][last()]//a[@class='px-3 py-2 d-block action-button']");

}
