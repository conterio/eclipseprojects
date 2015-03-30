package entitys;

import com.example.examplemod.ExampleMod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class Render_Candy_Cow extends RenderLiving {
	
	
	private static ResourceLocation texture = new ResourceLocation(ExampleMod.MODID+":textures/entity/candy_cow.png");
	

	public Render_Candy_Cow(RenderManager p_i46187_1_, ModelBase p_i46187_2_, float p_i46187_3_) {
		super(p_i46187_1_, p_i46187_2_, p_i46187_3_);

	}


	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return texture;
	}



}
