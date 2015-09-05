package de.knoxz.oregenanything;

import cpw.mods.fml.common.IWorldGenerator;
import de.knoxz.oregenanything.configuration.ConfigurationHandler;
import de.knoxz.oregenanything.utility.Replacer;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreGenAnythingGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        for (Replacer repl : ConfigurationHandler.repl) {
            if (world.provider.dimensionId == repl.dimension)
            generateOres(repl, random, chunkX * 16, chunkZ * 16, world);
        }


    }

    private void generateOres(Replacer replacer, Random random, int x, int z, World world) {
        addOreSpawn(Block.getBlockFromName(replacer.oreid), Block.getBlockFromName(replacer.replaceid), world, random, x, z, replacer.minVeinSize, replacer.maxVeinSize, replacer.chanceToSpawn, replacer.minY, replacer.maxY, replacer.meta);
    }

    /**
     * This method adds our block to the world.
     * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
     * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
     *
     * @param block          The block you want to spawn
     * @param remove         Block that will be removed
     * @param world          The world
     * @param random         The Random
     * @param blockXPos      the blockXpos of a chunk
     * @param blockZPos      the blockZpos of a chunk
     * @param minVeinSize    min vein
     * @param maxVeinSize    max vein
     * @param chancesToSpawn the chance to spawn. Usually around 2
     * @param minY           lowest point to spawn
     * @param maxY           highest point to spawn
     */

    public void addOreSpawn(Block block, Block remove, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY, int meta) {
        WorldGenMinable minable;
        if(meta > 0){
            minable = new WorldGenMinable(block, meta, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), remove);
        } else {
            minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), remove);
        }
        for (int i = 0; i < chancesToSpawn; i++) {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
}
