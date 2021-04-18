import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void transactionName() throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction Test_getter = new BoCTransaction();
        final Field field_getter = Test_getter.getClass().getDeclaredField("test0");
        field_getter.setAccessible(true);
        field_getter.set(Test_getter, "test0");
        final String result = (String) Test_getter.transactionName();
        assertEquals("field wasn't retrieved properly", result, "test0");

    }

    @Test
    void transactionValue() {
    }

    @Test
    void transactionCategory() {
    }

    @Test
    void transactionTime() {
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/setNameTest.csv"})
    void setTransactionName(String name) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction test = new BoCTransaction();

        test.setTransactionName(name);

        final Field field = test.getClass().getDeclaredField("transactionName");
        field.setAccessible(true);
        assertEquals(name, field.get(test));
    }

    @Test
    void setTransactionValue() {
    }

    @Test
    void setTransactionCategory() {
    }

    @Test
    void setTransactionTime() {
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/toStringTest.csv"})
    void testToString(String transName, String transValue, String resultStr) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction Test_toString = new BoCTransaction();
        final Field test1 = Test_toString.getClass().getDeclaredField("transactionName");
        final Field test2 = Test_toString.getClass().getDeclaredField("transactionValue");
        test1.setAccessible(true);
        test2.setAccessible(true);
        test1.set(Test_toString, transName);
        test2.set(Test_toString, new BigDecimal(transValue));

        final String foo = Test_toString.toString();
        assertEquals(resultStr, foo);
    }
}