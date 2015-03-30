package blocks;


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


//class Gummy_Dirt
public class Gummy_Dirt extends BlockOre {

	Random random = new Random();
	//constructor
	public Gummy_Dirt() {
		
		GameRegistry.registerBlock(this, "gummydirt");
		this.setUnlocalizedName("gummydirt");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeGravel);
	}
	public Gummy_Dirt(String name) {
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeGravel);
	}
	
	//what happens when they harvest block, drops a gummy worm
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		
		int dropProb = random.nextInt();
		if(dropProb<.5){		
			return GameRegistry.findItem("examplemod", "gummyworm");
		}
		else{
			return null;
		}
    }



}
