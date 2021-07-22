package gapo.pilot.auto2.pages.usertimeline;

import org.openqa.selenium.By;

public class UserTimelineElement {


    public static By USER_NAME = By.xpath("//h1[contains(@class,'profile__name')]");

    public static By UPDATE_PERSONAL_INFO_BTN = By.xpath("//img[@alt='Chỉnh sửa thông tin']");

    public static By UPDATE_INFO_PROFILE = By.xpath("//span[contains(text(),'Chỉnh sửa thông tin')]");

    public static By FAVOURITE = By.xpath("//a[contains(text(),'Thêm/Sửa sở thích')]");

    public static By FAVOURITE_CHOICE =By.xpath("//span[contains(text(),'Đi quẩy')]");

    public static By SAVE_INFO_BTN = By.xpath("//button[contains(text(),'Lưu thay đổi')]");

    public static By UPDATE_COVER = By.xpath("//div[contains(text(),'Cập nhật ảnh bìa')]");

    public static By UPADTE_COVER_LOAD = By.xpath("//a[contains(text(),'Tải ảnh lên')]");

    public static By SAVE_BTN = By.xpath("//button[contains(text(),'Lưu')]");

    public static By AVT_VIEW_BTN = By.xpath("//span[contains(text(),'Xem ảnh')]");

    public static By AVT_UPDATE = By.xpath("//span[contains(text(),'Thay ảnh')]");
}
