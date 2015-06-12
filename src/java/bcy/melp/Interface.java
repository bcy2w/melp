package bcy.melp;

import java.util.*;

public class Interface {
    static public class ReadOnlyVariable {
        protected String name;
        protected String description;
        protected Object value;

        public String getName() { return name; }
        public String getDescription() { return description; }
        public Object getValue() { return value; }
    }

    static public class ReadWriteVariable extends ReadOnlyVariable {
        public Object setValue( Object v ) {
            Object oldValue = value;
            value = v;
            return oldValue;
        }
    }

    protected Map<String,ReadWriteVariable> inVariables;
    protected Map<String,ReadOnlyVariable> outVariables;

    public Set<String> getInVariableNames() {
        return inVariables == null ?
            Collections.emptySet() : inVariables.keySet();
    }
    public Set<String> getOutVariableNames() {
        return outVariables == null ?
            Collections.emptySet() : outVariables.keySet();
    }

    public Object get( String name ) {
        if ( outVariables == null ) {
            return null;
        }
        ReadOnlyVariable o = outVariables.get( name );
        return o == null ? null : o.getValue();
    }
        
    public void set( String name, Object value ) {
        if ( inVariables != null && inVariables.containsKey( name ) ) {
            inVariables.get( name ).setValue( value );
        }
    }
}
