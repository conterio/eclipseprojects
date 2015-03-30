package entitys;

import com.example.examplemod.ExampleMod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

public class Render_Candy_Villager extends RenderLiving {
	private static ResourceLocation texture = new ResourceLocation(ExampleMod.MODID+":textures/entity/ruby_zombie.png");
	private float scale;
	
	
	public Render_Candy_Villager(RenderManager p_i46173_1_, ModelBase p_i46173_2_, float p_i46173_3_, float p_i46173_4_)
    {
        super(p_i46173_1_, p_i46173_2_, p_i46173_3_ * p_i46173_4_);
        this.scale = p_i46173_4_;
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this)
        {
            
            protected void func_177177_a()
            {
                this.field_177189_c = new ModelZombie(0.5F, true);
                this.field_177186_d = new ModelZombie(1.0F, true);
            }
        });
    }


    public void func_82422_c()
    {
        GlStateManager.translate(0.0F, 0.1875F, 0.0F);
    }

    protected void preRenderCallback(EntityGiantZombie p_77041_1_, float p_77041_2_)
    {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }


	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
	
	protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityGiantZombie)p_77041_1_, p_77041_2_);
    }



}
