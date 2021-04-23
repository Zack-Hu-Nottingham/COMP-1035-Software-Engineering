import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {

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

    // Author: Ziyi Wang
    // Last modified: 2021/4/23 19:31
    @Test
    void setCategoryBudget(){
        final BoCCategory stest = new BoCCategory();    //new object

        float input = 20.00F;
        //argument passed to setCategoryBudget is incompatible with the type expected
        stest.setCategoryBudget(input);    // set the budget with float type
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