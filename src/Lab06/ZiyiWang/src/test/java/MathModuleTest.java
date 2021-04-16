import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


class MathModuleTest {

    private static int input1,input2,input3,input4,input5,input6;

    @BeforeAll
    static void setup(){
        input1 = 3;
        input2 = 6;
        input3 = 2000000000;
        input4 = -2000000000;
        input5 = 7;
        input6 = 0;
    }
    //@Ignore
    @Test
    void myMultiply()  {
        //fail("It failed");
        try {
            int myAnswer = MathModule.myMultiply(input1, input2);
            //Assertions.assertEquals(12,myAnswer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //assertEquals(10, myAnswer);
    }

    @Test
    void testError1() {
        try {
            int myAnswer = MathModule.myMultiply(input2, input3);
            Assertions.assertEquals(1200,myAnswer);
        } catch(Exception e) {
            if(e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return; // it passed
            }
        }
        fail("it failed");
    }

    @Test
    void testError2() {
        try {
            int myAnswer = MathModule.myMultiply(input2, input4);
        } catch(Exception e) {
            if(e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return; // it passed
            }
        }
        fail("it failed");
    }

    @Test
    void TestMyDivide() throws Exception {
//        int myAns = 0;
//        try {
//            myAns = MathModule.myDivide(input2, input1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            assertEquals(2, myAns);
//        }
        double myAns = MathModule.myDivide(input2,input1);
        assertEquals(2,(int)myAns);
    }

    @Test
    void TestMyDivide2() throws Exception {
        double myAns = MathModule.myDivide(input5,input1);
        assertEquals(2.333,myAns,0.001);
    }

    @Test
    void TestZero(){
        try {
            double myAnswer = MathModule.myDivide(input5, input6);
        }
        catch(Exception e) {
            if(e.getClass() == Exception.class) {
                System.out.println("Exception is thrown!");
                return; // it passed
            }
        }
        fail("it failed");
    }

}
