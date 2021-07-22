package gapo.pilot.auto2.helper;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class InteractionHelper extends UIInteractionSteps {

    public void clickByJs(WebElement e, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].click();",e);
        waitFor(1000).milliseconds();
    }

    public void waitAndClick(By e ) {
        withTimeoutOf(Duration.ofSeconds(1))
                .find(e)
                .click();
        waitFor(500).milliseconds();
    }

    public void waitAndType(String text, By e){
        withTimeoutOf(Duration.ofSeconds(1))
                .find(e)
                .sendKeys(text);
    }

    public void waitUntilElementPresent(By e){
        withTimeoutOf(Duration.ofSeconds(1))
                .find(e);
    }
}
