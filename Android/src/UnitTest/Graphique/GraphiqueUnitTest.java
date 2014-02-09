package UnitTest.Graphique;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import com.example.parser.Interpreter;

import UnitTest.Arithmetique.ArithmetiqueUnitTest;

public class GraphiqueUnitTest {

	Interpreter interpreter;
	public GraphiqueUnitTest() {
	}

	private String fileReader(String fichier) {
		
		String chaine="";
		try{
			
			String chemin =GraphiqueUnitTest.class.getResource(fichier).getPath();
			InputStream ips=new FileInputStream(chemin); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){						
				chaine+=ligne+"\n";
		}
			br.close(); 
		}		

		catch (Exception e){
			System.out.println(e.toString());
		}
					
	return chaine;
	}
	
	
	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter(null);

	}

	// test FD
	@Test
	public void test() {
		try {
			interpreter.execute(fileReader("unitTest1.logo"));
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
			interpreter.execute(fileReader("unitTest2.logo"));
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
			interpreter.execute(fileReader("unitTest3.logo"));
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
				interpreter.execute(fileReader("unitTest4.logo"));
				assertEquals(0, interpreter.getTurtle().getX(),0.00000001); // valeur d'erreur != 0 car imprécision due au sin / cos
				assertEquals(0, interpreter.getTurtle().getY(),0.00000001);
			} catch (NoSuchPrimitiveException e) {
				fail(e.toString());
			}			
		}

}
