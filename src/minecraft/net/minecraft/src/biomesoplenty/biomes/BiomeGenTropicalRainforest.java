package net.minecraft.src.biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenRainforest1;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenRainforest2;

public class BiomeGenTropicalRainforest extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenTropicalRainforest(int par1)
	{
		super(par1);
		spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 12;
		customBiomeDecorator.grassPerChunk = 7;
		//customBiomeDecorator.highGrassPerChunk = 4;
		customBiomeDecorator.reedsPerChunk = 10;
		//customBiomeDecorator.waterlilyPerChunk = 2;
		//customBiomeDecorator.orangeFlowersPerChunk = 10;
		customBiomeDecorator.generatePumpkins = false;
		customBiomeDecorator.generateMelons = true;
		//customBiomeDecorator.sproutsPerChunk = 2;
		//customBiomeDecorator.generateQuicksand = true;
		//customBiomeDecorator.poisonIvyPerChunk = 4;
		//customBiomeDecorator.lilyflowersPerChunk = 2;
		waterColorMultiplier = 6160128;
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 12 + par2Random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int var7 = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int var10 = par1World.getBlockId(var7, var8, var9);
		}
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return par1Random.nextInt(5) == 0 ? new WorldGenRainforest2() : new WorldGenRainforest1(false);
	}

	/**
	 * Provides the basic grass color based on the biome temperature and rainfall
	 */
	 @Override
	 public int getBiomeGrassColor()
	 {
		 return 11002176;
	 }

	 /**
	  * Provides the basic foliage color based on the biome temperature and rainfall
	  */
	 @Override
	 public int getBiomeFoliageColor()
	 {
		 return 8970560;
	 }

	 /**
	  * takes temperature, returns color
	  */
	 @Override
	 public int getSkyColorByTemp(float par1)
	 {
		 //if (BOPConfiguration.skyColors)
			 return 12971089;
		 /*else
		 {
			 par1 /= 3.0F;

			 if (par1 < -1.0F)
			 {
				 par1 = -1.0F;
			 }

			 if (par1 > 1.0F)
			 {
				 par1 = 1.0F;
			 }

			 return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
		 }*/
	 }
}
