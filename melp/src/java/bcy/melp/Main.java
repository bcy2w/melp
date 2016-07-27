package bcy.melp;

// import java.lang.reflect.*;
import java.util.*;
import java.io.File;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyCodeSource;

import bcy.melp.worlds.SimpleWorld;
import bcy.melp.worlds.World;

public class Main {

    private GroovyClassLoader gcl = new GroovyClassLoader();

    static public void main( String[] args ) throws Exception {
        Main main = new Main();
        main.run();
    }

    private Main() {
    }

    private void run() throws Exception {

        // Create World
        World world = new SimpleWorld();


        GroovyObject player = createPlayerObject( "/Test.groovy" );

        player.setProperty( "world", world.getInterface( null ) );

        while ( !world.finished() ) {
            player.invokeMethod( "takeTurn", null );
            world.takeTurn();
            try {
                Thread.sleep( 500 );
            } catch ( Exception e ) {
                break;
            }
        }
        world.summary();

    }

    private GroovyObject createPlayerObject( String file )
            throws InstantiationException, IllegalAccessException {
        GroovyCodeSource codeSource = new GroovyCodeSource( getClass().getResource( file ) );
        Class clazz = gcl.parseClass( codeSource );

        GroovyObject obj = (GroovyObject) clazz.newInstance();
        return obj;
    }

}
