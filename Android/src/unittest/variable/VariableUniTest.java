package unittest.variable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import Openfile.Openfile;


import com.example.parser.Interpreter;

public class VariableUniTest {
	
	Interpreter interpreter;
	
	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter(null);
	}

	// test MAKE FD
	@Test
	public void test1() throws NoSuchPrimitiveException {
		interpreter.execute(Openfile.fileReader(VariableUniTest.class.getResource("unitTest1.logo").getPath()));
		assertEquals(100,interpreter.getTurtle().getX(),0);
	}
	
	// test MAKE FD FD
	@Test
	public void test2() throws NoSuchPrimitiveException {
		interpreter.execute(Openfile.fileReader(VariableUniTest.class.getResource("unitTest2.logo").getPath()));
		assertEquals(200,interpreter.getTurtle().getX(),0);
	}
	
	
	// test MAKE REPEAT FD
	@Test
	public void test3() throws NoSuchPrimitiveException {
		interpreter.execute(Openfile.fileReader(VariableUniTest.class.getResource("unitTest3.logo").getPath()));
		assertEquals(400,interpreter.getTurtle().getX(),0);
	}

	// test MAKE Custom
		@Test
		public void test4() throws NoSuchPrimitiveException {
			interpreter.execute(Openfile.fileReader(VariableUniTest.class.getResource("unitTest4.logo").getPath()));
			assertEquals(100,interpreter.getTurtle().getX(),0);
		}
		
		// test MAKE MAKE Custom REPEAT FD RT
				@Test
				public void test5() throws NoSuchPrimitiveException {
					interpreter.execute(Openfile.fileReader(VariableUniTest.class.getResource("unitTest5.logo").getPath()));
					assertEquals(100,interpreter.getTurtle().getX(),0.0000000001);
				}
	


}
