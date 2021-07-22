package gapo.pilot.auto2.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class React extends PageObject {
    public static By REACT_BTN_LIKE_POST = By.xpath("//div[@style='background-image: url(\"/assets/images/png-icons/like-reaction.png\"); background-size: cover;']");
    public static By REACT_BTN_LOVE_POST = By.xpath("//div[@style='background-image: url(\"/assets/images/png-icons/love-reaction.png\"); background-size: cover;']");
    public static By REACT_CHECK_BTN_POST = By.xpath("//div[@class='post-item__reaction post-item_medium']");
    public static By REACT_BTN_LIKE_CMT = By.xpath("//div[@class='comment__actions']//div[@style='background-image: url(\"/assets/images/png-icons/like-reaction.png\"); background-size: cover;']");
    public static By REACT_BTN_LOVE_CMT = By.xpath("//div[@class='comment__actions']//div[@style='background-image: url(\"/assets/images/png-icons/love-reaction.png\"); background-size: cover;']");
    public static By REACT_CHECK_BTN_CMT = By.xpath("//div[@class='media-body']//span[@class='item_reaction']");
    public static By REACT_BTN_HAHA_REPLY_CMT = By.xpath("//div[@class='comment__replies mt-2']//div[@style='background-image: url(\"/assets/images/png-icons/haha-reaction.png\"); background-size: cover;']");
    public static By REACT_BTN_WOW_REPLY_CMT = By.xpath("//div[@class='comment__replies mt-2']//div[@style='background-image: url(\"/assets/images/png-icons/wow-reaction.png\"); background-size: cover;']");
    public static By REACT_CHECK_BTN_REPLY_CMT = By.xpath("//div[@class='comment__replies mt-2']//div[@class='media-body']//span[@class='item_reaction']");
    public static By VIEW_MORE_COMMENT = By.xpath("//a[@class='text-primary d-flex align-items-center']");
    public static By REACT_ACTIVE_POST = By.xpath("//a[@class='post-item__action active']");
    public static By UNREACT_CMT = By.xpath("//a[@class='comment__actions--reaction font-weight-semi-bold']");
    public static By UNREACT_REPLY_CMT = By.xpath("//div[@class='comment__replies mt-2']//a[@class='comment__actions--reaction font-weight-semi-bold']");
}
