package bcy.melp.worlds;

import java.util.Map;

import bcy.melp.Interface;
import bcy.melp.InterfaceImpl;

abstract public class World {

    static interface MetaInfo {
        public String getName();
    }

    abstract public Interface getInterface( String connectionId );

    abstract public void takeTurn();

    abstract public boolean finished();

    abstract public String summary();

    static protected void addRWVariableToMap(
            Map<String,Interface.ReadWriteVariable> map,
            String name, String description, Object value ) {

        InterfaceImpl.Variable var = new InterfaceImpl.Variable( name, description );

        if ( value != null ) {
            var.setValue( value );
        }
        map.put( name, var );
    }

    static protected void addROVariableToMap(
            Map<String,Interface.ReadOnlyVariable> map,
            String name, String description, Object value ) {

        InterfaceImpl.Variable var = new InterfaceImpl.Variable( name, description );

        if ( value != null ) {
            var.setValue( value );
        }
        map.put( name, var );
    }

}
