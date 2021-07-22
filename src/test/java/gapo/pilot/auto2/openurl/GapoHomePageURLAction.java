package gapo.pilot.auto2.openurl;

import net.thucydides.core.annotations.Step;

public class GapoHomePageURLAction {
    GapoHomePageURL gapoHomePageURL;

    @Step("Open home page")
    public void open_home_page(){
        gapoHomePageURL.open() ;
    }
}
