import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoCAppTest {

    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/28 00:58

    //set "ln" as the default line separator
    private static String ln = System.lineSeparator();
    //previously set some frequently used strings
    private static String appMenu = "\n" + "What do you want to do?" + "\n"
            + " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it"
            + ln;
    private static String appExit = "Goodbye!" + ln;

    private static String defaultCategoryOverview =
            "1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)" + ln +
                    "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + ln +
                    "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                    "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + ln;
    private static String defaultTransactionOverview =
            "1) Rent (Unknown) - ¥850.00" + ln +
                    "2) Phone Bill (Bills) - ¥37.99" + ln +
                    "3) Electricity Bill (Bills) - ¥75.00" + ln +
                    "4) Sainsbury's Checkout (Groceries) - ¥23.76" + ln +
                    "5) Tesco's Checkout (Groceries) - ¥7.24" + ln +
                    "6) RockCity Drinks (Social) - ¥8.50" + ln +
                    "7) The Mooch (Social) - ¥13.99" + ln;


    @BeforeEach
    void setUpBeforeEach() {
        BoCApp.UserCategories = new ArrayList<BoCCategory>();
        BoCApp.UserTransactions = new ArrayList<BoCTransaction>();

        // SETUP EXAMPLE DATA //
        BoCApp.UserCategories.add(new BoCCategory("Unknown"));
        BoCCategory BillsCategory = new BoCCategory("Bills");
        BillsCategory.setCategoryBudget(120.00F);
        BoCApp.UserCategories.add(BillsCategory);
        BoCCategory Groceries = new BoCCategory("Groceries");
        Groceries.setCategoryBudget(75.00F);
        BoCApp.UserCategories.add(Groceries);
        BoCCategory SocialSpending = new BoCCategory("Social");
        SocialSpending.setCategoryBudget(100.00F);
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

    // Author: Ziyi Wang (scyzw10)
    // Last modified: 2021/4/27 18:43
    @DisplayName("Test for Main Method.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void main(int input) {
        String inviteAddCategory = "What is the title of the category?" + ln + "What is the budget for this category?" + ln;
        String inviteAddTransaction = "What is the title of the transaction?" + ln + "What is the value of the transaction?" + ln;
        String inviteChangeTCate1 = "Which transaction ID?" + ln;
        String inviteChangeTcate2 = "Which category will it move to?" + ln;

        switch (input) {
            case 1:
                testOutcome("O\nT\n1\nX\n", appMenu + defaultCategoryOverview +
                        appMenu + defaultTransactionOverview + appMenu + "2) Phone Bill (Bills) - ¥37.99" + ln +
                        "3) Electricity Bill (Bills) - ¥75.00" + ln + appMenu + appExit);
                break;
            case 2:
                testOutcome("T\nN\nFood\n100.00\nA\nBreakfast\n5.0000\n5\nT\nO\nC\n8\n1\nT\nO\nrrr\nX\n",
                        appMenu + defaultTransactionOverview + appMenu +    // list Transaction overview
                                inviteAddCategory + "[Category added]" + ln + defaultCategoryOverview +  // new category -> add category first and print the new category overview
                                "5) [Food](Budget: ¥100.00) - ¥0.00 (¥100.00 Remaining)" + ln + appMenu +       // add transaction
                                inviteAddTransaction + defaultCategoryOverview +
                                "5) [Food](Budget: ¥100.00) - ¥0.00 (¥100.00 Remaining)" + ln +
                                "Which category do you want to add?" + ln + "[Transaction added]" + ln +
                                "[Breakfast](¥5.00) was added to [Food]" +
                                ln + appMenu + defaultTransactionOverview + "8) Breakfast (Food) - ¥5.00" + ln +    // check the new transaction list after adding
                                appMenu + defaultCategoryOverview +
                                "5) [Food](Budget: ¥100.00) - ¥5.00 (¥95.00 Remaining)" + ln +  //check the new category list after adding
                                appMenu + defaultTransactionOverview + "8) Breakfast (Food) - ¥5.00" + ln +     // change the category -> first print the transaction list
                                inviteChangeTCate1 + "\t- " + "Breakfast - ¥5.00 Date: " +
                                BoCApp.UserTransactions.get(5).transactionTime() + ln +   // the Transaction that the user want to change
                                defaultCategoryOverview + "5) [Food](Budget: ¥100.00) - ¥5.00 (¥95.00 Remaining)" + ln +    // print the category list and let the user to choose
                                inviteChangeTcate2 + "[Unknown](Budget: ¥0.00) - ¥855.00 (¥855.00 Overspent)" + ln +  // print the result of new cate and the old one
                                "[Food](Budget: ¥100.00) - ¥0.00 (¥100.00 Remaining)" + ln + appMenu +
                                defaultTransactionOverview + "8) Breakfast (Unknown) - ¥5.00" + ln + appMenu +   // check the Transaction list after changing
                                "1) [Unknown](Budget: ¥0.00) - ¥855.00 (¥855.00 Overspent)" + ln +
                                "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + ln +
                                "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                                "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + ln +
                                "5) [Food](Budget: ¥100.00) - ¥0.00 (¥100.00 Remaining)" + ln +
                                appMenu + "Command not recognised" + ln + appMenu +appExit);
                break;
        }
    }


    // Author: Lin Chen (biylc2)
    // Last Modify:2021/04/25 20:27
    @DisplayName("Test for list transactions")
    @Test
    void listTransactions() {
        testOutcome("T\nX\n", appMenu + defaultTransactionOverview + appMenu + appExit);
    }


    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/23 20:50
    //Reason: Test whether this function could generate an expected outcome.
    @Test
    void categoryOverview() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //build a new outstream
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //reset the outstream
        System.setOut(new PrintStream(outContent));

        //use default constructor
        BoCApp test_instance = new BoCApp();

        //get access to private method
        Method m_categoryOverview = test_instance.getClass().getDeclaredMethod("CategoryOverview");
        m_categoryOverview.setAccessible(true);

        //call the private function
        m_categoryOverview.invoke(test_instance);

        //transfer the outContent to string
        String result = outContent.toString();

        //reset the system outstream
        System.setOut(System.out);

        //check whether outcome is expected.
        assertEquals("1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)" + ln +
                "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + ln +
                "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + ln, result, "The overview is unexpected.");

    }


    // Author: Leshan Tan (sqylt2), Ziyi Wang (scyzw10)
    // Last Modified: 2021/4/26 11:11
    @DisplayName("Test for ListTransactionsForCategory")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, -1}) // the input values
    void listTransactionsForCategory(int categoryNumber) {
        String expectedOutput0 = "1) Rent (Unknown) - ¥850.00" + ln; // the expected output string when categoryNumber == 0
        String expectedOutput1 = "2) Phone Bill (Bills) - ¥37.99" + ln + // the expected output string when categoryNumber == 1
                "3) Electricity Bill (Bills) - ¥75.00" + ln;
        String expectedOutput2 = "4) Sainsbury's Checkout (Groceries) - ¥23.76" + ln + // the expected output string when categoryNumber == 2
                "5) Tesco's Checkout (Groceries) - ¥7.24" + ln;
        String expectedOutput3 = "6) RockCity Drinks (Social) - ¥8.50" + ln + // the expected output string when categoryNumber == 3
                "7) The Mooch (Social) - ¥13.99" + ln;
        String expectedErrorMessage = "Cannot find transactions with category "; // the expected output string when categoryNumber haven't been added to the list

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // create the output stream outContent
        System.setOut(new PrintStream(outContent)); // set the System output to this stream
        BoCApp boc = new BoCApp(); // create an instance using default constructor
        boc.ListTransactionsForCategory(categoryNumber); // invoke the method to be tested

        switch (categoryNumber) {
            case 0: // if categoryNumber == 0
                assertEquals(expectedOutput0, outContent.toString(), "The transaction list for category 0 is unexpected");
                break;
            case 1: // if categoryNumber == 1
                assertEquals(expectedOutput1, outContent.toString(), "The transaction list for category 1 is unexpected");
                break;
            case 2: // if categoryNumber == 2
                assertEquals(expectedOutput2, outContent.toString(), "The transaction list for category 2 is unexpected");
                break;
            case 3: // if categoryNumber == 3
                assertEquals(expectedOutput3, outContent.toString(), "The transaction list for category 3 is unexpected");
                break;
            default: // if categoryNumber haven't been added to the list, it should output corresponding error message
                assertEquals(expectedErrorMessage + categoryNumber + ln, outContent.toString(), "The output for category " + categoryNumber + " is unexpected");
        }

    }

    //Author: Yicun Duan (scyyd3), Lin Chen (biylc2)
    //Last Modified: 2021/4/28 00:56
    @DisplayName("Test for ChangeTransactionCategory")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    //choose the test case
    void ChangeTransactionCategory(int testNumber) {
        switch (testNumber) {
            case 1:
                //put in the designed input and expected outcome
                testOutcome("C\n1\n4\nC\n3\n1\nC\n6\n3\nX\n",
                        appMenu
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
                                "1) [Unknown](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)" + ln +
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
                                "1) [Unknown](Budget: ¥0.00) - ¥75.00 (¥75.00 Overspent)" + ln +
                                "2) [Bills](Budget: ¥120.00) - ¥37.99 (¥82.01 Remaining)" + ln +
                                "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + ln +
                                "4) [Social](Budget: ¥100.00) - ¥872.49 (¥772.49 Overspent)" + ln +
                                "Which category will it move to?" + ln
                                + "[Groceries](Budget: ¥75.00) - ¥39.50 (¥35.50 Remaining)" + ln
                                + "[Social](Budget: ¥100.00) - ¥863.99 (¥763.99 Overspent)" + ln

                                + appMenu
                                + appExit);
                break;

            case 2:
                testOutcome("C\njbl\n-23\n-12345678912345689\n'\ue250'\n1\n-199\n233\nooooo\n4\nX\n",
                        appMenu
                                + defaultTransactionOverview +
                                "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                + defaultTransactionOverview +
                                "Which transaction ID?" + ln + "Transaction doesn't exist. Please input again." + ln
                                + defaultTransactionOverview +
                                "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                + defaultTransactionOverview +
                                "Which transaction ID?" + ln + "Invalid input. Please input a valid integer." + ln
                                + defaultTransactionOverview +
                                "Which transaction ID?" + ln
                                + "\t- " + BoCApp.UserTransactions.get(0).toString() + ln
                                + defaultCategoryOverview +
                                "Which category will it move to?" + ln + "Category doesn't exist. Please input again." + ln
                                + defaultCategoryOverview +
                                "Which category will it move to?" + ln + "Category doesn't exist. Please input again." + ln
                                + defaultCategoryOverview +
                                "Which category will it move to?" + ln + "Invalid input. Please input a valid integer." + ln
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


    // Author: Ziyi Wang (scyzw10), Leshan Tan (sqylt2)
    // Last modified: 2021/4/26 14；39
    @DisplayName("Test for AddTransaction function.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void AddTransaction(int input) {
        String invitesTitle = "What is the title of the transaction?" + ln;
        String invitesValue = "What is the value of the transaction?" + ln;
        String invitesCategory = "Which category do you want to add?" + ln;
        String invitesVaild = "Invalid input. Please enter a valid number." + ln;

        switch (input) {
            case 1:
                testOutcome("A\nElectricity Bill\n9.00\n2\nX\n",
                        appMenu + invitesTitle + invitesValue +
                                defaultCategoryOverview + invitesCategory +
                                "[Transaction added]" + ln + "[Electricity Bill](¥9.00) was added to [Bills]" +
                                ln + appMenu + appExit);
                break;
            case 2:
                testOutcome("A\nWater Bill\naaa\n-1.0\n9.0000\nrr\n-1\n100\n2\nX\n",
                        appMenu + invitesTitle + invitesValue +
                                invitesVaild + invitesValue + "Invalid number. The value must bigger than zero." +
                                ln + invitesValue +defaultCategoryOverview +
                                invitesCategory + invitesVaild + defaultCategoryOverview +
                                invitesCategory + "Invalid number. Category not exist." + ln +
                                defaultCategoryOverview + invitesCategory +
                                "Invalid number. Category not exist." + ln
                                + defaultCategoryOverview + invitesCategory + "[Transaction added]" + ln +
                                "[Water Bill](¥9.00) was added to [Bills]" + ln + appMenu + appExit);
                break;
        }
    }


    //Author: Yicun Duan (scyyd3), Lin Chen (biylc2)
    //Last Modified: 2021/4/28 00:09
    private void testOutcome(String designedInput, String expectedOutcome) {

        //reset the input and output stream
        //this step is to simulate user input and get output from screen
        InputStream alterInput = new ByteArrayInputStream(designedInput.getBytes());
        OutputStream outContent = new ByteArrayOutputStream();
        PrintStream outPrint = new PrintStream(outContent);
        System.setIn(alterInput);
        System.setOut(outPrint);

        //call the main function
        BoCApp.main(null);

        //reset the input and output stream to default
        System.setOut(System.out);
        System.setIn(System.in);

        //check whether outcome is expected
        assertEquals(expectedOutcome, outContent.toString(), "The outcome is unexpected.");
    }

    //Author: Yingxiao Huo (scyyh9), Leshan Tan (sqylt2)
    //Last modify: 2021/4/28 15:12
    @DisplayName("Test for AddCategory")
    @ParameterizedTest
    @CsvSource({
            "'N\nCW3 is so easy\n100\n',1",
            "'N\nBills\n',2",
            "'N\nblabla#$%%^&\n-100\n',3",
            "'N\nabc\nabc@#$\n',3",
            "'N\nRent\n999\n',4",
            "'N\n123451234512345123\n100', 5"
    })
    //Because if use reflect to invoke private method, input and output stream is difficult to handle, so this test use main\
    //Method to test AddCategory method.
    void testAddCategory(String input, int testNum) {
        //String which made up expectation.
        String option_ch1 = "\n" + "What do you want to do?" + "\n" +
                " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n";
        String Input_string = "What is the title of the category?" + "\r\n" +
                "What is the budget for this category?" + "\r\n";

        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        InputStream input1 = new ByteArrayInputStream(input.getBytes());

        if (testNum == 1) {
            //Normal case, to test if the method can run normally.

            //Because there are two kinds of line separators which is "\r\n" and "\n", the expectation can not just use ln.
            String expectation = "\n" +
                    "What do you want to do?" + "\n" +
                    " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n" +
                    "What is the title of the category?" + "\r\n" +
                    "What is the budget for this category?" + "\r\n" +
                    "[Category added]" + "\r\n" +
                    "1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)" + "\r\n" +
                    "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + "\r\n" +
                    "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + "\r\n" +
                    "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + "\r\n" +
                    "5) [CW3 is so easy](Budget: ¥100.00) - ¥0.00 (¥100.00 Remaining)" + "\r\n" + "\n" +
                    "What do you want to do?" + "\n" +
                    " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n";

            //Call main method to test.
            System.setIn(input1);
            System.setOut(new PrintStream(output1));
            BoCApp.main(null);
            System.setOut(System.out);
            System.setIn(System.in);
            String result = output1.toString();
            assertEquals(expectation, result);
        } else if (testNum == 2) {
            //To test when user enter a name which is aalready exist.
            System.setIn(input1);
            System.setOut(new PrintStream(output1));
            BoCApp.main(null);
            System.setOut(System.out);
            System.setIn(System.in);
            String result = output1.toString();
            assertEquals(option_ch1 +"What is the title of the category?\r\n" +  "This category is already exist." + option_ch1, result);

        } else if (testNum == 3) {
            //To test when user enter a invalid budget:
            //negative number and a string.
            System.setIn(input1);
            System.setOut(new PrintStream(output1));
            BoCApp.main(null);
            System.setOut(System.out);
            System.setIn(System.in);
            String result = output1.toString();
            assertEquals(option_ch1  + Input_string + "Budget only can be positive number." + option_ch1, result);

        } else if (testNum == 4) {
            //Normal case, practical significance.
            String expectation4 = "\n" +
                    "What do you want to do?" + "\n" +
                    " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n" +
                    "What is the title of the category?" + "\r\n" +
                    "What is the budget for this category?" + "\r\n" +
                    "[Category added]" + "\r\n" +
                    "1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)" + "\r\n" +
                    "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + "\r\n" +
                    "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + "\r\n" +
                    "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + "\r\n" +
                    "5) [Rent](Budget: ¥999.00) - ¥0.00 (¥999.00 Remaining)" + "\r\n" + "\n" +
                    "What do you want to do?" + "\n" +
                    " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n";

            System.setIn(input1);
            System.setOut(new PrintStream(output1));
            BoCApp.main(null);
            System.setOut(System.out);
            System.setIn(System.in);
            String result = output1.toString();
            assertEquals(expectation4, result);
        }
        else if(testNum == 5){
            //To test when user enter a name longer than 15 characters.
            String expectation5 = "\n" +
                    "What do you want to do?" + "\n" +
                    " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n" +
                    "What is the title of the category?" + "\r\n" +
                    "What is the budget for this category?" + "\r\n" +
                    "[Category added]" + "\r\n" +
                    "1) [Unknown](Budget: ¥0.00) - ¥850.00 (¥850.00 Overspent)" + "\r\n" +
                    "2) [Bills](Budget: ¥120.00) - ¥112.99 (¥7.01 Remaining)" + "\r\n" +
                    "3) [Groceries](Budget: ¥75.00) - ¥31.00 (¥44.00 Remaining)" + "\r\n" +
                    "4) [Social](Budget: ¥100.00) - ¥22.49 (¥77.51 Remaining)" + "\r\n" +
                    "5) [123451234512345](Budget: ¥100.00) - ¥0.00 (¥100.00 Remaining)" + "\r\n" + "\n" +
                    "What do you want to do?" + "\n" +
                    " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + "\r\n";
            System.setIn(input1);
            System.setOut(new PrintStream(output1));
            BoCApp.main(null);
            System.setOut(System.out);
            System.setIn(System.in);
            String result = output1.toString();
            assertEquals(expectation5, result);
        }
    }
}

