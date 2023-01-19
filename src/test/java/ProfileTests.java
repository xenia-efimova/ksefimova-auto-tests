import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProfileTests {

    @BeforeEach
    public void switchToRepositoriesPage() {
        // Открыть страницу репозитория "junit-team/junit4"
        open("https://github.com/junit-team/junit4");
        // Проверка отображения страницы репозитория "junit-team/junit4"
        TestPages.repositoryPage.repositoryContainerHeader().shouldHave(text("junit4"));
    }

    @Test
    @DisplayName("Переключение на ветку fixtures в репозитории junit-team/junit4")
    public void shouldSwitchToBranchTest() {
        // Открыть выпадающий список с наименованиями веток
        TestPages.repositoryPage.dropdownWithNamesOfBranches().click();
        // Кликнуть на название ветки "fixtures"
        TestPages.repositoryPage.selectMenuItems().filter(text("fixtures")).first().click();
        // Проверка отображения страницы ветки fixtures
        TestPages.repositoryPage.tagOfBranchFixtures().shouldHave(Condition.text("fixtures"));
    }

    @Test
    @DisplayName("Позитивные проверка поиска по релизам в репозитории junit-team/junit4 по номеру")
    public void shouldSearchCorrectlyByNumberTest() {
        // Кликнуть на заголовок Releases
        TestPages.repositoryPage.titleReleases().click();
        // Проверка отображения поисковой строки
        TestPages.repositoryPage.releasesSearchString().shouldBe(Condition.visible);
        //Поиск по номеру
        TestPages.repositoryPage.releasesSearchString().sendKeys("4.13.2");
        // Нажать Enter
        TestPages.repositoryPage.releasesSearchString().pressEnter();
        //Проверка существования названия релиза с введенным номером
        TestPages.repositoryPage.releaseCards().shouldHave(size(1));
        TestPages.repositoryPage.releaseCards().shouldHave(texts("4.13.2"));
    }

    @Test
    @DisplayName("Позитивные проверка поиска по релизам в репозитории junit-team/junit4 по буквам в названии")
    public void shouldSearchCorrectlyByLettersTest() {
        // Кликнуть на заголовок Releases
        TestPages.repositoryPage.titleReleases().click();
        // Проверка отображения поисковой строки
        TestPages.repositoryPage.releasesSearchString().shouldBe(Condition.visible);
        //Поиск по буквам в названии
        TestPages.repositoryPage.releasesSearchString().sendKeys("Beta");
        TestPages.repositoryPage.releasesSearchString().pressEnter();
        //Проверка существования названия релиза с введенными буквами
        TestPages.repositoryPage.releaseCards().shouldHave(size(6));
        TestPages.repositoryPage.releaseCards().first().shouldHave(text("Beta"));
    }
}
