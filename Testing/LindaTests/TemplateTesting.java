package popl2015.Testing.LindaTests;

import static org.junit.Assert.*;

import org.junit.Test;
import popl2015.Linda.*;
import popl2015.Linda.TypedValue.Type;

public class TemplateTesting {
	
	static Tuple testTuple1 = new Tuple();
	static Template testTemp1 = new Template();
	static TypedValue testInt1 = new TypedValue(Type.Integer,7);
	static TypedValue testInt3 = new TypedValue(Type.Integer,10);
	static TypedValue testStr2 = new TypedValue(Type.String,7);
	static Hole testHole = new Hole(Type.Integer);
	
	
	
	
	public void clear(){
		testTuple1 = new Tuple();
		testTemp1 = new Template();
	}
	
	@Test
	public void testMatchesBothEmpty(){
		assertEquals("testTuple1 is equal to testTemp1",true,testTemp1.matches(testTuple1));
	}
	
	
	@Test
	public void testMatchesDiffLength(){
		testTuple1.add(testInt1);
		testTuple1.add(testStr2);
		testTemp1.add(testInt3);
		assertEquals(testTuple1.toString() + "should not match" + testTemp1.toString(),false,testTemp1.matches(testTuple1));
		clear();
	}
	
	
	@Test
	public void testMatchesSameValues(){
		testTuple1.add(testInt1);
		testTemp1.add(testInt1);
		testTuple1.add(testStr2);
		testTemp1.add(testStr2);
		assertEquals("testTuple1 is equal to testTemp1",true,testTemp1.matches(testTuple1));
		clear();
	}
	
	@Test
	public void testMatchesDiffValues(){
		testTuple1.add(testInt1);
		testTuple1.add(testStr2);
		testTemp1.add(testInt3);
		testTemp1.add(testStr2);
		assertEquals(testTuple1.toString() + "should not match" + testTemp1.toString(),false,testTemp1.matches(testTuple1));
		clear();
	}
	
	@Test
	public void testMatchesWithHoles(){
		testTuple1.add(testInt1);
		testTuple1.add(testStr2);
		testTemp1.add(testHole);
		testTemp1.add(testStr2);
		assertEquals("testTuple1 is equal to testTemp1",true,testTemp1.matches(testTuple1));
		clear();
	}
	
	
	
}
