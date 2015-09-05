package de.knoxz.oregenanything.utility;

/**
 * Created by Dome on 30.09.2014.
 */
public class Replacer {
    public String name;
    public int dimension;
    public int chanceToSpawn;
    public String oreid;
    public int meta;
    public String replaceid;
    public int minVeinSize;
    public int maxVeinSize;
    public int minY;
    public int maxY;

    public Replacer() {

    }

    public Replacer(String name, int dimension, int chanceToSpawn, String replaceid, String oreid, int meta,int minVeinSize, int maxVeinSize, int minY, int maxY) {
        this.name = name;
        this.dimension = dimension;
        this.chanceToSpawn = chanceToSpawn;
        this.replaceid = replaceid;
        this.oreid = oreid;
        this.meta = meta;
        this.minVeinSize = minVeinSize;
        this.maxVeinSize = maxVeinSize;
        this.minY = minY;
        this.maxY = maxY;
    }
}
