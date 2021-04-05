import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MathModuleTest {
	
	static private int input1;
	static private int input2;
	static private int input3;
	static private int input4;
	static private int input5;
	static private int input6;

	@Ignore
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void myMultiply_normal() throws Exception {
		int myAnswer = 0;
		try {
			myAnswer = MathModule.myMultiply(input1, input4);
		} catch(Exception e) { 
			System.out.println(e.toString());
		}
		
		assertEquals(18, myAnswer);
	
	}
	
	@Test
	void testError_multi() {
		int myAnswer = 0;
		
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
	void myDivide_normal() throws Exception{
		int myAnswer1 = 0;
		int myAnswer2 = 0;
		
		try {
			myAnswer1 = MathModule.myDivide(input2, input1);
			myAnswer2 = MathModule.myDivide(input2, input1);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		assertEquals(2, myAnswer1);
		assertEquals(2, myAnswer2);
	}
	
	@Test
	void testError_div() {
		int myAnswer = 0;
		
		try {
			myAnswer = MathModule.myDivide(input1, input6);
		} catch(Exception e) {
			if(e.getClass() == Exception.class) {
				System.out.println("Exception is thrown!");
				return; // it passed
			}
		}
			fail("it failed");
		}
	
	@BeforeAll
	static void setup() {
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
		input4 = -2000000000;
		input5 = 7;
		input6 = 0;
	}
}
