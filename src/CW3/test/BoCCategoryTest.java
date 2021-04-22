import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {



    // Author: Leshan Tan
    // Last Modified: 2021/4/22
    @Test
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        List BoCCategoryNameList = new ArrayList();
        int times = 0;
        while(times < 10){
            BoCCategory instance = new BoCCategory();
            final Field fieldName = instance.getClass().getDeclaredField("CategoryName");
            final Field fieldBudget = instance.getClass().getDeclaredField("CategoryBudget");
            final Field fieldSpend = instance.getClass().getDeclaredField("CategorySpend");
            fieldName.setAccessible(true);
            fieldBudget.setAccessible(true);
            fieldSpend.setAccessible(true);
            String name = (String) fieldName.get(instance);
            BoCCategoryNameList.add(name);
            assertEquals(new BigDecimal("0.00"),fieldBudget.get(instance),"Field CategoryBudget didn't match");
            assertEquals(new BigDecimal("0.00"), fieldSpend.get(instance),"Field CategorySpend didn't match");
            for (int n=0;n<times;n++){
                assertNotEquals(BoCCategoryNameList.get(n), name,"Constructor did not create unique Category Name");
            }
            times++;
        }
    }

    @Test
    void categoryName() {
    }

    @Test
    void categoryBudget() {
    }

    @Test
    void categorySpend() {
    }

    @Test
    void setCategoryName() {
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