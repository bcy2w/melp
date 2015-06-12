package bcy.melp;

import java.util.Map;

abstract public class World {

    abstract public Interface getInterface( String connectionId );

    abstract public void takeTurn();

    abstract public boolean finished();

    abstract public String summary();

    static protected void addRWVariable(
            Map<String,Interface.ReadWriteVariable> map,
            String name, String description, Object value ) {
        InterfaceImpl.Variable var =
            new InterfaceImpl.Variable( name, description );
        if ( value != null ) {
            var.setValue( value );
        }
        map.put( name, var );
    }
    static protected void addROVariable(
            Map<String,Interface.ReadOnlyVariable> map,
            String name, String description, Object value ) {
        InterfaceImpl.Variable var =
            new InterfaceImpl.Variable( name, description );
        if ( value != null ) {
            var.setValue( value );
        }
        map.put( name, var );
    }

}
