package blocks;


import generators.Candy_Brick_Gen;
import items.Gummy_Worm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Brick extends BlockCompressed {


	
	public Candy_Brick(MapColor mc) {
		super(mc);
				
		
		this.setUnlocalizedName("candybrick");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypeGravel);
		GameRegistry.registerBlock(this, "candybrick");

		GameRegistry.registerWorldGenerator(new Candy_Brick_Gen(this), 0);

	}
	
	

}
