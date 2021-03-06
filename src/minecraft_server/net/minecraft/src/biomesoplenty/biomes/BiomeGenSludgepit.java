package net.minecraft.src.biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenBog1;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenBog2;

public class BiomeGenSludgepit extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenSludgepit(int par1)
	{
		super(par1);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 30;
		customBiomeDecorator.grassPerChunk = 30;
		customBiomeDecorator.flowersPerChunk = -999;
		customBiomeDecorator.sandPerChunk = -999;
		customBiomeDecorator.sandPerChunk2 = -999;
		//customBiomeDecorator.mudPerChunk = 5;
		//customBiomeDecorator.mudPerChunk2 = 5;
		customBiomeDecorator.deadBushPerChunk = 5;
		//customBiomeDecorator.algaePerChunk = 2;
		//customBiomeDecorator.poisonWaterPerChunk = 5;
		spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
		waterColorMultiplier = 11506176;
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
		return par1Random.nextInt(3) == 0 ? new WorldGenBog2() : new WorldGenBog1();
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
		return par1Random.nextInt(9) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 0) : new WorldGenTallGrass(Block.tallGrass.blockID, 1);
	}
}
