
public class MathModule {
		 public static void main(String[] args) {
			 try {
				 long myAnswer= myMultiply(200000000,6);
				 System.out.println(myAnswer);
				 double myAnswer1=myDivision(5,0);
				 System.out.println(myAnswer1);
				 
			 }catch(Exception ex) {
				 System.out.println(ex.toString());
			 }
		 }
		 public static long myMultiply(int firstNum, int secondNum) throws Exception {
			/* return firstNum * secondNum; */
			 long newAnswer = (long)firstNum * secondNum;
			 if (newAnswer > Integer.MAX_VALUE) {
			 throw new Exception("Number too big");
			 }
			 return firstNum * secondNum;

		}
		 public static double myDivision(int firstNum, int secondNum) throws Exception{
		
			 if(secondNum ==0) {
				 throw new Exception("The division is 0");
			 }
			double answer=(double)firstNum/secondNum;
			 System.out.println("It passed");
			 
			return answer;
			
			 
		 }

}
