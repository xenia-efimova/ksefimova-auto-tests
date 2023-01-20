import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("xenia-efimova")

public class ProfileTests {

    @BeforeEach
    public void switchToRepositoriesPage() {
        step("Открыть страницу репозитория 'junit-team/junit4'", () -> {
            open("https://github.com/junit-team/junit4");
        });
        step("Проверить, что отображается страница репозитория 'junit-team/junit4'", () -> {
            TestPages.repositoryPage.repositoryContainerHeader().shouldHave(text("junit4"));
        });
    }

    @Test
    @DisplayName("Переключение на ветку fixtures в репозитории junit-team/junit4")
    @Feature("Cтраница репозитория")
    public void shouldSwitchToBranchTest() {
        step("Открыть выпадающий список с наименованиями веток", () -> {
            TestPages.repositoryPage.dropdownWithNamesOfBranches().click();
        });
        step("Кликнуть на название ветки 'fixtures'", () -> {
            TestPages.repositoryPage.selectMenuItems().filter(text("fixtures")).first().click();
        });
        step("Проверить, что отображается ветка fixtures", () -> {
            TestPages.repositoryPage.tagOfBranchFixtures().shouldHave(Condition.text("fixtures"));
        });
    }

    @Test
    @DisplayName("Позитивная проверка поиска по релизам в репозитории junit-team/junit4 по номеру")
    @Feature("Страница с релизами в репозитории")
    public void shouldSearchCorrectlyByNumberTest() {
        step("Кликнуть на заголовок Releases", () -> {
            TestPages.repositoryPage.titleReleases().click();
        });
        step("Ввести номер релиза в поисковую строку", () -> {
            TestPages.repositoryPage.releasesSearchString().shouldBe(Condition.visible);
            TestPages.repositoryPage.releasesSearchString().sendKeys("4.13.2");
            TestPages.repositoryPage.releasesSearchString().pressEnter();
        });
        step("Проверить, что существует релиз с введенным номером", () -> {
            TestPages.repositoryPage.releaseCards().shouldHave(size(1));
            TestPages.repositoryPage.releaseCards().shouldHave(texts("4.13.2"));
        });
    }

    @Test
    @DisplayName("Позитивная проверка поиска по релизам в репозитории junit-team/junit4 по буквам в названии")
    @Feature("Страница с релизами в репозитории")
    public void shouldSearchCorrectlyByLettersTest() {
        step("Кликнуть на заголовок Releases", () -> {
            TestPages.repositoryPage.titleReleases().click();
        });
        step("Ввести часть названия релиза в поисковую строку", () -> {
            TestPages.repositoryPage.releasesSearchString().shouldBe(Condition.visible);
            TestPages.repositoryPage.releasesSearchString().sendKeys("Beta");
            TestPages.repositoryPage.releasesSearchString().pressEnter();
        });
        step("Проверить, что существуют релизы с введенным фрагментом названия", () -> {
            TestPages.repositoryPage.releaseCards().shouldHave(size(6));
            TestPages.repositoryPage.releaseCards().first().shouldHave(text("Beta"));
        });
    }
}
