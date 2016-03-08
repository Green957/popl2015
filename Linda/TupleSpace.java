package popl2015.Linda;

import java.util.*;

public class TupleSpace implements aTupleSpace{

	private Collection<aTuple> theSpace;

	public TupleSpace() { 
		theSpace = new Vector<aTuple>();
	}


	@Override
	public synchronized void out(aTuple v) {
		//add tuple from the calling process to the TupleSpace
		theSpace.add(v);
		notifyAll();

	}


	@Override
	public synchronized void in(aTemplate t, aMonoVariable<aTuple> result) {
		while(true){
			//remove specific tuple from the TupleSpace and output it to the process
			Iterator<aTuple> iterator = theSpace.iterator();
			while(iterator.hasNext()){
				aTuple next = iterator.next();
				if(t.matches(next)){
					result.becomes(next);
					theSpace.remove(next);
					return;

				}
			}

			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}



	@Override
	public synchronized void rd(aTemplate t, aMonoVariable<aTuple> result) {
		while(true){
			//output tuple to the calling process DOES NOT REMOVE from TupleSpace
			Iterator<aTuple> iterator = theSpace.iterator();
			while(iterator.hasNext()){
				aTuple next = iterator.next();
				if(t.matches(next)){
					result.becomes(next);
					//no need to notify as the TupleSpace is not affected and becomes will notify threads waiting on the monoVar monitor
					return;
				}
			}

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//try again when the thread is unblocked
	
		}
	}





	public String toString() { return "# " + theSpace + " #"; }


}
