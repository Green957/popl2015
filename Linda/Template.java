package popl2015.Linda;

import java.util.*;

public class Template implements aTemplate {
	

	private List<TypedValue> elements;
	
	public Template() { 
		elements = new Vector<TypedValue>();
	}
			
	public Template(List<TypedValue> es) { elements = es; }
	
	public boolean matches(aTuple t) {
		
		//if they're of different length they can not match
		if (( t.length() != this.length())){
			return false;
		}
		
		else {

			for(int i = 0 ; i< elements.size();i++){
				if (elements.get(i) instanceof Hole){
					//only compare types for holes
					if (elements.get(i).type() == t.nth(i).type()){
						//pass
					}
					else {
						return false;
					}
					
				}
				
				//regular TypedValues can be compared with equals()
				else {
					return (elements.get(i).equals(t.nth(i)));
				}
				
			}
		}
		
		
		//if the conditionals reach here (have not returned false) then the length matches and all elements match
		return true;
	
	}
	
	public TypedValue nth(int n) {
	if( n < 0 || n >= elements.size()) return null;
	else return elements.get(n);
	}
	
	public aTemplate add(TypedValue v) {elements.add(v); return this;}
	
	public int length() {return elements.size();}
	
	public String toString() { return "<| " + elements + " |>"; }


}
