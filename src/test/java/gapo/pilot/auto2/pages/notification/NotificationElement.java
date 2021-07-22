package gapo.pilot.auto2.pages.notification;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class NotificationElement extends PageObject {
    public static By FIRST_NOTI_AVATAR = By.xpath("//li[1]//a[contains(@class,'side-menu__item')]//img[contains(@class,'gapo-avatar')]");
    public static By FIRST_NOTI_CONTENT = By.xpath("//li[1]//a[contains(@class,'side-menu__item')]//div[@class='media-body pl-1']");
    public static By NOTI_TAG_CONTENT_LIST = By.xpath("//div[img/@src='https://image-1.gapowork.vn/images/7b8bd371-2531-4f34-9dba-69a204a8b10c.png']/../../..//a//div[@class='media-body pl-1']");
    public static By NOTI_POST_CONTENT_LIST = By.xpath("//div[img/@src='https://image-1.gapo.vn/images/icon/new/post_new.png']/../../..//a//div[@class='media-body pl-1']");

}
