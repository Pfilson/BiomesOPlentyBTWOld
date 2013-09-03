package net.minecraft.src.biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityBat;
import net.minecraft.src.EntityCaveSpider;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenOminous1;
import net.minecraft.src.biomesoplenty.worldgen.WorldGenOminous2;

public class BiomeGenOminousWoods extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenOminousWoods(int par1)
	{
		super(par1);
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 10;
		customBiomeDecorator.grassPerChunk = 1;
		customBiomeDecorator.flowersPerChunk = -999;
		//customBiomeDecorator.deathbloomsPerChunk = 1;
		customBiomeDecorator.mushroomsPerChunk = 8;
		customBiomeDecorator.reedsPerChunk = -999;
		customBiomeDecorator.sandPerChunk = -999;
		customBiomeDecorator.sandPerChunk2 = -999;
		//customBiomeDecorator.thornsPerChunk = 9;
		//customBiomeDecorator.poisonIvyPerChunk = 3;
		//customBiomeDecorator.poisonWaterPerChunk = 15;
		waterColorMultiplier = 1973030;
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 5, 1, 2));
		spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 7, 1, 2));
		spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 9, 1, 2));
		spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
		spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		//return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenWillow2() : (par1Random.nextInt(7) == 0 ? new WorldGenDarkTree1() : (par1Random.nextInt(5) == 0 ? new WorldGenWillow1() : new WorldGenDarkTree2())));
		return par1Random.nextInt(2) == 0 ? new WorldGenOminous1(false) : new WorldGenOminous2();
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
		return par1Random.nextInt(6) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 0) : new WorldGenTallGrass(Block.tallGrass.blockID, 1);
	}
}
