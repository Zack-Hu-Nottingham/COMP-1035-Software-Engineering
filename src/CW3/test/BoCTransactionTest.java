import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//import jdk.nashorn.internal.ir.annotations.Ignore;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.junit.Assert.assertThat;

class BoCTransactionTest {

    // Author: Leshan Tan (sqylt2)
    // Last modified: 2021/4/26 22:10
    // latest version of testing default constructor, using assertAll to get all failures
    @Test
    @DisplayName("Test for default constructor")
    void BoCTransaction(){
        BoCTransaction boc = new BoCTransaction(); // create an instance with default constructor
        Date currentTime = new Date(); // get the current time
        assertAll("Should return the fields of a transaction instance", // each fields should be what we expected
                () -> assertEquals("[Pending Transaction]", boc.transactionName(), "Field transactionName didn't match"),
                () -> assertNull( boc.transactionValue(),"Field transactionValue didn't match"),
                () -> assertEquals(0, boc.transactionCategory(),"Field transactionCategory didn't match"),
                () -> assertEquals(currentTime.getTime(),boc.transactionTime().getTime(),10,"Field transactionTime didn't match")
        );
    }


    // old version of testing default constructor, disabled
    @Disabled
    @Test
    void BoCTransactionDisabled() throws NoSuchFieldException, IllegalAccessException{
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
    // Last modified: 2021/4/23 16:06

    // test the time
    @ParameterizedTest
    @CsvSource({
            "Buy an apple, 2, 2",
            "Buy an apple pen, 998, 3",
            "Go to Apple store and buy an apple pen, 998, 3",
            ", 998, 3",
            "Buy an apple pen, 998, -3",
            "Buy an apple pen, 0, 3",
            "Buy an apple pen, -998, -3"
    })
    @DisplayName("Test for main constructor")
    void MainBoCTransaction(String tName, BigDecimal tValue, int tCat) {
        int isCaught = 0; // A flag indicate whether exception is caught
        if (tName == null) { // Test if tName input is null
            try {
                BoCTransaction boc = new BoCTransaction(null, tValue, tCat);
                fail("No exception thrown.");
            } catch (IllegalArgumentException e) {
                isCaught = 1;
                assertEquals(e.getMessage(), "Transaction name should not be null.");
            }
        }
        else if (tName.length() > 25) { // Test if name is more than 25 char
            try {
                BoCTransaction boc = new BoCTransaction(tName, tValue, tCat);
                fail("No exception thrown.");
            } catch (IllegalArgumentException e) {
                isCaught = 1;
                assertThat(e.getMessage(), containsString("Transaction name should be limited to 25 characters."));
            }
        }
        else if (tCat < 0) { // Test if category is less than 0
            try {
                BoCTransaction boc = new BoCTransaction(tName, tValue, tCat);
                fail("No exception thrown.");
            } catch (IllegalArgumentException e) {
                isCaught = 1;
                assertThat(e.getMessage(), containsString("Transaction category should not be minus."));
            }
        }
        else if (tValue.compareTo(new BigDecimal(0)) < 1 ) { // Test if transaction value is <= 0
            try {
                BoCTransaction boc = new BoCTransaction(tName, tValue, tCat);
                fail("No exception thrown.");
            } catch (IllegalArgumentException e) {
                isCaught = 1;
                assertThat(e.getMessage(), containsString("Transaction budget should greater than zero."));
            }
        }

        if (isCaught == 0) {
            BoCTransaction boc = new BoCTransaction(tName, tValue, tCat);
            Date timeTest = new Date();
            assertNotNull(boc.transactionTime()); // Test if time is created
            assertEquals(boc.transactionTime().getTime(), timeTest.getTime(), 1); // Test whether time is accurate
            assertAll("", () -> assertEquals(tName, boc.transactionName()),
                    () -> assertEquals(tValue.compareTo(boc.transactionValue()), 0) ,
                    () -> assertEquals(tCat, boc.transactionCategory())
            ); // Normal test with input
        }
    }



    // Author: Zixiang Hu (scyzh6)
    // Last modified: 2021/4/19 20:24

    @Disabled // Older version, so we disabled it
    // Test the time
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

    @Disabled // Older version
    // Test if transaction name is null
    @Test
    @DisplayName("Test2 for main constructor")
    void MainBoCTransaction2() {
        try {
            BoCTransaction boc = new BoCTransaction(null, new BigDecimal(200), 2);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Transaction name should not be null.");
            return;
        }
        fail("No exception thrown.");
    }

    @Disabled // Older version
    // Test whether the time created is not null and accurate
    @Test
    @DisplayName("Test3 for main constructor")
    void MainBoCTransactio3() {
        BoCTransaction boc = new BoCTransaction("A test", new BigDecimal(200), 2);
        Date timeTest = new Date();
        assertNotNull(boc.transactionTime());
        assertEquals(boc.transactionTime().getTime(), timeTest.getTime(), 1);
    }

    @Disabled // Older version
    // Test if category is less than 0
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

    @Disabled // Older version
    // Test if transaction value less than 0
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

    @Disabled // Older version
    // Test if transaction name is longer than 25 char
    @Test
    @DisplayName("Test6 for main constructor")
    void MainBoCTransaction6() {
        try {
            BoCTransaction boc = new BoCTransaction("Transaction name with more than 25 char", new BigDecimal(200), 2);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Transaction name should be limited to 25 characters."));
            return;
        }
        fail("No exception thrown.");
    }


    // Author: Yingxiao Huo (scyyh9)
    // Last modified: 2021/4/18

    @ParameterizedTest
    @CsvSource({
            "Yingxiao Huo, Yingxiao Huo",
            ", name is not set.",
            "awdwdadwadawdsdaawdwadasdwadawdwdw, Name can not longer than 25 characters.",
            "U+1F605,U+1F605"
    })
    @DisplayName("Test for transaction name getter")
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


    // Author: Leshan Tan (sqylt2)
    // Last modified: 2021/4/21

    @ParameterizedTest
    @CsvFileSource(resources = {"transactionValue.csv"}) // get the input  and output source
    @DisplayName("Test for transaction value getter")
    void transactionValue(String input, String expectation) throws  NoSuchFieldException, IllegalAccessException{
        final BoCTransaction boc = new BoCTransaction(); // create an instance using default constructor
        final Field fieldValue = boc.getClass().getDeclaredField("transactionValue"); // get the field transactionValue
        fieldValue.setAccessible(true); // enable to access this private field
        fieldValue.set(boc, new BigDecimal(input)); // set it to the input value in source transactionValue.csv
        final BigDecimal result = boc.transactionValue(); // get the result value from source transactionValue.csv
        assertEquals( new BigDecimal(expectation), boc.transactionValue(), "Field transactionValue wasn't retrieved properly"); // field transactionValue should be what we expected
    }


    // Author: Ziyi Wang (scyzw10)
    // Last modified: 2021/4/18 21:15

    @ParameterizedTest
    @ValueSource(ints = {0,1,5,100})
    @DisplayName("Test for transaction category getter")
    void transactionCategory(int input) {
        final BoCTransaction tCate = new BoCTransaction("wzy", new BigDecimal("2000"), input);
        int num = tCate.transactionCategory();
        assertEquals(input,num);
    }


    // Author: Zixiang Hu (scyzh6)
    // Last modified: 2021/4/21 22:33

    @ParameterizedTest
    @CsvSource({
            "Buy a bunch of flower, 20, 4",
            "Shopping in mart, 150, 3",
    })
    @DisplayName("Test for transaction time getter")
    void transactionTime(String transName, BigDecimal transValue, int transCate) {
        BoCTransaction test1 = new BoCTransaction(transName, transValue, transCate);
        Date testTime = new Date();
        assertNotNull(test1.transactionTime()); // Check if the Date object is null
        assertEquals(test1.transactionTime().getTime(), testTime.getTime(), 1); // Check if the Date object is accurate
    }


    // Author: Yicun Duan (scyyd3)
    // Last modified: 2021/4/25 23:36

    @ParameterizedTest
    @CsvFileSource(resources = {"setTransactionNameTest.csv"})
    @DisplayName("Test for transaction name setter")
    void setTransactionName(String transName, BigDecimal transValue, int transCate, String giveName, String expectName) throws NoSuchFieldException, IllegalAccessException {
        if (transName == null && transValue == null && transCate == 0) {
            final BoCTransaction test_instance = new BoCTransaction();
                try{
                    test_instance.setTransactionName(giveName);
                }catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        assertEquals("The transactionName is invalid.", e.getMessage(), "The message in IllegalArgumentException is not expected.");
                        return;
                    } else {
                        fail("Unexpected exception type.");
                    }
                }

                final Field field = test_instance.getClass().getDeclaredField("transactionName");
                field.setAccessible(true);
                assertEquals(expectName, field.get(test_instance), "Transaction name doesn't match.");

            return;
            }

