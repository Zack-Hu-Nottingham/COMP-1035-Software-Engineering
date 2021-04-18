import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest {
    @Test
    void BoCTransaction() throws NoSuchFieldException, IllegalAccessException{
        final BoCTransaction boc = new BoCTransaction();
        final Field fieldName = boc.getClass().getDeclaredField("transactionName");
        final Field fieldValue = boc.getClass().getDeclaredField("transactionValue");
        final Field fieldCategory = boc.getClass().getDeclaredField("transactionCategory");
        final Field fieldTime = boc.getClass().getDeclaredField("transactionTime");
        fieldName.setAccessible(true);
        fieldValue.setAccessible(true);
        fieldCategory.setAccessible(true);
        fieldTime.setAccessible(true);
        assertEquals("[Pending Transaction]", fieldName.get(boc),"Field transactionName didn't match");
        assertEquals(null, fieldValue.get(boc),"Field transactionValue didn't match");
        assertEquals(0, fieldValue.get(boc),"Field transactionCategory didn't match");
        assertEquals(null, fieldValue.get(boc),"Field transactionTime didn't match");
    }

    @Test
    void transactionName() {
    }

    @Test
    void transactionValue() throws  NoSuchFieldException, IllegalAccessException{
        final BoCTransaction boc = new BoCTransaction();
        final Field field = boc.getClass().getDeclaredField("transactionValue");
        BigDecimal expectValue = new BigDecimal(1);
        field.setAccessible(true);
        field.set(boc, expectValue);
        final BigDecimal result = boc.transactionValue();
        assertEquals( expectValue, result, "Field transactionValue wasn't retrieved properly");
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