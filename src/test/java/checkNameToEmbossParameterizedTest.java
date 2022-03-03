import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class checkNameToEmbossParameterizedTest {
    private final String name;
    private final boolean expected;

    public checkNameToEmbossParameterizedTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                //Имя 18 символов
                {"Тамара Конашенкова", true},
                //Имя 19 символов
                {"Вероника Пишкалкова", true},
                //Имя 4 символа
                {"WI l", true},
                //Имя 3 символа
                {"L U", true},
                //Имя 9 символов
                {"Луна Нуль", true},
                //имя без пробела
                {"Петров", false},
                //Имя с пробелом вначале
                {" Ivanov", false},
                //Имя с пробелом вконце
                {"Сидоров ", false},
                //Имя с двумя сиволами
                {"X ", false},
                //Пустая строка
                {"", false},
                //Строка с одним пробелом
                {" ", false},
                // Проверка на null
                {null, false},
                //Имя 20 символов
                {"Garetbnnx cncnnncnnf", false},
                //Имя 25 символов
                {"fjnvnvnjna vvтмовмттшшшшш", false},
                //Имя с двумя пробелами
                {"Тамара  Конашенкова", false},

        };
    }

    @Test
    public void main() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
