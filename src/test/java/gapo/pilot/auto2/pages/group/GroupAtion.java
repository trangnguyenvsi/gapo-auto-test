package gapo.pilot.auto2.pages.group;

import gapo.pilot.auto2.helper.InteractionHelper;
import gapo.pilot.auto2.pages.usertimeline.UserTimelineElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class GroupAtion extends UIInteractionSteps {
    @Steps
    InteractionHelper interactionHelper;

    @Step("Noti setting on group")
    public void noti_setting_on_group(){
        $(Group.MORE_BTN).click();
        $(Group.NOTI_SET).click();
        $(Group.ON_NOTI).click();
        $(UserTimelineElement.SAVE_BTN).click();
    }

    @Step("follow setting on group")
    public void follow_setting_on_group(){
        $(Group.MORE_BTN).click();
        $(Group.FOLLOW_SET).click();
        $(Group.DEFAULT_FOLLOW).click();
        $(UserTimelineElement.SAVE_BTN).click();
    }

    @Step("edit intro group")
    public void edit_intro_group() throws InterruptedException {
        interactionHelper.clickByJs($(Group.EDIT_INTRO), getDriver());
        $(Group.TEXT_AREA_INTRO).clear();
        $(Group.TEXT_AREA_INTRO).sendKeys("day la text edit");
        interactionHelper.clickByJs($(Group.SAVE_INTRO), getDriver());
    }

    @Step("invite friend join group")
    public void invite_fr_join_group(){
        $(Group.INVITE_BTN).click();
        $(Group.SEARCH).sendKeys("Hương");
        $(Group.CHOICE_FR).click();
        $(Group.SEND).click();
    }

    @Step("go to setting group")
    public void go_to_setting_group(){
        $(Group.SETTING_GROUP_BTN).click();
    }

    @Step("edit name of group")
    public void edit_name_of_group() throws InterruptedException {
        $(Group.TEXT_AREA_NAME_GR).clear();
        $(Group.TEXT_AREA_NAME_GR).sendKeys("edit name");
        interactionHelper.clickByJs($(Group.SAVE_SETTING_BTN), getDriver());
    }

    @Step("rule of group")
    public void change_rule_group() throws InterruptedException {
        interactionHelper.clickByJs($(Group.RULE_BTN), getDriver());
        $(Group.TITLE_RULE).sendKeys("tieu de noi quy auto");
        $(Group.RULE).sendKeys("mo ta noi quy auto");
        $(Group.SAVE_RULE_BTN).click();
    }

    @Step("accpet request join group")
    public void accept_requets_join_group(){
        $(Group.REQUETS_JOIN_GR).click();
        $(Group.ACCEPT_REQUETS).click();
        getDriver().navigate().back();
    }

    @Step("del mem group")
    public void delete_member_group() throws InterruptedException {
        $(Group.MEMBER).click();
        interactionHelper.clickByJs($(Group.CHOICE_MEMBER), getDriver());
        interactionHelper.clickByJs($(Group.DEL_MEM), getDriver());
        $(Group.YES_CONFRIM_BTN).click();
    }

    @Step("the user accept post")
    public void the_user_accept_post(){
        $(Group.REQUETS_POST).click();
        $(Group.ACCEPT_REQUETS).click();
    }

    @Step("the user pin and check post")
    public void the_user_pin_and_check_post() throws InterruptedException {
        $(Group.POST).click();
        interactionHelper.clickByJs($(Group.NEARLY_POST), getDriver());
        interactionHelper.clickByJs($(Group.PIN_POST_BTN), getDriver());
        $(Group.COMFIRM_PIN).click();
        $(Group.PIN_POST).click();
    }
}
