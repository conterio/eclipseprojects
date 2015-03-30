package tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Axe extends ItemAxe {
	
	static ToolMaterial candyMaterial = EnumHelper.addToolMaterial("candyMaterial", 3, 1561, 8.0F, 400.0F, 10);

	public Candy_Axe() {
		super(candyMaterial);
		GameRegistry.registerItem(this,"candyaxe");
		this.setUnlocalizedName("candyaxe");
		this.setCreativeTab(CreativeTabs.tabTools);
		
	}

}
