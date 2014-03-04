package unittest.graphique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;
import Openfile.Openfile;

import com.example.parser.Interpreter;


public class GraphiqueUnitTest {

	Interpreter interpreter;
	public GraphiqueUnitTest() {
	}

	
	
	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter(null);

	}

	// test FD
	@Test
	public void test() {
		try {
			interpreter.execute(Openfile.fileReader(GraphiqueUnitTest.class.getResource("unitTest1.logo").getPath()));
			assertEquals(60, interpreter.getTurtle().getX(),0);
			assertEquals(0, interpreter.getTurtle().getY(),0);
		} catch (NoSuchPrimitiveException e) {
			fail(e.toString());
		}			
		
	}
	
	// test BK
	@Test
	public void test2() {
		try {
			interpreter.execute(Openfile.fileReader(GraphiqueUnitTest.class.getResource("unitTest2.logo").getPath()));
			assertEquals(-55, interpreter.getTurtle().getX(),0);
			assertEquals(0, interpreter.getTurtle().getY(),0);
		} catch (NoSuchPrimitiveException e) {
			fail(e.toString());
		}			
	}
	
	// test RT 90 puis FD (coordonnée Y)
	@Test
	public void test3() {
		try {
			interpreter.execute(Openfile.fileReader(GraphiqueUnitTest.class.getResource("unitTest3.logo").getPath()));
			assertEquals(0, interpreter.getTurtle().getX(),0.00000001); // valeur d'erreur != 0 car imprécision due au sin / cos
			assertEquals(20, interpreter.getTurtle().getY(),0.00000001);
		} catch (NoSuchPrimitiveException e) {
			fail(e.toString());
		}			
	}
	
	// test d'un carré (retour au point de départ)
		@Test
		public void test4() {
			try {
				interpreter.execute(Openfile.fileReader(GraphiqueUnitTest.class.getResource("unitTest4.logo").getPath()));
				assertEquals(0, interpreter.getTurtle().getX(),0.00000001); // valeur d'erreur != 0 car imprécision due au sin / cos
				assertEquals(0, interpreter.getTurtle().getY(),0.00000001);
			} catch (NoSuchPrimitiveException e) {
				fail(e.toString());
			}			
		}
		
		// test LT (rotation gauche) 90 puis FD 
		@Test
		public void test5() {
			try {
				interpreter.execute(Openfile.fileReader(GraphiqueUnitTest.class.getResource("unitTest5.logo").getPath()));
				assertEquals(0, interpreter.getTurtle().getX(),0.00000001); // valeur d'erreur != 0 car imprécision due au sin / cos
				assertEquals(-100, interpreter.getTurtle().getY(),0.00000001);
			} catch (NoSuchPrimitiveException e) {
				fail(e.toString());
			}			
		}


}
