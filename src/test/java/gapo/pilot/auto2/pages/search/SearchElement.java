package gapo.pilot.auto2.pages.search;

import gapo.pilot.auto2.helper.ElementHelper;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchElement extends PageObject {
    public static By SEARCH_INPUT = By.id("js-search-input");

    static String xpathProfile = "//a[@class='text-body font-weight-semi-bold' and text()='${name}']";
    public static By get_profile_in_search_results(String profileName){
        return ElementHelper.get_element_by(profileName,xpathProfile);
    }

}