        final BoCTransaction test_instance = new BoCTransaction(transName, transValue, transCate);

        UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class, ()->{test_instance.setTransactionName(giveName);});
        assertEquals("Transaction name cannot be repeatedly set.", e.getMessage());
    }


    @Disabled
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


    @Disabled
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


    @Disabled
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


    // Author: LinCHEN (biylc2)
    // Last modified: 2021/04/23

    @ParameterizedTest
    @CsvFileSource(resources = "trans_setTransactionValueString.csv")
    @DisplayName("Test for transaction value setter")
    void setTransactionValue(String str1,String expected) throws NoSuchFieldException, IllegalAccessException {
        BoCTransaction set1= new BoCTransaction();
        BigDecimal setData = null; // naming a bigDecimal type value
        final Field field = set1.getClass().getDeclaredField("transactionValue");
        field.setAccessible(true);//to test the null situation by manually setting parameter to null

        // if the string is null, the NullPointerException is expected with the correct error message"The input Number cannot be null"
        if(str1==null) {
            try {
                set1.setTransactionValue(new BigDecimal(str1));
                assertNotNull(str1, "The input Number cannot be null");
            } // The first nullPointer Exception is the what happened in the process of parsing null into String
            catch (NullPointerException e1) {
                try{
                    set1.setTransactionValue(null);
                    }// This null pointer Exception is the one caused by setting transaction value to null
                catch(NullPointerException e2) {
                    assertTrue(e2.getMessage().contains(expected));
                    return;
                }
            }
        }

        //The following code is to test the format of string value by using regular expression, and the validation of the string value
        // There are two cases of exception fail.
        // One is the exception doesn't match both regular expressions.It is considered as Number Format Exception
        // One is the exception is that the set value is non-positive

        boolean strResult1 = str1.matches("[+-]?[0-9]?+.?[0-9]*");
        boolean strResult2=str1.matches("[+-]?[0-9]+.?[0-9]*[Ee]?[+-]?[0-9]*");

        if(strResult2 == false){
            if(strResult1 == false ) {
                    try {
                        set1.setTransactionValue(new BigDecimal(str1));
                        fail("No NumberFormat exception is caught");
                    } catch (Exception e1) {
                        assertTrue(e1 instanceof NumberFormatException, "Illegal value set is caught");
                        return;
                    }

            }
            else if(str1.trim().isEmpty()){
                try {
                    set1.setTransactionValue(new BigDecimal(str1));
                    fail("No NumberFormat exception is caught");
                } catch (Exception e1) {
                    assertTrue(e1 instanceof NumberFormatException, "Illegal value set is caught");
                    return;
                }
            }
        }

        setData = new BigDecimal(str1);
        if (setData.compareTo(new BigDecimal("0.00")) <= 0) {

            Exception e3 = assertThrows(IllegalArgumentException.class, () -> {
                set1.setTransactionValue(new BigDecimal(str1));
            });
            //"The value should be a positive number, the set fails"
            assertEquals(expected, e3.getMessage());
            return;
        } else {
            set1.setTransactionValue(setData);
        }


        // The following code is to test whether the value can be set twice.
        // The failure will occur if the object with a set value can not be set twice.

        if ((BigDecimal) field.get(set1)==null){
            set1.setTransactionValue(new BigDecimal("300.00"));

        }

        //The following code is to test the value can only be set once in the condition of two constructors.

        final BoCTransaction set2 = new BoCTransaction("Tester",new BigDecimal("200.00"),4);

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
    

    // Author: Zixiang Hu (scyzh6)
    // Last modified: 2021/4/18 21:49

    @ParameterizedTest
    @CsvSource({"-100", "-50", "-25", "0", "1", "2", "3"})
    @DisplayName("Test for transaction category setter")
    void setTransactionCategory(int tCat) {
        BoCTransaction defaultBoc = new BoCTransaction();
        BoCTransaction parameterizedBoc = new BoCTransaction("Buy an apple pen", new BigDecimal("1000"), 3);
        if (tCat <= 0) {
            try {
                parameterizedBoc.setTransactionCategory(tCat);
                fail("No exception thrown");
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage(), containsString("Transaction category should greater than zero."));
                return;
            }
        }
        parameterizedBoc.setTransactionCategory(tCat);
        assertEquals(parameterizedBoc.transactionCategory(), tCat);
    }


    @Disabled
    // Author: Zixiang Hu (scyzh6)
    // Last modified: 2021/4/25 22:03

    // Disabled this method because the time should not be set after the transaction is created
    @Test
    void setTransactionTime() {
    }


    // Author: Yingxiao Huo (scyyh9)
    // Last modified: 2021/4/21 16:44

    @ParameterizedTest
    @CsvFileSource(resources = {"/toStringTest.csv"})
    @DisplayName("Test for method toString")
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


    // Author: LinCHEN (biylc2)
    // Last Modify: 2021/04/24 14:37

    @Test
    @DisplayName("Test for method isComplete")
    void isCompleteTest() throws NoSuchFieldException, IllegalAccessException {
        String nameSet= "Tester";
        BigDecimal numSet= new BigDecimal("980.08");

        //Cases when using default constructor
        final BoCTransaction isCom1 = new BoCTransaction();

        // Cause in the other function,it may have restrictions for value setting
        // In order to avoid these problems, we should manually set the value to null.
        // So as in the following cases

        final BoCTransaction isCom2 = new BoCTransaction();
        final Field fieldName2 = isCom2.getClass().getDeclaredField("transactionName");
        final Field fieldValue2 = isCom2.getClass().getDeclaredField("transactionValue");
        fieldName2.setAccessible(true);
        fieldValue2.setAccessible(true);
        fieldName2.set(isCom2, null);
        fieldValue2.set(isCom2, numSet);

        final BoCTransaction isCom3 = new BoCTransaction();
        final Field fieldName3 = isCom3.getClass().getDeclaredField("transactionName");
        final Field fieldValue3 = isCom3.getClass().getDeclaredField("transactionValue");
        fieldName3.setAccessible(true);
        fieldValue3.setAccessible(true);
        fieldName3.set(isCom3, nameSet);
        fieldValue3.set(isCom3, null);

        final BoCTransaction isCom4 = new BoCTransaction();
        final Field fieldName4 = isCom4.getClass().getDeclaredField("transactionName");
        final Field fieldValue4 = isCom4.getClass().getDeclaredField("transactionValue");
        fieldName4.setAccessible(true);
        fieldValue4.setAccessible(true);
        fieldName4.set(isCom4, nameSet);
        fieldValue4.set(isCom4, numSet);

        // assertAll will pass if each situation has passes
        assertAll("Should return results of four examples",
                () -> assertEquals(4, isCom1.isComplete()),
                () -> assertEquals(3, isCom2.isComplete()),
                () -> assertEquals(2, isCom3.isComplete()),
                () -> assertEquals(1, isCom4.isComplete())

        );
    }
}
