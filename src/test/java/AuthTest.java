import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @Test
    public void shouldAuthorizeTest() {
        // Шаг 1. Открыть страницу https://github.com/
        open("https://github.com/");
        // Шаг 2. Нажать на кнопку с текстом Sign in
        $("[href='/login']").click();
        // Шаг 3. Заполнить инпуты логина и пароля
        $("[id='login_field']").sendKeys("qwerty1234");
        $("[id='password']").sendKeys("qwerty");
        // Шаг 4. Нажать на кнопку с текстом Sign in
        $("[name='commit']").click();
        // Шаг 5. Проверка отображения главной страницы после авторизации
        $(".Header").shouldBe(Condition.visible);
        // Шаг 6. Кликнуть на кнопку открытия выпадающего списка
        $("[aria-label='View profile and more']").click();
        // Шаг 7. Кликнуть на пункт Your profile в выпадающем списке
        $("[data-ga-click='Header, go to profile, text:your profile']").click();
        //$(byText("Your profile"));
        // Шаг 8. Проверка открытия страницы профиля
        $("[class='btn btn-block js-profile-editable-edit-button']").shouldBe(Condition.visible);
    }
}