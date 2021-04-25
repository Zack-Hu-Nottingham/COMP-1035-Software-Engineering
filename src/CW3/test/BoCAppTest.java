import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoCAppTest {
    //Author: Yicun Duan
    //Last Modified: 2021/4/25 19:52
    private static String ln = System.lineSeparator();
    private static String appMenu = ln + "What do you want to do?" + ln
            + " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it"
            + ln;

    private static String appExit = "Goodbye!" + ln;

    //Author: Yicun Duan
    //Last Modified: 2021/4/25 19:52
    @BeforeEach
    void setUpBeforeEach() {
        BoCApp.UserCategories = new ArrayList<BoCCategory>();
        BoCApp.UserTransactions = new ArrayList<BoCTransaction>();

        // SETUP EXAMPLE DATA //
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

        BoCApp.UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
        BoCApp.UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
        BoCApp.UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

        for (int x = 0; x < BoCApp.UserTransactions.size(); x++) {
            BoCTransaction temp = BoCApp.UserTransactions.get(x);
            int utCat = temp.transactionCategory();
            BoCCategory temp2 = BoCApp.UserCategories.get(utCat);
            temp2.addExpense(temp.transactionValue());
            BoCApp.UserCategories.set(utCat, temp2);
        }
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

        Method m_categoryOverview = test_instance.getClass().getDeclaredMethod("CategoryOverview");
        m_categoryOverview.setAccessible(true);

        m_categoryOverview.invoke(test_instance);

        String result = outContent.toString();

        System.setOut(System.out);

        assertEquals("1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)"+ ln +
                              "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + ln +
                              "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                              "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + ln, result, "The overview is unexpected.");

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
    //Last Modified: 2021/4/25 19:51
    @DisplayName("Test for ChangeTransactionCategory")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void ChangeTransactionCategory(int testNumber) {
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
                testOutcome("C\n1\n4\nC\n3\n1\nC\n6\n3\nX\n",
                            defaultCategoryOverview
                                          + appMenu
                                          + defaultTransactionOverview +
                        "Which transaction ID?" + ln
                                          + "\t- " + BoCApp.UserTransactions.get(0).toString() + ln
                                          + defaultCategoryOverview +
                        "Which category will it move to?" + ln
                                          + "[Social](Budget: ¥100.00) - ¥872.49 (¥772.49 Overspent)" + ln
                                          + "[Unknown](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)" + ln

                                          + appMenu +
                                          "1) Rent (Social) - ¥850.00" + ln +
                                          "2) Phone Bill (Bills) - ¥37.99" + ln +
                                          "3) Electricity Bill (Bills) - ¥75.00" + ln +
                                          "4) Sainsbury's Checkout (Groceries) - ¥23.76" + ln +
                                          "5) Tesco's Checkout (Groceries) - ¥7.24" + ln +
                                          "6) RockCity Drinks (Social) - ¥8.50" + ln +
                                          "7) The Mooch (Social) - ¥13.99" + ln +
                        "Which transaction ID?" + ln
                                          + "\t- " + BoCApp.UserTransactions.get(2).toString() + ln +
                                          "1) [Unknown](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)"+ ln +
                                          "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + ln +
                                          "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                                          "4) [Social](Budget: ¥100.00) - ¥872.49 (¥772.49 Overspent)" + ln +
                        "Which category will it move to?" + ln
                                          + "[Unknown](Budget: ¥0.00) - ¥75.00 (¥75.00 Overspent)" + ln
                                          + "[Bills](Budget: ¥120.00) - ¥37.99 (¥82.01 Remaining)" + ln

                                          + appMenu +
                                          "1) Rent (Social) - ¥850.00" + ln +
                                          "2) Phone Bill (Bills) - ¥37.99" + ln +
                                          "3) Electricity Bill (Unknown) - ¥75.00" + ln +
                                          "4) Sainsbury's Checkout (Groceries) - ¥23.76" + ln +
                                          "5) Tesco's Checkout (Groceries) - ¥7.24" + ln +
                                          "6) RockCity Drinks (Social) - ¥8.50" + ln +
                                          "7) The Mooch (Social) - ¥13.99" + ln +
                        "Which transaction ID?" + ln
                                          + "\t- " + BoCApp.UserTransactions.get(5).toString() + ln +
                                          "1) [Unknown](Budget: ¥0.00) - ¥75.00 (¥75.00 Overspent)"+ ln +
                                          "2) [Bills](Budget: ¥120.00) - ¥37.99 (¥82.01 Remaining)" + ln +
                                          "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                                          "4) [Social](Budget: ¥100.00) - ¥872.49 (¥772.49 Overspent)" + ln +
                        "Which category will it move to?" + ln
                                          + "[Groceries](Budget: ¥75.00) - ¥39.50 (¥35.50 Remaining)" + ln
                                          + "[Social](Budget: ¥100.00) - ¥863.99 (¥763.99 Overspent)" + ln

                                          + appMenu
                                          + appExit);


            case 2:
                testOutcome("C\njbl\n-23\n-12345678912345689\n'\ue250'\n1\n-199\n233\n123456789123456789\n4\nX\n",
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

    //Author: Yicun Duan
    //Last Modified: 2021/4/25 19:55
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

