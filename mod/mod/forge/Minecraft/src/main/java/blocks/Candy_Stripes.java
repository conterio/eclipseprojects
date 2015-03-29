package blocks;


import generators.Candy_Stripes_Gen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Stripes extends Block {

	public Candy_Stripes(Material materialIn) {
		super(materialIn);
    	this.setUnlocalizedName("cb");
    	this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setStepSound(Block.soundTypeSand);
    	GameRegistry.registerBlock(this, "cb");
    	
    	GameRegistry.registerWorldGenerator(new Candy_Stripes_Gen(this), 0);
	}

}
