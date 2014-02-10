package UnitTest.Repeat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import Openfile.Openfile;

import com.example.parser.Interpreter;

public class RepeatUnitTest extends Openfile{
	Interpreter interpreter;
	
	public RepeatUnitTest(){
		
	}
	
	@Before
	public void setUp() throws Exception {
		interpreter=new Interpreter(null);
	}

	@Test
	public void test() {
		try {
		interpreter.execute(fileReader(RepeatUnitTest.class.getResource("unitTest1").getPath()));
		assertEquals(5,interpreter.returnValue,0);
		assertEquals(20,interpreter.getTurtle().getX(),0);
	} catch (NoSuchPrimitiveException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}	
	@Test
	public void test1(){
	try {
		interpreter.execute(fileReader(RepeatUnitTest.class.getResource("unitTest2").getPath()));
		assertEquals(4,interpreter.getTurtle().getX(),0.0000001);
			
	} catch (NoSuchPrimitiveException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
		
	}
	
	@Test
	public void test3(){
	try {
		interpreter.execute(fileReader(RepeatUnitTest.class.getResource("unitTest3").getPath()));
		assertEquals(50,interpreter.getTurtle().getX(),0);
			
	} catch (NoSuchPrimitiveException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
