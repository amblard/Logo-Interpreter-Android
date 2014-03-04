package unittest.repeat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import Openfile.Openfile;

import com.example.parser.Interpreter;

public class RepeatUnitTest {
	Interpreter interpreter;
	
	public RepeatUnitTest(){
		
	}
	
	@Before
	public void setUp() throws Exception {
		interpreter=new Interpreter(null);
	}
	// Test repeat avec commande
	@Test
	public void test() {
		try {
		interpreter.execute(Openfile.fileReader(RepeatUnitTest.class.getResource("unitTest1.logo").getPath()));
		assertEquals(5,interpreter.returnValue,0);
		assertEquals(20,interpreter.getTurtle().getX(),0);
	} catch (NoSuchPrimitiveException e) {
		e.printStackTrace();
	}
	
	}
	
	// Test repeat avec deux commande
	@Test
	public void test2(){
	try {
		interpreter.execute(Openfile.fileReader(RepeatUnitTest.class.getResource("unitTest2.logo").getPath()));
		assertEquals(4,interpreter.getTurtle().getX(),0.0000001);
			
	} catch (NoSuchPrimitiveException e) {
		e.printStackTrace();
	}		
		
		
	}
	
	
	// test de repeat imbriqués
	@Test
	public void test3(){
	try {
		System.out.println("START TEST 3");
		interpreter.execute(Openfile.fileReader(RepeatUnitTest.class.getResource("unitTest3.logo").getPath()));
		assertEquals(50,interpreter.getTurtle().getX(),0);
			
	} catch (NoSuchPrimitiveException e) {
		e.printStackTrace();
	}
	}
	// test de repeat imbriqués
	@Test
	public void test4(){
	try {
		interpreter.execute(Openfile.fileReader(RepeatUnitTest.class.getResource("unitTest4.logo").getPath()));
		assertEquals(25,interpreter.getTurtle().getX(),0.0000001);
			
	} catch (NoSuchPrimitiveException e) {
		e.printStackTrace();
	}
	
	}

}
