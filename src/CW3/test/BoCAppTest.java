import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoCAppTest {
    private static String ln = System.lineSeparator();
    private static String appMenu = ln + "What do you want to do?" + ln
            + "O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it"
            + ln;

    private static String appExit = "Goodbye!" + ln;

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

        BoCApp.UserCategories = null;

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

    //Author: Yicun Duan
    //Last Modified: 2021/4/24 21:51
    @DisplayName("Test for ChangeTransactionCategory")
    @ParameterizedTest
    @CsvFileSource(resources = "changeTransactionCategoryTest.csv")
    void ChangeTransactionCategory(String designedInput, int testNumber) {
        String defaultCategoryOverview =
                        "1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)"+ ln +
                        "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + ln +
                        "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                        "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + ln ;
        String defaultTransactionOverview =
                        "1) Rent (Unknown) - ¥850.00" + ln +
                        "2) Phone Bill (Bills) - ¥37.99" + ln +
                        "3) Electricity Bill (Bills) - ¥75.00" + ln +
                        "4) Sainsbury's Checkout (Groceries) - ¥23.76" + ln +
                        "5) Tesco's Checkout (Groceries) - ¥7.24" + ln +
                        "6) RockCity Drinks (Social) - ¥8.50" + ln +
                        "7) The Mooch (Social) - ¥13.99" + ln;

        switch (testNumber) {
            case 1:
                testOutcome(designedInput,
                            defaultCategoryOverview
                                         + appMenu
                                         + defaultTransactionOverview +
                        "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                         + defaultTransactionOverview +
                        "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                         + defaultTransactionOverview +
                        "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                         + defaultTransactionOverview +
                        "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                         + defaultTransactionOverview +
                        "Which transaction ID?" + ln + "Transaction doesn't exist. Please input again." + ln
                                         + defaultTransactionOverview +
                        "Which transaction ID?" + ln
                                         + "\t- " + BoCApp.UserTransactions.get(0).toString() + ln
                                         + defaultCategoryOverview +
                        "Which category will it move to?" + ln + "Invalid input. Please input a valid integer." + ln
                                         + defaultCategoryOverview +
                        "Which category will it move to?" + ln + "Category doesn't exist. Please input again." + ln
                                         + defaultCategoryOverview +
                        "Which category will it move to?" + ln + "Category doesn't exist. Please input again." + ln
                                         + defaultCategoryOverview +
                        "Which category will it move to?" + ln
                                + "[Social](Budget: ¥100.00) - ¥872.49 (¥772.49 Overspent)" + ln
                                + "[Unknown](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)" + ln
                                + appMenu
                                + appExit);
                break;

            default:
                break;
        }

        return;
    }

    private void testOutcome(String designedInput, String expectedOutcome) {

        InputStream alterInput = new ByteArrayInputStream(designedInput.getBytes());
        OutputStream outContent = new ByteArrayOutputStream();
        PrintStream outPrint = new PrintStream(outContent);

        System.setIn(alterInput);
        System.setOut(outPrint);

        BoCApp.main(null);

        System.setOut(System.out);
        System.setIn(System.in);

        assertEquals(expectedOutcome, outContent.toString(), "The outcome is unexpected.");
    }

}

