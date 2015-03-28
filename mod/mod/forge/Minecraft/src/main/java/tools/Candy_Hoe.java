package tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Hoe extends ItemHoe {
	
	static ToolMaterial candyMaterial = EnumHelper.addToolMaterial("candyMaterial", 3, 1561, 8.0F, 400.0F, 10);

	public Candy_Hoe() {
		super(candyMaterial);

		GameRegistry.registerItem(this,"candyhoe");
		this.setUnlocalizedName("candyhoe");
		this.setCreativeTab(CreativeTabs.tabTools);

	
	}

}
