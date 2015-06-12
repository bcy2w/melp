package bcy.melp;

import java.util.*;

public class InterfaceImpl extends Interface {
    static public class Variable extends ReadWriteVariable {
        public Variable( String name, String description ) {
            setName( name );
            setDescription( description );
        }

        public void setName( String v ) { name = v; }
        public void setDescription( String v) { description = v; }

    }

    public void setInVariables( Map<String,ReadWriteVariable> v ) {
        inVariables = v;
    }
    public Map<String,ReadWriteVariable> getInVariables() {
        return inVariables;
    }
    public void setOutVariables( Map<String,ReadOnlyVariable> v ) {
        outVariables = v;
    }
    public Map<String,ReadOnlyVariable> getOutVariables() {
        return outVariables;
    }

    public Object getInput( String name ) {
        if ( inVariables == null ) {
            return null;
        }
        ReadWriteVariable o = inVariables.get( name );
        return o == null ? null : o.getValue();
    }
}
