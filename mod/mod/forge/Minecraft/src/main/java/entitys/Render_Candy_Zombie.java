package entitys;


import com.example.examplemod.ExampleMod;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class Render_Candy_Zombie extends RenderZombie {

	private static ResourceLocation texture = new ResourceLocation(ExampleMod.MODID+":textures/entity/ruby_zombie.png");

    
	public Render_Candy_Zombie(RenderManager p_i46127_1_) {
		super(p_i46127_1_);


	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}
