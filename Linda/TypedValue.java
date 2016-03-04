package popl2015.Linda;

public class TypedValue {
	
	public static enum Type { Integer, Float, String, Bool, Null };
	private Object value;
	protected Type type;
	
	public TypedValue() { type = Type.Null; value = null;}
	
	public TypedValue(Type t, Object v ) { type = t; value = v; }
	
	public Object value() { return value; }
	
	public Type type() { return type;}
	
	public boolean equals(Object o) { //Standard Oject.equals() semantics
	if( !(o instanceof TypedValue)){
		// o can't equal an instance of TypedValue if it isn't an instance of TypedValue itself
		return false;
	}
	else{
		// if the code reaches this stage o is of type TypedValue so its safe to cast it as such
		if (this.type() == ((TypedValue) o).type()){
			//they are of the same type
			if (this.value() == ((TypedValue) o).value()){
				//they are also the same value
				return true;
			}
			else {
				//the values don't match
				return false;
			}
		}
		else {
			//the types don't match
			return false;
		}
	}
	}
	
	public String toString() { return value + ":" + type ; }

}
