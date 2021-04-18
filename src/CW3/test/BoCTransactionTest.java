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

    @Test
    void testToString() {
    }
}
