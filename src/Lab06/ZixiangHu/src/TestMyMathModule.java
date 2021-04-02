import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyMathModule {
    static int input1, input2, input3, input4;
    @BeforeAll
    static void setup() {
        input1 = 3;
        input2 = 1;
        input3 = 2000000000;
        input4 = -2000000000;
    }
    @Test
//    void myMultiply() {
//        int myAnswer = 0;
//        try {
//            myAnswer = MathModule.myMultiply(input1, input4);
//        } catch (Exception e) {}
//        assertEquals(-6000000000, myAnswer);
//    }
    void stub() throws Exception {
        float myAnswer = 0;
        try {
            myAnswer = MathModule.stub(7.0f, 3.0f);
            assertEquals(2.33, myAnswer, 0.01);
        } catch (Exception e) {
            if (e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return;
            }
        }

    }
    void testError() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myMultiply(input1, input3);
            assertEquals(2000000000, myAnswer);
            System.out.println();
        } catch(Exception e) {
            if(e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return; // it passed
            }
        }
//        fail("it failed");
    }
}