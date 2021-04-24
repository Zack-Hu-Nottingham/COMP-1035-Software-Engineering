import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
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

    // Author: Zixiang Hu
    // Last Modified: 2021/4/19 20:24
    // test the time
    @ParameterizedTest
    @CsvSource({
            "A test, 200, 2"
    })
    @DisplayName("Test1 for main constructor")
    void MainBoCTransaction1(String tName, BigDecimal tValue, int tCat) {
        BoCTransaction boc = new BoCTransaction(tName, tValue, tCat);
        Date timeTest = new Date();
        assertEquals(tName, boc.transactionName());
        assertEquals(tValue, boc.transactionValue());
        assertEquals(tCat, boc.transactionCategory());
        assertEquals(boc.transactionTime().getTime(),timeTest.getTime(), 10);
    }

    // test illegal trans name
    @Test
    @DisplayName("Test2 for main constructor"
    void MainBoCTransaction2() {
        try {
            BoCTransaction boc = new BoCTransaction("", new BigDecimal(200), 2);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Transaction name should not be null.");
            return;
        }
        fail("No exception thrown.");
    }

    // test whether the time created is correct
    @Test
    @DisplayName("Test3 for main constructor")
    void MainBoCTransactio3() {
        BoCTransaction boc = new BoCTransaction("A test", new BigDecimal(200), 2);
        Date timeTest = new Date();
        assertNotNull(boc.transactionTime());
        assertEquals(boc.transactionTime().getTime(), timeTest.getTime(), 1);
    }

    @Test
    @DisplayName("Test4 for main constructor")
    void MainBoCTransaction4() {
        try {
            BoCTransaction boc = new BoCTransaction("A test", new BigDecimal(200), -2);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Transaction category should not be minus."));
            return;
        }
        fail("No exception thrown.");
    }

    @Test
    @DisplayName("Test5 for main constructor")
    void MainBoCTransaction5() {
        try {
            BoCTransaction boc = new BoCTransaction("A test", new BigDecimal(-200), 2);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Transaction budget should greater than zero."));
            return;
        }
        fail("No exception thrown.");
    }

    @Test
    @DisplayName("Test6 for main constructor")
    void MainBoCTransaction6() {
        try {
            BoCTransaction boc = new BoCTransaction("Transaction name with more than 25 char", new BigDecimal(-200), 2);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Transaction name should be shorter than 25 characters."));
            return;
        }
        fail("No exception thrown.");
    }




    // Author: Yingxiao Huo
    // Last modified: 2021/4/18
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
    // Last Modified: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"transactionValue.csv"})
    void transactionValue(String input, String expectation) throws  NoSuchFieldException, IllegalAccessException{
        final BoCTransaction boc = new BoCTransaction();
        final Field fieldValue = boc.getClass().getDeclaredField("transactionValue");
        fieldValue.setAccessible(true);
        fieldValue.set(boc, new BigDecimal(input));
        final BigDecimal result = boc.transactionValue();
        assertEquals( new BigDecimal(expectation), boc.transactionValue(), "Field transactionValue wasn't retrieved properly");
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

    // Author: Zixiang Hu
    // Last modified: 2021/4/21 22:33
    @Test
    void transactionTime1() {
        BoCTransaction test = new BoCTransaction("wzy-hzx", new BigDecimal("2000"), 2);
        assertNotNull(test.transactionTime());
    }

    // Author: Zixiang Hu
    // Last modified: 2021/4/21 22:50
    @Test
    void transactionTime2() {
        BoCTransaction test = new BoCTransaction();
        assertNull(test.transactionTime());
    }

    // Author: Yicun Duan
    // Last modified: 2021/4/18
    @ParameterizedTest
    @CsvFileSource(resources = {"setNameTest.csv"})
    void setTransactionName(String name) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction test = new BoCTransaction();

        test.setTransactionName(name);

        final Field field = test.getClass().getDeclaredField("transactionName");
        field.setAccessible(true);
        assertEquals(name, field.get(test));
    }

    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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

    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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

    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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

    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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

    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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

    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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
    

    // Author: Zixiang Hu
    // Last modified: 2021/4/18
    @ParameterizedTest
    @CsvFileSource(resources = { "/Trans_setCategory.csv" })

    void setTransactionCategory(int input, int expectation) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction trans = new BoCTransaction("wzy-hzx", new BigDecimal("2000"), 1);
        trans.setTransactionCategory(input);
        final Field field = trans.getClass().getDeclaredField("transactionCategory");
        field.setAccessible(true);
        assertEquals(expectation, field.get(trans), "Fields didn't match");
    }

    @Test
    void setTransactionTime() {
    }

    // Author: Yingxiao Huo
    // Last modified: 2021/4/18
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
