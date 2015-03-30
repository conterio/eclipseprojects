package generators;

import java.util.Collection;
import java.util.Random;

import blocks.Candy_Brick;

import com.example.examplemod.ExampleMod;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class Candy_Sand_Gen implements IWorldGenerator {

	private Block block;
	
	public Candy_Sand_Gen(Block _block){
		this.block = _block;
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		
		for(int i=0;i<609;i++){
		    int x = chunkX * 16 + random.nextInt(16);
		    int y = 15 + random.nextInt(145);
		    int z = chunkZ * 16 + random.nextInt(16);
		
		

		    WorldGenMinable wgm = new WorldGenMinable(block.getDefaultState(),5);
		    wgm.generate(world, random, new BlockPos(x,y,z));
		}
	}//endgenerate
	
}//end class
