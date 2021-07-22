package gapo.pilot.auto2.openurl;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class UserProfileUrlAction extends UIInteractionSteps {
     UserProfileUrl userProfileUrl;

    @Step("Open profile")
    public void open_user_profile_url(){
        userProfileUrl.open() ;
    }
}
