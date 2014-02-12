package UnitTest.Fonctions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import Openfile.Openfile;
import UnitTest.Repeat.RepeatUnitTest;

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

}
