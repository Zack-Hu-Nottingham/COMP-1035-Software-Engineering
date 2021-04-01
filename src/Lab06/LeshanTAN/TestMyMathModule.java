import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class TestMyMathModule {
    private static int input1;
    private static int input2;
    private static int input3;
    private static int input4;
    private static int input5;
    private static int input6;

    @BeforeAll
    static void setup() {
        input1 = 3;
        input2 = 6;
        input3 = 2000000000;
        input4 = 7;
        input5 = 0;
        input6 = -2000000000;
    }

    // @Ignore
    // @Disabled
    @Test
    void myMultiply() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myMultiply(input1, input2); // 3*6
        } catch (Exception e) {
        }
        assertEquals(18, myAnswer);
        // fail("Error.");
    }

    @Test
    void testError1() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myMultiply(input2, input3);// 6*2000000000
        } catch (Exception e) {
            if (e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return;
            }
        }
        fail("it failed");
    }

    @Test
    void testError2() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myMultiply(input2, input6);// 6*(-2000000000)
        } catch (Exception e) {
            if (e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return;
            }
        }
        fail("it failed");
    }

    @Test
    void testExpectedException() {
        assertThrows(Exception.class, () -> MathModule.myMultiply(input2, input3));// 6*2000000000
    }

    @Test
    void myDivide1() {
        double myAnswer = 0;
        try {
            myAnswer = MathModule.myDivide(input2, input1);// 6/2
        } catch (Exception e) {
        }
        assertEquals(2, myAnswer, 0);
    }

    @Test
    void myDivide2() {
        double myAnswer = 0;
        try {
            myAnswer = MathModule.myDivide(input4, input1);// 7/3
        } catch (Exception e) {
        }
        assertEquals(2.333, myAnswer, 0.001);
    }

    @Test
    void myDivideZero() {
        double myAnswer = 0;
        try {
            myAnswer = MathModule.myDivide(input1, input5);// 3/0
        } catch (Exception e) {
            if (e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return;
            }
        }
        fail("it failed");
    }
}
