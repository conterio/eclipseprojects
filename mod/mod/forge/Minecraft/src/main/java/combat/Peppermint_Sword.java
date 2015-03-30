package combat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Peppermint_Sword extends ItemSword {
	
	static ToolMaterial peppermint = EnumHelper.addToolMaterial("peppermint", 3, 1561, 8.0F, 400.0F, 10);

	public Peppermint_Sword() {
		super(peppermint);
		
		GameRegistry.registerItem(this, "peppermintsword");
		this.setUnlocalizedName("peppermintsword");
		this.setCreativeTab(CreativeTabs.tabCombat);
	
		
		
		
		
	}

}
