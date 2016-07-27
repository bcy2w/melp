package bcy.melp.worlds;

import java.io.InputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

import bcy.melp.World;


abstract public class DefaultWorldFactory {

    static private final String PROPERTIES_FILE = "worlds.properties";

    private Properties props;

    public DefaultWorldFactory() throws IOException{
        props = new Properties();
        InputStream in = null;
        try {
            in = getClass().getResourceAsStream( PROPERTIES_FILE );
            props.load( in );
        } finally {
            if ( in != null ) {
                in.close();
            }
        }
    }

    public List<String> getWorldIds() {
        return props.keySet().stream()
            .map( name -> (String)name )
            .collect( Collectors.toList() );
    }

    public World createWorld( String id ) {
        return null;
    }

}
