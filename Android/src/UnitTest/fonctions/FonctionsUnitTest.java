package UnitTest.fonctions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import Openfile.Openfile;
import UnitTest.repeat.RepeatUnitTest;

import com.example.parser.Interpreter;

public class FonctionsUnitTest extends Openfile{

	Interpreter interpreter;
	
	public FonctionsUnitTest() {
	}

	@Before
	public void setUp() throws Exception {
		interpreter=new Interpreter(null);
	}

	@Test
	public void test() {
		try {
			interpreter.execute(fileReader(FonctionsUnitTest.class.getResource("unitTest1.logo").getPath()));
			assertEquals(0,interpreter.getTurtle().getX(),0.00000001);
		} catch (NoSuchPrimitiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// test de fonction avec un repeat
	@Test
	public void test2() {
		try {
			interpreter.execute(fileReader(FonctionsUnitTest.class.getResource("unitTest2.logo").getPath()));
			assertEquals(0,interpreter.getTurtle().getX(),0.00000001);
			assertEquals(0,interpreter.getTurtle().getY(),0.00000001);
		} catch (NoSuchPrimitiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// test de fonction avec primitive aprÃ¨s la fonction
		@Test
		public void test3() {
			try {
				interpreter.execute(fileReader(FonctionsUnitTest.class.getResource("unitTest3.logo").getPath()));
				assertEquals(100,interpreter.getTurtle().getX(),0.00000001);
				assertEquals(0,interpreter.getTurtle().getY(),0.00000001);
			} catch (NoSuchPrimitiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// test création de deux fonctions avec appelle dans la deuxième de la première fonction 
		@Test
		public void test4() {
			try {
				interpreter.execute(fileReader(FonctionsUnitTest.class.getResource("unitTest4.logo").getPath()));
				assertEquals(300,interpreter.getTurtle().getX(),0.00000001);
				assertEquals(0,interpreter.getTurtle().getY(),0.00000001);
			} catch (NoSuchPrimitiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
