import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.Ignore;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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

    // Author: Zixiang Hu (scyzh6)
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
    @DisplayName("Test2 for main constructor")
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
    @ParameterizedTest
    @CsvSource({
            "Yingxiao Huo, Yingxiao Huo",
            ", name is not set.",
            "awdwdadwadawdsdaawdwadasdwadawdwdw, Name can not longer than 25 characters."
    })
    void transactionName(String name, String expection) throws NoSuchFieldException, IllegalAccessException {
        final BoCTransaction Test_getter = new BoCTransaction();
        final Field field_getter = Test_getter.getClass().getDeclaredField("transactionName");
        field_getter.setAccessible(true);
        if(name == null){
            try {
                field_getter.set(Test_getter, name);
                final String result =  Test_getter.transactionName();
                fail();
            }catch (Exception ex1){
                assertEquals(expection, ex1.getMessage());
            }
        }
        else {
            if(name.length() > 25){
                try {
                    field_getter.set(Test_getter, name);
                    final String result = (String) Test_getter.transactionName();
                    fail();
                }catch (Exception ex2){
                    assertEquals(expection, ex2.getMessage());
                }
            }
            else {
                field_getter.set(Test_getter, name);
                final String result = Test_getter.transactionName();
                assertEquals(expection, result);
            }
        }
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

    // Author: Ziyi Wang (scyzw10)
    // Last modified: 2021/4/18 21:15
    @ParameterizedTest
    @ValueSource(ints = {0,1,5,100})
    void transactionCategory(int input) {
        final BoCTransaction tCate = new BoCTransaction("wzy", new BigDecimal("2000"), input);
        int num = tCate.transactionCategory();
        assertEquals(input,num);
    }

    // Author: Zixiang Hu (scyzh6)
    // Last modified: 2021/4/21 22:33
    @Test
    void transactionTime1() {
        BoCTransaction test = new BoCTransaction("wzy-hzx", new BigDecimal("2000"), 2);
        assertNotNull(test.transactionTime());
    }

    // Author: Zixiang Hu (scyzh6)
    // Last modified: 2021/4/21 22:50
    @Test
    void transactionTime2() {
        BoCTransaction test = new BoCTransaction();
        assertNull(test.transactionTime());
    }

    // Author: Yicun Duan (scyyd3)
    // Last modified: 2021/4/23 16:50
    @ParameterizedTest
    @CsvFileSource(resources = {"setTransactionNameTest.csv"})
    void setTransactionName(String transName, BigDecimal transValue, int transCate, String giveName, String expectName) throws NoSuchFieldException, IllegalAccessException {
        if (transName == null && transValue == null && transCate == 0) {
            final BoCTransaction test_instance = new BoCTransaction();
            if (giveName == null) {
                try {
                    test_instance.setTransactionName(null);
                    fail("IllegalArgumentException is not thrown out.");
                } catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        assertEquals("The transactionName is invalid.", e.getMessage(), "The message in IllegalArgumentException is not expected.");
                    } else {
                        fail("Unexpected exception type.");
                    }
                }
            } else {
                test_instance.setTransactionName(giveName);

                final Field field = test_instance.getClass().getDeclaredField("transactionName");
                field.setAccessible(true);
                assertEquals(expectName, field.get(test_instance), "Transaction name doesn't match.");
            }

            return;
        }

        final BoCTransaction test_instance = new BoCTransaction(transName, transValue, transCate);

        UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class, ()->{test_instance.setTransactionName(giveName);});
        assertEquals("Transaction name cannot be repeatedly set.", e.getMessage());

    }

    @Ignore
    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18
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

    @Ignore
    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18

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

    @Ignore
    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/18

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

        @DisplayName("tests for setTransactionValue")
        @ParameterizedTest
        @NullSource
        @CsvFileSource(resources = "trans_setTransactionValueString.csv")

        // Author: LinCHEN (biylc2)
        // Last modified: 2021/04/23

    void setTransactionValue(String str1,String expected) throws NoSuchFieldException, IllegalAccessException {

        //The following code is to test different type of values,and whether the negative value can be set
        BoCTransaction set1= new BoCTransaction();
        BigDecimal setData = null;
        final Field field = set1.getClass().getDeclaredField("transactionValue");
        field.setAccessible(true);

        boolean strResult1 = str1.matches("-?[0-9]+.?[0-9]*");
        boolean strResult2=str1.matches("[+-]?[0-9]+.?[0-9]{0,32}[Ee]?[+-]?[0-9]?[1-9]");
        boolean strResult3 = str1.matches("-?[0-9]{0,12}+.?[0-9]{0,16}");


        if(str1 == null) {
            Exception e0 = assertThrows(IllegalArgumentException.class, () -> {
                set1.setTransactionValue(new BigDecimal(str1));
            });
            //"The value cannot be null"
            assertEquals(expected, "e0.getMessage()");
        }

        if(strResult1 == false){
            if(strResult2 == false) {
                Exception e1 = assertThrows(Exception.class, () -> {
                    set1.setTransactionValue(new BigDecimal(str1));
                });
                //"The value is invalid and cannot be set"
                assertEquals(expected, e1.getMessage());
            }
            else{

            }
        }else {
            if (strResult3 == false) {
                Exception e2 = assertThrows(Exception.class, () -> {
                    set1.setTransactionValue(new BigDecimal(str1));
                });
                //"The data overflows"
                assertEquals(expected, e2.getMessage());
            } else {
                try {
                    setData = new BigDecimal(str1);
                    if (setData.compareTo(new BigDecimal("0.00")) <= 0) {
                        Exception e3 = assertThrows(IllegalArgumentException.class, () -> {
                            set1.setTransactionValue(new BigDecimal(str1));
                        });
                        //"The value should be a positive number, the set fails"
                        assertEquals(expected, e3.getMessage());
                    } else {
                        set1.setTransactionValue(setData);
                        BigDecimal result = (BigDecimal) field.get(set1);
                        int equals = result.compareTo(setData);

                        if (equals != 0) {
                            Exception e4 = assertThrows(Exception.class, () -> {
                                set1.setTransactionValue(new BigDecimal(str1));
                            });
                            //"The set value is not the same as the expected one"
                            assertEquals(expected, e4.getMessage());
                        }
                    }
                    }catch(Exception e){
                        assertEquals(expected, "The data cannot be set. An error occurs");
                    }
                }

            }

        if ((BigDecimal) field.get(set1)==null){
           // field.set(set1,new BigDecimal("300.00"));
            set1.setTransactionValue(new BigDecimal("300.00"));

        }
        //The following code is to test the value can only be set once in the condition of two constructors.

            final BoCTransaction set2 = new BoCTransaction(null,new BigDecimal("200.00"),4);

            Exception e5 = assertThrows(UnsupportedOperationException.class, () -> {
                set1.setTransactionValue(new BigDecimal("900.00"));
            });

            //"The value cannot be set twice"
            assertEquals(expected, e5.getMessage());

            Exception e6 = assertThrows(UnsupportedOperationException.class, () -> {
                set2.setTransactionValue(new BigDecimal("900.00"));
            });
            //"The value cannot be set twice"
            assertEquals(expected, e6.getMessage());

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

        if (transValue == null){
            try{
                test1.set(Test_toString, transName);
                test2.set(Test_toString, null);
                final String foo = Test_toString.toString();
            }catch (Exception ex1){
                assertEquals(resultStr, ex1.getMessage());
            }
        }
        else{
            if (Integer.parseInt(transValue) >= 0) {
                test1.set(Test_toString, transName);
                test2.set(Test_toString, new BigDecimal(transValue));
                final String foo = Test_toString.toString();
                assertEquals(resultStr, foo);
            } else {
                try {
                    test1.set(Test_toString, transName);
                    test2.set(Test_toString, new BigDecimal(transValue));
                    final String foo = Test_toString.toString();
                    fail();
                }catch (Exception ex){
                    assertEquals(resultStr, ex.getMessage());
                }
            }
        }
    }


        @DisplayName("tests for isComplete function")
        @Test

        // Author: LinCHEN(biylc2)
        // Last Modify: 2021/04/24 14:37

    void isCompleteTest(){
        String nameSet= "Tester";
        BigDecimal numSet= new BigDecimal("980.08");
        //Cases when using default constructor
        BoCTransaction isCom1= new BoCTransaction();
        BoCTransaction isCom2= new BoCTransaction(nameSet,null,0);
        BoCTransaction isCom3= new BoCTransaction(null,numSet,0);
        BoCTransaction isCom4= new BoCTransaction(nameSet,numSet,0);

        assertEquals(isCom1.isComplete(),false);
        assertEquals(isCom2.isComplete(),false);
        assertEquals(isCom3.isComplete(),false);
        assertEquals(isCom4.isComplete(),true);

    }
}
