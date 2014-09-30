package de.knoxz.customoregen.utility;

/**
 * Created by Dome on 30.09.2014.
 */
public class Replacer {
    public String name;
    public int dimension;
    public String oreid;
    public String replaceid;

    public Replacer(){

    }

    public Replacer(String name, int dimension, String replaceid, String oreid) {
        this.name = name;
        this.dimension = dimension;
        this.replaceid = replaceid;
        this.oreid = oreid;
    }
}
