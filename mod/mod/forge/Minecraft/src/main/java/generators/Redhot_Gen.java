package generators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class Redhot_Gen implements IWorldGenerator {

	BlockPos position, bottom,top;
	Random moreBlocks = new Random();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		//the number 1 (i<1) is how many redhot blocks you can have in each chunk.  if you want more then change that number to a higher number
		// we can also make a random number to place there.
		for(int i=0;i<1;i++){
		    int x = chunkX * 16 + random.nextInt(16);
		    int y = 15 + random.nextInt(145);
		    int z = chunkZ * 16 + random.nextInt(16);

		   
		    //the position block is a random block in a chunk on the top layer and the bottom is one below the position block
		    position = world.getTopSolidOrLiquidBlock(new BlockPos(x,y,z));
		    bottom = position.add(0, -1, 0);
		   

		    //check if the position block is in the air and if the bottom one is sand, if so place a redhot block
		    if(world.getBlockState(position) == Blocks.air.getDefaultState() &&  (world.getBlockState(bottom) == Blocks.sand.getDefaultState() || world.getBlockState(bottom) == Blocks.red_sandstone.getDefaultState() )){
		    	
		    	world.setBlockState(position, (IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());
		    	
		    	int mutlipleBlocks =  moreBlocks.nextInt(10);
		    	if(mutlipleBlocks > 9){
		    		
		    		world.setBlockState(position.add(0,1,0),(IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());
		    		world.setBlockState(position.add(0,2,0),(IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());
		    		world.setBlockState(position.add(0,3,0),(IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());
		    	}
		    	else if(mutlipleBlocks > 7){
		    		world.setBlockState(position.add(0,1,0),(IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());
		    		world.setBlockState(position.add(0,2,0),(IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());

		    	}
		    	else if(mutlipleBlocks > 5){
		    		world.setBlockState(position.add(0,1,0),(IBlockState) Block.getBlockFromName("examplemod:redhot").getDefaultState());
		    		
		    	}
		    	else{
		    		
		    	}
		    }
		}

		
	}

}
