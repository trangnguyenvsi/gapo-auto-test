package gapo.pilot.auto2.pages;

import org.openqa.selenium.By;

public class PagePage{
    public static By SHARE_NOW_BTN = By.xpath("//button[contains(text(),'Đăng ngay')]");
    public static By DRAFT_BTN = By.xpath("//button[contains(text(),'Lưu nháp')]");
    public static By EVENT_BTN = By.xpath("//button[@class='btn btn-light']");
    public static By EVENT_TEXT = By.xpath("//body/div[@id='root']/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/input[1]");
    public static By CONFIRM_EVENT_BTN = By.xpath("//button[contains(text(),'Lưu lịch')]");
    public static By EVENT_SHARE_BTN = By.xpath("//button[contains(text(),'Lên Lịch bài viết')]");
    public static By CONFIRM_YES_BTN = By.xpath("//button[contains(text(),'Đóng')]");
    public static By SETTING_BTN = By.xpath("//a[contains(text(),'Cài đặt')]");
    public static By DRAFT_POST_LIST = By.xpath("//a[contains(text(),'Bản nháp')]");
    public static By EVENT_POST_LIST = By.xpath("//a[contains(text(),'Đã lên lịch')]");
    public static By EXIT_BTN = By.xpath("//a[@class='modal-close-btn']");
    public static By POPUP_SHARE = By.xpath("//div[@class='modal-body']");
    public static By ADMIN_TEXT = By.xpath("//input[@class='form-control']");
    public static By ADD_ADMIN_BTN = By.xpath("//button[contains(text(),'Thêm')]");
    public static By CHOICE_ADMIN = By.xpath("//div[@class='media align-items-center']");
    public static By BACKGROUND_PAGE = By.xpath("//div[@class='sc-hgeeVt kNDefz dropdown']");
    public static By SAVE_BG_BTN = By.xpath("//button[contains(text(),'Lưu vị trí ảnh nền')]");
    public static By COVER_PAGE = By.xpath("//div[@class='sc-hgeeVt jIEKzk dropdown'][@pos='1']");
    public static By AVATAR_PAGE = By.xpath("//button[@class='upload-avatar__action rounded-circle btn d-flex align-items-center justify-content-center']");
    public static By CHANGE_PIC_PAGE = By.xpath("//div[@class='sc-cKZAiZ jBlKCG dropdown-menu show']/div");
    public static By DEL_PIC_PAGE = By.xpath("//div[@class='sc-cKZAiZ jBlKCG dropdown-menu show']/button");
    public static By YES_BTN = By.xpath("//button[contains(text(),'Có')]");
}
