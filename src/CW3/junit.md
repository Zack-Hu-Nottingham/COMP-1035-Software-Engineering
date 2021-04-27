内嵌测试类：
@DisplayName("内嵌测试类")
public class NestUnitTest {
    @BeforeEach
    void init() {
        System.out.println("测试方法执行前准备");
    }

    @Nested
    @DisplayName("第一个内嵌测试类")
    class FirstNestTest {
        @Test
        void test() {
            System.out.println("第一个内嵌测试类执行测试");
        }
    }

    @Nested
    @DisplayName("第二个内嵌测试类")
    class SecondNestTest {
        @Test
        void test() {
            System.out.println("第二个内嵌测试类执行测试");
        }
    }
}


基础参数测试（数据不多时可以适用 @ValueSource /@ CsvSource）

@ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void testNumberShouldBeEven(int num) {
        Assertions.assertEquals(0, num % 2);
}

@ParameterizedTest
@CsvSource({"1,One", "2,Two", "3,Three"})
void testDataFromCsv(long id, String name) {
	System.out.printf("id: %d, name: %s", id, name);
}

基础参数测试（数据多时可以适用 @ CsvFileSource）
@ParameterizedTest
@CsvFileSource(resources = "trans_setTransactionValueString.csv")

基础参数测试（传递空值 @EmptySource /@NullSource/@NullAndEmptySource）
可以和@ValueSource 同时使用

@ParameterizedTest 
@NullSource 
Void isBlank_ShouldReturnTrueForNullInputs(String input) { assertTrue(Strings.isBlank(input)); }

@ParameterizedTest 
@EmptySource 
void isBlank_ShouldReturnTrueForEmptyStrings(String input) { assertTrue(Strings.isBlank(input)); }



1.	// run 3 times, 1 for empty, 1 for null, 1 for ""
2.	    @ParameterizedTest(name = "#{index} - isEmpty()? {0}")
3.	    @EmptySource
4.	    @NullSource
5.	    //@NullAndEmptySource
6.	    @ValueSource(strings = {""})
7.	    void test_is_empty_true(String arg) {
8.	        assertTrue(isEmpty(arg));
9.	    }
10.	 
11.	    @ParameterizedTest(name = "#{index} - isEmpty()? {0}")
12.	    @ValueSource(strings = {" ", "\n", "a", "\t"})
13.	    void test_is_empty_false(String arg) {
14.	        assertFalse(isEmpty(arg));
15.	    }
16.	

基础参数测试（传递class,用name,value进行限制）
@ParameterizedTest 
@EnumSource(Month.class) // passing all 12 months 
void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) { 
int monthNumber = month.getValue(); 
assertTrue(monthNumber >= 1 && monthNumber <= 12); }

@ParameterizedTest
@EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"}) 
void someMonths_Are30DaysLong(Month month) { 
final boolean isALeapYear = false; 
assertEquals(30, month.length(isALeapYear)); }

基础参数测试（传递method）

@ParameterizedTest 
@MethodSource("provideStringsForIsBlank") 
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) 
{ assertEquals(expected, Strings.isBlank(input)); }

private static Stream<Arguments> provideStringsForIsBlank() { 
return Stream.of( Arguments.of(null, true), 
Arguments.of("", true), 
Arguments.of(" ", true), 
Arguments.of("not blank", false) ); }


断言 Assert
assertNull(java.lang.Object object)	检查对象是否为空
assertNotNull(java.lang.Object object)	检查对象是否不为空
assertEquals(long expected, long actual)	检查long类型的值是否相等
assertEquals(double expected, double actual, double delta)	检查指定精度的double值是否相等
assertFalse(boolean condition)	检查条件是否为假
assertTrue(boolean condition)	检查条件是否为真
assertSame(java.lang.Object expected, java.lang.Object actual)	检查两个对象引用是否引用同一对象（即对象是否相等）
assertNotSame(java.lang.Object unexpected, java.lang.Object actual)	检查两个对象引用是否不引用统一对象(即对象不等)
 





捕获异常测试
方法1：
@Test(expected = IllegalArgumentException.class)
public void canVote_throws_IllegalArgumentException_for_zero_age() {
    Student student = new Student();
    student.canVote(0);
}
方法2：
@Rule
public ExpectedException thrown= ExpectedException.none();
@Test
public void canVote_throws_IllegalArgumentException_for_zero_age() {
    Student student = new Student();
    thrown.expect(NullPointerException.class);
    student.canVote(0);
}

//异常信息message

@Test
public void canVote_throws_IllegalArgumentException_for_zero_age() {
    Student student = new Student();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("age should be +ve");
    student.canVote(0);
}

方法三：

@Test
public void canVote_throws_IllegalArgumentException_for_zero_age() {
    Student student = new Student();
    try {
        student.canVote(0);
    } catch (IllegalArgumentException ex) {
        assertThat(ex.getMessage(), containsString("age should be +ve"));
    }
    fail("expected IllegalArgumentException for non +ve age");
}
void testSetTransactionName4Before(){
        BoCTransaction transaction = new BoCTransaction(tName,tValue,tCat);
        try {
            transaction.setTransactionName(tName2);
        } catch(Exception e) { 
            return;
        }
        
        fail("It should have exception");
    }

assertThrows:

[assertThrows](https://cloud.tencent.com/developer/article/1387407)
@Test
    @Order(8)
    void testSetTransactionName2() throws Exception{
        BoCTransaction transaction = new BoCTransaction();

        Exception e = assertThrows(Exception.class, () -> {
            transaction.setTransactionName(tName3);
        });
        assertEquals("Name cannot set to null", e.getMessage());
    }

模拟I/O:
[simulate I/O](https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input)


