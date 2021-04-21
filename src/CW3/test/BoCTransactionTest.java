import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest {

    // Author: Leshan Tan
    // Last Modified: 2021/4/18
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
        assertNull( fieldValue.get(boc),"Field transactionValue didn't match");
        assertEquals(0, fieldCategory.get(boc),"Field transactionCategory didn't match");
        assertNull(fieldTime.get(boc),"Field transactionTime didn't match");
    }


    //author: Yingxiao Huo
    //last modified on； 2021/4/18
    @Test
    void transactionName() throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction Test_getter = new BoCTransaction();
        final Field field_getter = Test_getter.getClass().getDeclaredField("test0");
        field_getter.setAccessible(true);
        field_getter.set(Test_getter, "test0");
        final String result = (String) Test_getter.transactionName();
        assertEquals("field wasn't retrieved properly", result, "test0");

    }

    // Author: Leshan Tan
    // Last Modified: 2021/4/18
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

    // Author: Ziyi Wang
    // Last modified: 2021/4/18 21:15
    @ParameterizedTest
    @CsvFileSource(resources = { "/Trans_getCategory.csv" })
    void transactionCategory(int input, int expectation) {
        final BoCTransaction tCate = new BoCTransaction("wzy-hzx", new BigDecimal("2000"), input);
        int num = tCate.transactionCategory();
        assertEquals(expectation,num);
    }

    @Test
    void transactionTime() {
    }

    //author: Yicun Duan
    //Last modified on: 2021/4/18
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

    //author: Yingxiao Huo
    //Last modified on: 2021/4/18
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
