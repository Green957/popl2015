package popl2015.Testing.MonoVarTests;

import static org.junit.Assert.*;

import org.junit.Test;

import popl2015.Linda.MonoVariable;



public class MonoVarTesting {

	/*
	 * Testing can be done with any Type T. However, the type 
	 * used to instantiate testClass must match the type of:
	 * 	 testVal 
	 * 	 threadTestVal
	 * 	 t1
	 * 	 t2
	 */
	
	
	MonoVariable<Integer> testClass = new MonoVariable<Integer>();
	int testVal = 5;
	int threadTestVal = 7;
	
	//These threads are required as the tests will block and need another thread to notify them
	//t1 calls consume once
	Thread t1 = new Thread(new MonoVarTestingThread<Integer>(1, testClass,threadTestVal));
	//t2 calls becomes(threadTestVal) once
	Thread t2 = new Thread(new MonoVarTestingThread<Integer>(2, testClass,threadTestVal));
	

	@Test
	public void initialisationTest(){
		assertEquals("Value should be initialised as null",null,testClass.getValue());
	}
	
	@Test
	public void becomesOnNullValTest(){
		testClass.becomes(testVal);
		assertEquals("Value should become " + testVal,(Integer)testVal,testClass.getValue());
	}
	
	@Test
	public void becomesOnNotNullValTest(){
		t2.start();
		//this tries to become testVal but is forced to wait until t1 executes
		testClass.becomes(testVal);
		t1.start();
		assertEquals("becomes should wait until t1 consumes",(Integer)testVal,testClass.getValue());
	}
	
	@Test
	public void consumeOnNullTest(){
		//t1 tries to consume but forced to wait until t2 executes
		t1.start();
		t2.start();
		assertEquals("consume should wait until the value becomes not Null",null,testClass.getValue());
	}
	
	@Test
	public void consumeOnNotNullTest(){
		testClass.becomes(testVal);
		testClass.consume();
		assertEquals("Value should be initialised as null",null,testClass.getValue());
	}
	

	
}
