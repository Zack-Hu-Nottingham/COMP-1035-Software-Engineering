import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest {

    @Test
    void transactionName() {
    	final BoCTransaction Test_getter = new BoCTransaction();
        final Field field_getter = Test_getter.getClass().getDeclaredField("transactionName");
        field_getter.setAccessible(true);
        field_getter.set(Test_getter, "test0");
        final String result = (String) Test_getter.transactionName();
        assertEquals("test0", result, "field wasn't retrieved properly");
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

    @Test
    void setTransactionName() {
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
