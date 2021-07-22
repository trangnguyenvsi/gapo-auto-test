package gapo.pilot.auto2.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class
Navigation extends PageObject {

    public static By IGNORE_BTN = By.xpath("//button[text()= 'Bỏ qua']");
    public static By GIFT_BTN = By.xpath("//i[@class='gapo-icon icon-close']");
    public static By FOLLOW_FEED_BTN = By.xpath("//a[@href=\"/follow\"]");
    public static By HASHTAG_DETAIL_BTN = By.xpath("//div[@class='react-multi-carousel-list  ']");
    public static By VIDEO_DETAIL_BTN = By.xpath("//span[contains(text(),'Video')]");
    public static By NOTI_MENU = By.xpath("//li[@class='hide_mobile']/a");
    public static By NOTI_BADGE = By.xpath("//span[@class='notification-badge']");

    public static By AVATAR_LINK = By.xpath("//a[@class='avatarlink']");
    public static By PROFILE_LINK = By.xpath("//a[contains(text(),'Trang cá nhân')]");
    public static By LOGOUT_BTN = By.xpath("//span[text()='Đăng xuất']");


}
