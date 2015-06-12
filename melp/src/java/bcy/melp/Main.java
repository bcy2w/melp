package bcy.melp;

// import java.lang.reflect.*;
import java.util.*;
import java.io.File;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyCodeSource;

import bcy.melp.worlds.SimpleWorld;

public class Main {

    static public void main( String[] args ) throws Exception {
        Main main = new Main();
        main.run();
    }

    private Main() {
    }

    private void run() throws Exception {

        // Create World
        World world = new SimpleWorld();

        // Create Controller
        GroovyClassLoader gcl = new GroovyClassLoader();

        GroovyCodeSource testCodeSource = new GroovyCodeSource(
            getClass().getResource( "/Test.groovy" ) );
        Class testClass = gcl.parseClass( testCodeSource );

        GroovyObject test = (GroovyObject) testClass.newInstance();
        test.setProperty( "world", world.getInterface( null ) );

        while ( !world.finished() ) {
            test.invokeMethod( "takeTurn", null );
            world.takeTurn();
            try {
                Thread.sleep( 500 );
            } catch ( Exception e ) {
                break;
            }
        }
        world.summary();

    }

}
