package gapo.pilot.auto2.pages.search;

import gapo.pilot.auto2.helper.InteractionHelper;

import gapo.pilot.auto2.helper.KeyboardHelper;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.time.Duration;

public class SearchAction extends UIInteractionSteps {
    @Steps
    InteractionHelper interactionHelper;

    @Step("Search on home page")
    public SearchAction searchOnHomePage(String searchText) throws AWTException {
        interactionHelper.waitAndType(searchText, SearchElement.SEARCH_INPUT);
        KeyboardHelper.pressEnterKey();
        return this;
    }

    @Step("Select profile name on search results")
    public SearchAction selectProfileNameOnSearchResults(String name){
        $(SearchElement.get_profile_in_search_results(name)).click();
        return this;
    }

}
