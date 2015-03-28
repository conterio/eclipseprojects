package combat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Armor extends ItemArmor {
	
	static ArmorMaterial candyArmorMaterial = EnumHelper.addArmorMaterial("candyarmor", "candyarmor", 33, new int[]{3, 8,6,3},10);

	public Candy_Armor(int renderIndex, int armorType) {
		super(candyArmorMaterial, renderIndex, armorType);


		switch(armorType){
			case 0: {
				GameRegistry.registerItem(this, "candyhelmet");
				this.setUnlocalizedName("candyhelmet");
				break;
			}
			case 1:{
				GameRegistry.registerItem(this, "candychestplate");
				this.setUnlocalizedName("candychestplate");
				break;
			}
			case 2:{
				GameRegistry.registerItem(this, "candyleggings");
				this.setUnlocalizedName("candyleggings");
				break;
			}
			case 3:{
				GameRegistry.registerItem(this, "candyboots");
				this.setUnlocalizedName("candyboots");
				break;
			}
		}
		
		this.setCreativeTab(CreativeTabs.tabCombat);
				
	}//end constructor
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	 	  if(slot == 0 || slot == 1 || slot == 3 ){
			  return "examplemod:textures/models/armor/candy_layer_1.png";
		  }
		  else if(slot == 2){
			  return "examplemod:textures/models/armor/candy_layer_2.png";
		  }
		  else{
			  return null;
		  }
	 	  
	}//end getArmorTexture  

}//end Candy_Armor Class
