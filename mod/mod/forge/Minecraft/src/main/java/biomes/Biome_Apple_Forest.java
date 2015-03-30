package biomes;

import java.util.Random;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;



public class Biome_Apple_Forest extends BiomeGenBase {

	public Biome_Apple_Forest(int p_i1971_1_) {
		super(p_i1971_1_);
		topBlock = (IBlockState)Blocks.glass.getDefaultState();
		fillerBlock = (IBlockState)Blocks.diamond_block.getDefaultState();
		
		this.theBiomeDecorator.treesPerChunk = 40;
		this.minHeight = height_Default.rootHeight;
        this.maxHeight = height_Default.variation;
        this.temperature = 0.7F;
        this.rainfall = 0.8F;
		
	}
	
	
    public WorldGenAbstractTree genBigTreeChance(Random p_150567_1_)
    {
        return (WorldGenAbstractTree)(p_150567_1_.nextInt(10) == 0 ? this.worldGeneratorBigTree : (p_150567_1_.nextInt(2) == 0 ? new WorldGenShrub(BlockPlanks.EnumType.JUNGLE.getMetadata(), BlockPlanks.EnumType.OAK.getMetadata()) : (!false && p_150567_1_.nextInt(3) == 0 ? new WorldGenMegaJungle(false, 10, 20, BlockPlanks.EnumType.JUNGLE.getMetadata(), BlockPlanks.EnumType.JUNGLE.getMetadata()) : new WorldGenTrees(false, 4 + p_150567_1_.nextInt(7), BlockPlanks.EnumType.JUNGLE.getMetadata(), BlockPlanks.EnumType.JUNGLE.getMetadata(), true))));
    }


	
}
