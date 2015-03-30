package blocks;


import java.util.Random;

import generators.Redhot_Gen;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Red_Hot extends BlockCactus {

	Random random = new Random();
	
	public Red_Hot(){
		this.setUnlocalizedName("redhot");
		this.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, "redhot");
		
		GameRegistry.registerWorldGenerator(new Redhot_Gen(), 0);
	}
	
	//this makes it so it can stack
	@Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
        IBlockState state = world.getBlockState(pos);
        IBlockState plant = plantable.getPlant(world, pos.up());
        net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.up());

        return true;
    }
	
	//what happens when they harvest block, drops a gummy worm
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		
		int dropProb = random.nextInt();
		if(dropProb<.5){		
			return GameRegistry.findItem("examplemod", "redhotcandy");
		}
		else{
			return null;
		}
    }

	
}
