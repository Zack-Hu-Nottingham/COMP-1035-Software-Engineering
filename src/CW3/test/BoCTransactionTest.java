import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    //Author: LinCHEN (biylc2)
    //Last modified: 2021/04/18
    @Test
    @ParameterizedTest
    @CsvFileSource(resources = {"trans_setTransactionValueInt.csv"})

    void setTransactionValue1(int input,int expected) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction test1= new BoCTransaction(null,new BigDecimal(1),4);

        final BigDecimal changedVal1= new BigDecimal(input);
        test1.setTransactionValue(changedVal1);

        final Field field = test1.getClass().getDeclaredField("transactionValue");
        field.setAccessible(true);
        BigDecimal result = (BigDecimal) field.get(test1);
        int equals= result.compareTo(changedVal1);
        assertEquals(expected,equals);
    }

    //Author: LinCHEN (biylc2)
    //Last modified: 2021/04/18
    @Test
    @ParameterizedTest
    @CsvFileSource(resources = {"trans_setTransactionValueDouble.csv"})

    void setTransactionValue2(double input1,String input2,int expected) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction test2= new BoCTransaction(null,new BigDecimal(0),4);
        test2.setTransactionValue(new BigDecimal(input1));
        final BigDecimal changedVal2= new BigDecimal(input2);
        final Field field = test2.getClass().getDeclaredField("transactionValue");
        field.setAccessible(true);
        BigDecimal result = (BigDecimal) field.get(test2);
        int equals= result.compareTo(changedVal2);
        assertEquals(expected,equals);
    }

    //Author: LinCHEN (biylc2)
    //Last modified: 2021/04/18
    @Test
    @ParameterizedTest
    @CsvFileSource(resources = {"trans_setTransactionValueString.csv"})

    void setTransactionValue3(String input1,int expected) throws NoSuchFieldException, IllegalAccessException {

           try {
               final BoCTransaction test3 = new BoCTransaction(null, new BigDecimal(0), 4);
               final BigDecimal changedVal3 = new BigDecimal((input1));
               test3.setTransactionValue(changedVal3);
               final Field field = test3.getClass().getDeclaredField("transactionValue");
               field.setAccessible(true);
               BigDecimal result = (BigDecimal) field.get(test3);
               int equals = result.compareTo(changedVal3);
               assertEquals(expected, equals);
           }
           catch (NumberFormatException e){
               fail("The character is invalid.");
           }


    }

    //Author: LinCHEN (biylc2)
    //Last modified: 2021/04/18
    @Test
    @ParameterizedTest
    @CsvFileSource(resources = {"trans_setTransactionValueLong.csv"})

    void setTransactionValue4(long input1,int expected) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction test4= new BoCTransaction(null,new BigDecimal(0),4);
        final BigDecimal changedVal4 = new BigDecimal((input1));
        test4.setTransactionValue (changedVal4);
        final Field field = test4.getClass().getDeclaredField("transactionValue");
        field.setAccessible(true);
        BigDecimal result = (BigDecimal) field.get(test4);
        int equals= result.compareTo(changedVal4);
        assertEquals(expected,equals);
    }

    //Author: LinCHEN (biylc2)
    //Last modified: 2021/04/18
    @Test
    @ParameterizedTest
    @CsvFileSource(resources = {"trans_setTransactionValueTwo.csv"})
    //if the two value are the same
    //if the first is valid

    void setTransactionValue5(int input1,int input2,int unexpected) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction test5= new BoCTransaction(null,new BigDecimal(0),4);
        final BigDecimal firstChar= new BigDecimal(input1);
        final BigDecimal sndChar = new BigDecimal(input2);

        test5.setTransactionValue(firstChar);
        test5.setTransactionValue(sndChar);

        final Field field = test5.getClass().getDeclaredField("transactionValue");
        field.setAccessible(true);
        BigDecimal result = (BigDecimal) field.get(test5);
        int equals= result.compareTo(sndChar);
        assertNotEquals(unexpected,equals,"The function cannot be set twice.");

    }

    //Author: LinCHEN (biylc2)
    //Last modified: 2021/04/18
    @Test
    void setTransactionValue6(){
        final BoCTransaction test6= new BoCTransaction(null,new BigDecimal(0),4);
        int time=0;
        BigDecimal big1= new BigDecimal("300.00");

        while (true){
            try{
                test6.setTransactionValue(big1);
                fail("UnsupportedOperationException is not thrown as expected");
            }
            catch (Exception e){
                assertTrue(e instanceof UnsupportedOperationException);

            }
        }

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
