package popl2015.Testing.MonoVarTests;

import popl2015.Linda.MonoVariable;

public class MonoVarExample {

	static MonoVariable<Integer> testClass = new MonoVariable<Integer>();
	
	
	//this thread will constantly consume
	static Thread t1 = new Thread(new MonoVarTestingThread<Integer>(3, testClass,null));
	
	//this thread will constantly try to become 1
	static Thread t2 = new Thread(new MonoVarTestingThread<Integer>(4, testClass,1));
	
	//this thread will constantly try to become 2
	static Thread t3 = new Thread(new MonoVarTestingThread<Integer>(4, testClass,2));
	
	//this thread will constantly try to become 3
	static Thread t4 = new Thread(new MonoVarTestingThread<Integer>(4, testClass,3));

	public static void main(String[] args){
		t2.start();
		t3.start();
		t4.start();
		t1.start();
		
	}
	
	
}
