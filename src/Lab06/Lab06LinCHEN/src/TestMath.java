import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestMath {
	private static int input1 ;
	private static int input2 ;
	private static int input3;
	//@Ignore
	/*void test() {
		fail("Not yet implemented");
	}*/
	
	@BeforeAll
	  static void setter() {
		   input1 = 3;
		   input2 = 4;
		   input3= 2000000000;
	   }
	
	@Test
	void myMultiply() {
	//  int myAnswer = MathModule.myMultiply(4, 2);
    //	assertEquals(8, myAnswer);
	//int AnswerTest= MathModule.myMultiply(input1, input2);
	//assertEquals(12,AnswerTest);
		/*int myAnswer = 0;
		try {
		myAnswer = MathModule.myMultiply(input1, input2);
		} catch(Exception e) { }
		assertEquals(18, myAnswer);
*/
			long myAnswer = 0;
			try {
			myAnswer = MathModule.myMultiply(input2, input3);
			} catch(Exception e) {
			if(e.getClass() == Exception.class) {
			System.out.println("Exception is thrown!");
			return; // it passed
			}
			 }
			fail("it failed");
	}
	@Test
	void myDivisionTest() {
		double answer=MathModule.myDivision(input2, input1);
		
	}


}
