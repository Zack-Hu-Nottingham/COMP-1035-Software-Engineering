public class MathModule {
    public static void main(String[] args) {
//        int num1 = 8;
//        int num2 = 7;
//        int num3 = myMultiply(num1,num2);
//        System.out.println(num3);
//        try {
//            System.out.println(myMultiply(2000000000, 6));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        try {
//            int test = myMultiply(2000000000, 6);
//            System.out.println(test);
//        } catch(Exception e) {
//            System.out.println(e.toString());
//        }
   }
    public static int myMultiply(int firstNum, int secondNum) throws Exception {
        long newAnswer = (long)firstNum * secondNum;
        if (newAnswer > Integer.MAX_VALUE) {
            throw new Exception("Number too big");
        }else if (newAnswer < Integer.MIN_VALUE){
            throw new Exception("Number too small");
        }
        return firstNum * secondNum;
    }

    public static double myDivide(int num1,int num2) throws Exception {
        if (num2 == 0) {
            throw new Exception("divide by zero.");
        }
        return ((double)num1/(double)num2);
    }

}
