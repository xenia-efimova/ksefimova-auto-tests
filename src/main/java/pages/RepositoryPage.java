package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RepositoryPage {

    public SelenideElement repositoryContainerHeader() {
        return $("[id='repository-container-header']").as("хедер репозитория");
    }
    public SelenideElement dropdownWithNamesOfBranches() {
        return $("[id='branch-select-menu']").as("выпадающий список с наименованиями веток");
    }
    public ElementsCollection selectMenuItems() {
        return $$(".SelectMenu-item").as("слоты для выбора в выпадающем списке");
    }
    public SelenideElement tagOfBranchFixtures() {
        return  $(".css-truncate .css-truncate-target").as("тег fixtures");
    }
    public SelenideElement titleReleases() {
        return $(".BorderGrid-cell [href='/junit-team/junit4/releases']").as("заголовок Releases");
    }
    public SelenideElement releasesSearchString () {
        return  $("[id='release-filter']").as("поисковая строка");
    }
    public ElementsCollection releaseCards () {
        return $$(".Box-body").as("блоки с информацией о релизе");
    }

}
