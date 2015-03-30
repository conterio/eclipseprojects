package items;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cocoa_Powder extends Item {

	public Cocoa_Powder() {
	
		GameRegistry.registerItem(this,"cocoapowder");
		this.setUnlocalizedName("cocoapowder");      
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	

}
