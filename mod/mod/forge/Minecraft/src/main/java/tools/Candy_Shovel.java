package tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Shovel extends ItemSpade {
	
	static ToolMaterial candyMaterial = EnumHelper.addToolMaterial("candyMaterial", 3, 1561, 8.0F, 400.0F, 10);

	public Candy_Shovel() {
		super(candyMaterial);
		GameRegistry.registerItem(this,"candyshovel");
		this.setUnlocalizedName("candyshovel");
		this.setCreativeTab(CreativeTabs.tabTools);
	}

}
