import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("xenia-efimova")

public class AuthTest {

    @BeforeEach
    public void openAuthorizationPage(){
        step("Открыть страницу https://github.com/", () -> {
            open("https://github.com/");
        });
        step("Нажать на кнопку с текстом Sign in", () -> {
            TestPages.mainPage.mainSignInButton().click();
        });
    }

    @Test
    @DisplayName("Успешная авторизация")
    @Feature("Авторизация")
    public void shouldAuthorizeTest() {
        step("Заполнить инпуты логина и пароля корректными данными", () -> {
                    TestPages.authorizationPage.loginInput().sendKeys("qwerty");
                    TestPages.authorizationPage.passwordInput().sendKeys("qwerty");
                });
        step("Нажать на кнопку с текстом Sign in", () -> {
            TestPages.authorizationPage.singInButton().click();
        });
        step("Проверить, что отображается главная страница после авторизации", () -> {
            TestPages.mainPage.mainPageHeader().shouldBe(Condition.visible);
        });
        step("Кликнуть на кнопку открытия выпадающего списка", () -> {
            TestPages.mainPage.buttonOpenDropdown().click();
        });
        step("Кликнуть на пункт Your profile в выпадающем списке", () -> {
            TestPages.mainPage.yourProfileButton().click();
        });
        step("Убедиться в том, что открылась страница профиля", () -> {
            TestPages.mainPage.editProfileButton().shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Безуспешная авторизация с некорректными данными")
    @Feature("Авторизация")
    public void shouldNotAuthorizeTest() {
        step("Заполнить инпуты логина и пароля некорректными данными", () -> {
            TestPages.authorizationPage.loginInput().sendKeys("qwerty");
            TestPages.authorizationPage.passwordInput().sendKeys("qwerty");
        });
        step("Нажать на кнопку с текстом Sign in", () -> {
            TestPages.authorizationPage.singInButton().click();
        });
        step("Проверить, что отображается сообщение об ошибке", () -> {
            TestPages.authorizationPage.flashAlert().shouldBe(Condition.visible).shouldHave(text("Incorrect username or password"));
        });
    }
}