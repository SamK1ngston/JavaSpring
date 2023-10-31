import com.itproger.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    //Тестирование создания объекта user с передачей параметров логина и email
    //Проверка что объект user создан и что установленные значения логина и email совпадают с ожидаемыми
    @Test
    public void testUserWithValidParameters() {
        User user = new User("TestUser", "testuser@example.com");
        assertNotNull(user);
        assertEquals("TestUser", user.getLogin());
        assertEquals("testuser@example.com", user.getEmail());
    }

    //Тестирование создания объекта user без передачи параметров (пустой логин и email)
    //Проверка что объект user создан и поля логина и email установлены в значение null
    @Test
    public void testUserWithEmptyParameters() {
        User user = new User("", "");
        assertNotNull(user);
        assertNull(user.getLogin());
        assertNull(user.getEmail());
    }

    //Тестирование установки некорректного email в объект user
    //Проверка что объект user успешно создан, но в поле email установлено в значение null, так как email некорректен
    @Test
    public void testUserWithInvalidEmail() {
        User user = new User("TestUser", "invalid-email");
        assertNotNull(user);
        assertNull(user.getEmail());
    }

    //Тестирование установки логина менее 5 символов в объекте user
    //Проверка что объект user создан, но в поле login установлено в значение null, так как логин короче 5 символов
    @Test
    public void testUserWithShortLogin() {
        User user = new User("abc", "testuser@example.com");
        assertNotNull(user);
        assertNull(user.getLogin());
    }
}
