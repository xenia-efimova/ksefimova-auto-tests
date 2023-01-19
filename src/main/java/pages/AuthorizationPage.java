package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    public SelenideElement loginInput() {
        return $("[id='login_field']").as("инпут ввода логина");
    }
    public SelenideElement passwordInput() {
        return $("[id='password']").as("инпут ввода пароля");
    }
    public SelenideElement singInButton() {
        return $("[name='commit']").as("кнопка авторизации");
    }
}
