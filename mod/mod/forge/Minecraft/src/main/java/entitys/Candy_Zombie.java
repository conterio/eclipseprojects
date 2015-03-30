package entitys;

import com.example.examplemod.ExampleMod;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Candy_Zombie extends EntityZombie {

	
	
	public Candy_Zombie(World worldIn) {
		super(worldIn);
		
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
	 dropItem(GameRegistry.findItem(ExampleMod.MODID, "gummyworm"), 1);
		
	}
	

}
