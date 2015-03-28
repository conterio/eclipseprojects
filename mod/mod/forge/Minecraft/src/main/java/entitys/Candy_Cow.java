package entitys;

import com.example.examplemod.ExampleMod;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Cow extends EntityCow{

	public Candy_Cow(World worldIn) {
		super(worldIn);

	}

	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
	 dropItem(GameRegistry.findItem(ExampleMod.MODID, "sourgummyworm"), 1);
		
	}



	
}
