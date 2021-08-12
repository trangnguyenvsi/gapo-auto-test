package gapo.pilot.auto2.helper;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class WebNavigationHelper extends UIInteractionSteps {

    public void backward(){

        getDriver().navigate().back();
        waitFor(1000).milliseconds();
    }
    public void refresh(){
        getDriver().navigate().refresh();
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }
}
