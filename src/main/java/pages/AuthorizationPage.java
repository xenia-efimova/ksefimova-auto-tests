package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    public SelenideElement LoginInput() {
        return $("[id='login_field']").as("инпут ввода логина");
    }
    public SelenideElement PasswordInput() {
        return $("[id='password']").as("инпут ввода пароля");
    }
    public SelenideElement SingInButton() {
        return $("[name='commit']").as("кнопка авторизации");
    }
}
