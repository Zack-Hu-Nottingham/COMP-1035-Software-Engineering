import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {

    // Author: Leshan Tan
    // Last Modified: 2021/4/21
    @Test
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory boc = new BoCCategory();
        final Field fieldName = boc.getClass().getDeclaredField("CategoryName");
        final Field fieldBudget = boc.getClass().getDeclaredField("CategoryBudget");
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend");
        fieldName.setAccessible(true);
        fieldBudget.setAccessible(true);
        fieldSpend.setAccessible(true);
        assertEquals("New Category", fieldName.get(boc),"Field CategoryName didn't match");
        assertEquals(new BigDecimal("0.00"),fieldBudget.get(boc),"Field CategoryBudget didn't match");
        assertEquals(new BigDecimal("0.00"), fieldSpend.get(boc),"Field CategorySpend didn't match");
    }

    //author: Yingxiao Huo
    //Last Modified time: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/categoryNameGetter.csv"})
    void categoryName(String name, String expection) throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory Test_getter = new BoCCategory();
        final Field field_getName = Test_getter.getClass().getDeclaredField("CategoryName");
        field_getName.setAccessible(true);
        field_getName.set(Test_getter, name);
        final String result = (String) Test_getter.CategoryName();
        assertEquals(result, expection);
    }

    @Test
    void categoryBudget() {
    }

    @Test
    void categorySpend() {
    }

    //author: Yingxiao Huo
    //Last modified time: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/categoryNameSetter.csv"})
    void setCategoryName(String name, String expection) throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory Test_setter = new BoCCategory();
        Test_setter.setCategoryName(name);
        final Field field_setname = Test_setter.getClass().getDeclaredField("CategoryName");
        field_setname.setAccessible(true);
        assertEquals(expection, field_setname.get(Test_setter));
    }
    
    @Test
    void setCategoryBudget() {
    }

    @Test
    void addExpense() {
    }

    @Test
    void removeExpense() {
    }

    @Test
    void resetBudgetSpend() {
    }

    @Test
    void getRemainingBudget() {
    }

    @Test
    void testToString() {
    }
}
