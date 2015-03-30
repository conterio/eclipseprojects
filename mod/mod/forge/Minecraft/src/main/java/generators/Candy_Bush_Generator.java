package generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class Candy_Bush_Generator implements IWorldGenerator {
	
	BlockPos position, bottom;

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

			for(int i=0;i<1;i++){
			    int x = chunkX * 16 + random.nextInt(16);
			    int y = 15 + random.nextInt(145);
			    int z = chunkZ * 16 + random.nextInt(16);

			   
			    
			    position = world.getTopSolidOrLiquidBlock(new BlockPos(x,y,z));
			    bottom = position.add(0, -1, 0);

			    if(world.getBlockState(position) == Blocks.air.getDefaultState() &&  world.getBlockState(bottom) == Blocks.grass.getDefaultState() ){
			    	
			    	world.setBlockState(bottom, (IBlockState) Blocks.farmland.getDefaultState());
			    	world.setBlockState(position, (IBlockState) Block.getBlockFromName("examplemod:candybush").getStateFromMeta(3));
			    	
			    }

		}
	}

}
