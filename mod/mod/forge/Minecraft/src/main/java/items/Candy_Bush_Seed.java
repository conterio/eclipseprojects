package items;

import com.example.examplemod.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Bush_Seed extends ItemSeedFood implements net.minecraftforge.common.IPlantable {

    private Block crops;
    private Block soilId;
		
	public Candy_Bush_Seed(int amount, float saturation,Block crops, Block soil) {
		super(amount, saturation,crops,soil);
        this.crops = crops;
        this.soilId = soil;
        this.setUnlocalizedName("candybushseed");
        GameRegistry.registerItem(this, "candybushseed");

	}
	


//	@Override
//	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
//		
//		return net.minecraftforge.common.EnumPlantType.Crop;
//	}
//
//	@Override
//	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
//		// TODO Auto-generated method stub
//		//return (IBlockState) GameRegistry.findBlock(ExampleMod.MODID, "candybush").getBlockState();
//		 return this.crops.getDefaultState();
//		
//	}

}
