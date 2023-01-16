package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement mainSignInButton() {
        return $("[href='/login']").as("кнопка авторизации на главной странице");
    }

    public SelenideElement mainPageHeader() {
        return $(".Header").as("шапка главной страницы после успешной авторизации");
    }

    public SelenideElement buttonOpenDropdown() {
        return $("[aria-label='View profile and more']").as("кнопка открытия выпадающего меню");
    }

    public SelenideElement yourProfileButton() {
        return $("[data-ga-click='Header, go to profile, text:your profile']").as("пункт Your profile в выпадающем списке");
    }

    public SelenideElement editProfileButton() {
        return $("[class='btn btn-block js-profile-editable-edit-button']").as("кнопка для редактирования профиля");
    }
}
