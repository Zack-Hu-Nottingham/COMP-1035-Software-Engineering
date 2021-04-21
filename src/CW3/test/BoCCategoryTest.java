import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {

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
        assertEquals(name, field_setname.get(Test_setter));
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