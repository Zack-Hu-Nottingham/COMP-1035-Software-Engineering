import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoCAppTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void listTransactions() {
    }

    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/23 20:50
    @Test
    void categoryOverview() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BoCApp test_instance = new BoCApp();

        BoCApp.UserCategories = new ArrayList<BoCCategory>();

        BoCApp.UserCategories.add(new BoCCategory("Unknown"));
        BoCCategory BillsCategory = new BoCCategory("Bills");
        BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
        BoCApp.UserCategories.add(BillsCategory);
        BoCCategory Groceries = new BoCCategory("Groceries");
        Groceries.setCategoryBudget(new BigDecimal("75.00"));
        BoCApp.UserCategories.add(Groceries);
        BoCCategory SocialSpending = new BoCCategory("Social");
        SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
        BoCApp.UserCategories.add(SocialSpending);

        Method m_categoryOverview = test_instance.getClass().getDeclaredMethod("CategoryOverview");
        m_categoryOverview.setAccessible(true);

        m_categoryOverview.invoke(test_instance);

        String result = outContent.toString();

        System.setOut(null);

        assertEquals("1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)" + System.lineSeparator() +
                "2) Bills(¥120.00) - Est. ¥0.00 (¥120.00 Remaining)" + System.lineSeparator() +
                "3) Groceries(¥75.00) - Est. ¥0.00 (¥75.00 Remaining)" + System.lineSeparator() +
                "4) Social(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)"
                + System.lineSeparator(), result, "The overview is unexpected.");

    }

    // Author: Zixiang Hu
    // Last modified: 4/18
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
    void listTransactionsForCategory() {
    }
}
