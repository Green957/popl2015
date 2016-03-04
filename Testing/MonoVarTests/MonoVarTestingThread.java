package popl2015.Testing.MonoVarTests;

import popl2015.Linda.*;

/**
 * Thread for testing MonoVariables
 * Can be instantiated to test with any Type T
 */
public class MonoVarTestingThread<T> implements Runnable{

		private int id;
		private MonoVariable<T> var;
		private T ThreadTestValue;
		
		public MonoVarTestingThread(int id,MonoVariable<T> var,T ThreadTestValue){
			this.id = id;
			this.var = var;
			this.ThreadTestValue = ThreadTestValue;
		}
		
		@Override
		public void run() {
			
			// 1 and 2 are used for JUnit testing
			if (id == 1){
				var.consume();
			}
			if (id == 2){
				var.becomes(ThreadTestValue);
			}
			
		}

}
