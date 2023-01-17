import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @BeforeEach
    public void openAuthorizationPage(){
        // Шаг 1. Открыть страницу https://github.com/
        open("https://github.com/");
        // Шаг 2. Нажать на кнопку с текстом Sign in
        TestPages.mainPage.mainSignInButton().click();
    }

    @Test
    @DisplayName("Успешная авторизация")
    public void shouldAuthorizeTest() {
        // Шаг 3. Заполнить инпуты логина и пароля
        TestPages.authorizationPage.loginInput().sendKeys("qwerty");
        TestPages.authorizationPage.passwordInput().sendKeys("qwerty");
        // Шаг 4. Нажать на кнопку с текстом Sign in
        TestPages.authorizationPage.singInButton().click();
        // Шаг 5. Проверка отображения главной страницы после авторизации
        TestPages.mainPage.mainPageHeader().shouldBe(Condition.visible);
        // Шаг 6. Кликнуть на кнопку открытия выпадающего списка
        TestPages.mainPage.buttonOpenDropdown().click();
        // Шаг 7. Кликнуть на пункт Your profile в выпадающем списке
        TestPages.mainPage.yourProfileButton().click();
        // Шаг 8. Проверка открытия страницы профиля
        TestPages.mainPage.editProfileButton().shouldBe(Condition.visible);
    }
}