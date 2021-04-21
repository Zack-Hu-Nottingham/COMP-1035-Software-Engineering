import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {

    @Test
    void categoryName() {
    }

    //Author: Yicun Duan
    //Last Modified: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"getBudgetTest.csv"})
    void categoryBudget(String budget) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory budgetTest =  new BoCCategory();
        final Field field = budgetTest.getClass().getDeclaredField("CategoryBudget");
        field.setAccessible(true);
        field.set(budgetTest, new BigDecimal(budget));

        final BigDecimal result = budgetTest.CategoryBudget();

        assertEquals(result, new BigDecimal(budget));

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

    //Author: Yicun Duan
    //Last Modified: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/getRemainingBudgetTest.csv"})
    void getRemainingBudget(String budget, String spend, String remain) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory remainTest =  new BoCCategory();
        final Field field_budget = remainTest.getClass().getDeclaredField("CategoryBudget");
        field_budget.setAccessible(true);
        field_budget.set(remainTest, new BigDecimal(budget));
        final Field field_spend = remainTest.getClass().getDeclaredField("CategorySpend");
        field_spend.setAccessible(true);
        field_spend.set(remainTest, new BigDecimal(spend));

        final BigDecimal result = remainTest.getRemainingBudget();

        assertEquals(result, new BigDecimal(remain));

    }

    @Test
    void testToString() {
    }
}