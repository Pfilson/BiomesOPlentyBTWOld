package net.minecraft.src.biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenShrub;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenAutumn;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenRainforestTree1;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenTaiga10;

public class BiomeGenBorealForest extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenBorealForest(int par1)
	{
		super(par1);
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 20;
		customBiomeDecorator.grassPerChunk = 50;
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
		return par1Random.nextInt(2) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 2) : new WorldGenTallGrass(Block.tallGrass.blockID, 1);
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return par1Random.nextInt(4) == 0 ? new WorldGenRainforestTree1(false) : (par1Random.nextInt(5) == 0 ? new WorldGenShrub(0,0) : (par1Random.nextInt(3) == 0 ? new WorldGenAutumn(false) : (par1Random.nextInt(3) == 0 ? worldGeneratorForest : new WorldGenTaiga10(false))));
		//return (WorldGenerator)(par1Random.nextInt(2) == 0 ? this.worldGeneratorTrees : (par1Random.nextInt(5) == 0 ? new WorldGenShrub(0,0) : (par1Random.nextInt(3) == 0 ? new WorldGenAutumn(false) : (par1Random.nextInt(3) == 0 ? this.worldGeneratorForest : new WorldGenTaiga10(false)))));
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 3 + par2Random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int var7 = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int var10 = par1World.getBlockId(var7, var8, var9);

			if (var10 == Block.stone.blockID)
			{
				par1World.setBlock(var7, var8, var9, Block.oreEmerald.blockID, 0, 2);
			}
		}
	}

	/**
	 * Provides the basic grass color based on the biome temperature and rainfall
	 */
	@Override
	public int getBiomeGrassColor()
	{
		return 10467185;
	}

	/**
	 * Provides the basic foliage color based on the biome temperature and rainfall
	 */
	@Override
	public int getBiomeFoliageColor()
	{
		return 13225573;
	}
}
