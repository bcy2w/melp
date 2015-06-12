package bcy.melp.worlds;

import java.util.*;

import bcy.melp.Interface;
import bcy.melp.InterfaceImpl;
import bcy.melp.World;

public class SimpleWorld extends World {

    private int turnsLeft = 1;

    private boolean success = false;

    private Map<String,Interface.ReadWriteVariable> inVariables;
    private Map<String,Interface.ReadOnlyVariable> outVariables;

    private InterfaceImpl theInterface;

    public SimpleWorld() {
        inVariables = new HashMap<String,Interface.ReadWriteVariable>();
        addRWVariable( inVariables, "message", "Message to print", null );

        outVariables = new HashMap<String,Interface.ReadOnlyVariable>();
        addROVariable( outVariables, "introduction", "World Introduction",
            "Please set message to 'Hello World!'" );

        theInterface = new InterfaceImpl();
        theInterface.setInVariables(
            (Map<String,Interface.ReadWriteVariable>)inVariables );
        theInterface.setOutVariables(
            (Map<String,Interface.ReadOnlyVariable>)outVariables );
    }

    public InterfaceImpl getInterface( String connectionId ) {
        return theInterface;
    }

    public boolean finished() {
        return turnsLeft < 1 || success;
    }

    public String summary() {
        if ( success ) {
            System.out.println( "You win!!!" );
            return "SUCCESS";
        }
        System.out.println( "Sorry, keep trying." );
        return "FAIL";
    }

    public void takeTurn() {
        Object message = theInterface.getInput( "message" );
        if ( message == null ) {
            System.out.println( "Got no Message..." );
        } else {
            System.out.println( "Got Message: " + message );
            if ( "Hello World!".equals( message ) ) {
                success = true;
            }
        }
        turnsLeft--;
    }

}
