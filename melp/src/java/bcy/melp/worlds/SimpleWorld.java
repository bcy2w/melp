package bcy.melp.worlds;

import java.util.*;

import bcy.melp.Interface;
import bcy.melp.InterfaceImpl;

public class SimpleWorld extends World {

    static public class MetaInfo implements World.MetaInfo {
        public String getName() {
            return "Hello World";
        }
    }

    private int turnsLeft = 1;

    private boolean success = false;

    private Map<String,Interface.ReadWriteVariable> inVariables;
    private Map<String,Interface.ReadOnlyVariable> outVariables;

    private InterfaceImpl theInterface;

    public SimpleWorld() {
        inVariables = new LinkedHashMap<String,Interface.ReadWriteVariable>();
        addRWVariableToMap( inVariables, "message", "Message to print", null );

        outVariables = new LinkedHashMap<String,Interface.ReadOnlyVariable>();
        addROVariableToMap( outVariables, "introduction", "World Introduction",
            "    Hello, Player, here you will learn about the World Interface."
            + "\n"
            + "\n    You are a player in this World.  Your interface to the World is through the"
            + "\n\"world\" interface.  This interface has a bunch of Input and Output variables"
            + "\nInput variables are things that you can set the value of."
            + "\nOutput variables are things that you can read the values of."
            + "\n"
            + "\n    You can get the names of the Input and Output variables using"
            + "\n"
            + "\n        world.inVariableNames and world.outVariableNames"
            + "\n"
            + "\n    One of the Output variables in this World is \"instructions\""
            + "\nYou can get the value of this variable using"
            + "\n"
            + "\n        world.instructions.value"
            + "\n"
            + "\nTo print the value so you can see it you would use the command:"
            + "\n"
            + "\n       println \"${world.instructions.value}\""
            + "\n"
            + "\n    This world has an Input variable called \"message\""
            + "\nYou can access this value using \"world.message\".  You can set a value"
            + "\nfor Input variables.  For example"
            + "\n"
            + "\n    world.message = \"Good morning!\""
            + "\n" );
        addROVariableToMap( outVariables, "instructions", "Instructions",
            "    See if you can set \"message\" to \"Hello World!\"" );

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
