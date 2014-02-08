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

import Openfile.Openfile;
import android.content.Context;

import com.example.parser.Interpreter;

public class ArithmetiqueUnitTest extends Openfile {

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
			
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest1.logo").getPath()));			
			assertEquals(5, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test addition
	@Test
	public void test2() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest2.logo").getPath()));			
			assertEquals(7, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}

	// test soustraction
	@Test
	public void test3() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest3.logo").getPath()));			
			assertEquals(40, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test multiplication
	@Test
	public void test4() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest4.logo").getPath()));			
			assertEquals(15, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test division (résultat entier)
	@Test
	public void test5() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest5.logo").getPath()));			
			assertEquals(4, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	// test division (résultat a virgule)
	@Test
	public void test6() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest6.logo").getPath()));			
			assertEquals(1.5, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	@Test
	public void test7() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest7.logo").getPath()));			
			assertEquals(18, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	@Test
	public void test8() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest8.logo").getPath()));			
			assertEquals(7, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	@Test
	public void test9() {
		try {
			interpreter.execute(fileReader(ArithmetiqueUnitTest.class.getResource("unitTest9.logo").getPath()));			
			assertEquals(30, interpreter.returnValue,0);
			
		} catch (NoSuchPrimitiveException e){
			fail(e.toString());
		}			
	}
	
	
}
