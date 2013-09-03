package net.minecraft.src.biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntityWitch;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenSwampTall;

public class BiomeGenLushSwamp extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenLushSwamp(int par1)
	{
		super(par1);
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 10;
		customBiomeDecorator.grassPerChunk = 4;
		customBiomeDecorator.mushroomsPerChunk = 8;
		customBiomeDecorator.reedsPerChunk = 16;
		//customBiomeDecorator.cattailsPerChunk = 10;
		//customBiomeDecorator.highCattailsPerChunk = 5;
		//customBiomeDecorator.waterlilyPerChunk = 3;
		//customBiomeDecorator.hydrangeasPerChunk = 1;
		//customBiomeDecorator.reedsBOPPerChunk = 5;
		//customBiomeDecorator.poisonWaterPerChunk = 2;
		//customBiomeDecorator.carrotsPerChunk = 1;
		spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 2, 1, 2));
		spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 1, 1, 1));

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
		return new WorldGenSwampTall();
	}
}
