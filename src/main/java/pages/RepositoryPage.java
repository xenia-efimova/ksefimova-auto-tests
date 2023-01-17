package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {

    public SelenideElement repositoryNameButton() {
        return $("[href='/junit-team/junit4']").as("название репозитория junit-team/junit4");
    }

    public SelenideElement repositoryContainerHeader() {
        return $("[id='repository-container-header']").as("хедер репозитория");
    }
    public SelenideElement dropdownWithNamesOfBranches() {
        return $("[id='branch-select-menu']").as("выпадающий список с наименованиями веток");
    }
    public SelenideElement linkToBranchFixtures() {
        return $("[href='https://github.com/junit-team/junit4/tree/fixtures']").as("ссылка на ветку fixtures");
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
    public SelenideElement releaseCard () {
        return $("[data-test-selector='release-card']").as("блок с информацией о релизе");
    }

}
