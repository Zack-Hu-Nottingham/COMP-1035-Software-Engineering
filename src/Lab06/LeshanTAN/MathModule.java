public class MathModule {
    public static void main(String[] args) {
        // try {
        // int test = myMultiply(2000000000, 6);
        // System.out.println(test);
        // } catch (Exception e) {
        // System.out.println(e.toString());
        // }
    }

    public static int myMultiply(int firstNum, int secondNum) throws Exception {
        long newAnswer = (long) firstNum * secondNum;
        if (newAnswer > Integer.MAX_VALUE) {
            throw new Exception("Number too big");
        }
        if (newAnswer < Integer.MIN_VALUE) {
            throw new Exception("Number too small");
        }
        return firstNum * secondNum;
    }

    public static double myDivide(double firstNum, double secondNum) throws Exception {
        if (secondNum == 0) {
            throw new Exception("Division by zero");
        }
        return firstNum / secondNum;
    }
}