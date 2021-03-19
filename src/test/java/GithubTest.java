import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void searchSelenide() {
        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $(".repo-list").find(byText("selenide/")).click();
        $(".js-repo-nav").find(byText("Wiki")).click();
        $(".wiki-rightbar").find(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));


    }
}
