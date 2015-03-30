package tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Pickaxe extends ItemPickaxe {
	
	static ToolMaterial candyMaterial = EnumHelper.addToolMaterial("candyMaterial", 3, 1561, 8.0F, 400.0F, 10);

	public Candy_Pickaxe() {
		super(candyMaterial);
		
		GameRegistry.registerItem(this,"candypickaxe");
		this.setUnlocalizedName("candypickaxe");
		this.setCreativeTab(CreativeTabs.tabTools);

	}

}
