package UnitTest.Arithmetique;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import primitive.NoSuchPrimitiveException;

import android.content.Context;

import com.example.parser.Interpreter;

public class ArithmetiqueUnitTest {

	Interpreter interpreter;
	public ArithmetiqueUnitTest() {
	}
	
	private String fileReader(String fichier) {
		
				String chaine="";
				try{
					
					String chemin =ArithmetiqueUnitTest.class.getResource(fichier).getPath();
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

	@SuppressWarnings("deprecation")
	
	// test chiffre simple
	@Test
	public void test() {
		try {
			
			interpreter.execute(fileReader("unitTest1.logo"));			
			assertEquals(5, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test addition
	@Test
	public void test2() {
		try {
			interpreter.execute(fileReader("unitTest2.logo"));			
			assertEquals(7, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}

	// test soustraction
	@Test
	public void test3() {
		try {
			interpreter.execute(fileReader("unitTest3.logo"));			
			assertEquals(40, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test multiplication
	@Test
	public void test4() {
		try {
			interpreter.execute(fileReader("unitTest4.logo"));			
			assertEquals(15, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test division (résultat entier)
	@Test
	public void test5() {
		try {
			interpreter.execute(fileReader("unitTest5.logo"));			
			assertEquals(4, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test division (résultat a virgule)
	@Test
	public void test6() {
		try {
			interpreter.execute(fileReader("unitTest6.logo"));			
			assertEquals(1.5, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
}
