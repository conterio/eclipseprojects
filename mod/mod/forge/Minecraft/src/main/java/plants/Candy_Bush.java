package plants;

import generators.Candy_Brick_Gen;
import generators.Candy_Bush_Generator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Bush extends BlockCrops {
	
	
	
	public Candy_Bush(){
		this.setUnlocalizedName("candybush");
		GameRegistry.registerBlock(this, "candybush");


		
		
		GameRegistry.registerWorldGenerator(new Candy_Bush_Generator(), 0);
	}
	

	
	
	@Override
    protected Item getSeed()
    {
        return GameRegistry.findItem("examplemod", "gum");
    }
	@Override
    protected Item getCrop()
    {
        return GameRegistry.findItem("examplemod", "gum");
    }


}
