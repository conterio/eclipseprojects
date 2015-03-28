package entitys;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class Candy_Villager extends EntityGiantZombie {

	public Candy_Villager(World worldIn) {
		super(worldIn);
		 this.setSize(this.width * 6.0F, this.height * 6.0F);

	}
	
    public float getEyeHeight()
    {
        return 10.440001F;
    }
    

    public float func_180484_a(BlockPos p_180484_1_)
    {
        return this.worldObj.getLightBrightness(p_180484_1_) - 0.5F;
    }

}
