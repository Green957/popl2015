package popl2015.Testing.LindaTests;

import popl2015.Linda.*;


/**
 * Thread for testing Linda and TupleSpaces
 */
public class LindaThread implements Runnable{

	static int id;
	static TupleSpace ts;
	
	
	public LindaThread(int id,TupleSpace ts){
		this.id = id;
		this.ts = ts;
	}
	
	@Override
	public void run() {
		
		
	}

}
