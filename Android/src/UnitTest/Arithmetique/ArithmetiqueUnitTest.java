package UnitTest.Arithmetique;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import com.example.parser.Interpreter;

public class ArithmetiqueUnitTest {

	Interpreter interpreter;
	public ArithmetiqueUnitTest() {
	}

	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter(null);
	}

	@SuppressWarnings("deprecation")
	
	// test chiffre simple
	@Test
	public void test() {
		try {
			interpreter.execute("fd 5");			
			assertEquals(5, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test addition
	@Test
	public void test2() {
		try {
			interpreter.execute("fd 5+5");			
			assertEquals(10, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}

	// test soustraction
	@Test
	public void test3() {
		try {
			interpreter.execute("fd 5-3");			
			assertEquals(2, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
}
