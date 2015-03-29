package blocks;


import generators.Redhot_Gen;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Red_Hot extends BlockCactus {

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
	
}
