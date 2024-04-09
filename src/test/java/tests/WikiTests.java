package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {

    @Test
    @DisplayName("Display search result")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Article display")
    void openPageTest() {
        step("Click on article header ", () ->
                $(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text")).click());
        step("Check opening", () ->
                $$(id("org.wikipedia.alpha:id/view_news_fullscreen_link_card_list"))
                        .shouldHave(sizeGreaterThan(0)));
    }

}
