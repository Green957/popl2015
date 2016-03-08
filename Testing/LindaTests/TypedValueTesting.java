package popl2015.Testing.LindaTests;

import static org.junit.Assert.*;

import org.junit.Test;
import popl2015.Linda.TypedValue;
import popl2015.Linda.TypedValue.Type;

public class TypedValueTesting {

	static TypedValue testInt1 = new TypedValue(Type.Integer,7);
	static TypedValue testInt2 = new TypedValue(Type.Integer,7);
	static TypedValue testInt3 = new TypedValue(Type.Integer,10);
	static TypedValue testStr1 = new TypedValue(Type.String,"test");
	static TypedValue testStr2 = new TypedValue(Type.String,7);
	
	@Test
	public void testEqualitySameTypeSameValue(){
		assertEquals("testInt1 and testInt2 are equal",true,testInt1.equals(testInt2));
	}
	
	@Test
	public void testEqualitySameTypeDiffValue(){
		assertEquals("testInt1 and testInt3 are not be equal",false,testInt1.equals(testInt3));
	}
	
	@Test
	public void testEqualityDiffTypeDiffValue(){
		assertEquals("testInt1 and testStr1 are not equal",false,testInt1.equals(testStr1));
	}
	
	@Test
	public void testEqualityDiffTypeSameValue(){
		assertEquals("testInt1 and testStr2 are not equal",false,testInt1.equals(testStr2));
	}
	
	@Test
	public void testEqualityNonTypedValue(){
		assertEquals("10 is not a TypedValue",false,testInt1.equals(10));
	}
}
