public class MathModule {
    public static void main(String[] args) throws Exception {
        System.out.println(myMultiply(2000000000, 6));
    }
    public static int myMultiply(int firstNum, int secondNum) throws Exception {
        long newAnswer = (long)firstNum * secondNum;
        if (newAnswer > Integer.MAX_VALUE)
            throw new Exception("Number too big");
        if (newAnswer < Integer.MIN_VALUE)
            throw new Exception("Number too small");

        return firstNum * secondNum;

    }
    public static float stub(float firstNum, float secondNum) throws Exception{
        float result = firstNum / secondNum;
        if (result > Integer.MAX_VALUE)
            throw new Exception("Number is too big");
        if (result < Integer.MIN_VALUE)
            throw new Exception("Number is too small");
        return result;
    }
}




