import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest {

    @Test
    void transactionName() {
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
        assertNotEquals(unexpected,equals);

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