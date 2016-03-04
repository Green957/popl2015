package popl2015.Linda;

public class MonoVariable<T> implements aMonoVariable<T>{

	private T value = null; 
	
	@Override
	public synchronized void becomes(T val) {
		System.out.println("Attempting to become " + val);
		if (value == null){
			value = val;
			System.out.println("Value became " + value);
			notifyAll();
		}
		else {
			try {
				System.out.println("become " + val + " waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//try becoming again when the thread is unblocked
			becomes(val);
		}
		
	}

	@Override
	public synchronized T consume() {
		System.out.println("Attempting to consume");
		
		//we need to clear value but also return it so we store its value here
		T tempVal;
		if (value != null){
			tempVal = value;
			value = null;
			System.out.println("Value consumed");
			notifyAll();
			return tempVal;
		}
		else {
			try {
				System.out.println("consume waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//try consuming again when the thread is unblocked
			consume();
			
			
		}
		
		//function has a return type so this must be included even though it is never reached
		return null;
		
		
	}
	
	//for testing purposes
	public T getValue(){
		return value;
	}

}
