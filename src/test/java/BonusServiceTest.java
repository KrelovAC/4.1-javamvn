import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {
    @Test
    void shouldCalculateForRegistredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготовка данный:
        long amount = 1000;
        boolean registred = true;
        long expectid = 30;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registred);
        // проводим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expectid, actual);
    }

    @Test
    void shouldCalculateForRegistredAndOverlimit() {
        BonusService service = new BonusService();
        // подготовка данный:
        long amount = 1_000_000;
        boolean registred = true;
        long expectid = 500;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registred);
        // проводим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expectid, actual);
    }

    @Test
    void shouldCalculateForUnRegistredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготовка данный:
        long amount = 100;
        boolean registred = false;
        long expected = 1;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registred);
        // проводим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegistredAndOverLimit() {
        BonusService service = new BonusService();
        // подготовка данный:
        long amount = 10_000;
        boolean registred = false;
        long expected = 100;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registred);
        // проводим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}

