package entitys;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.example.examplemod.ExampleMod;

@SideOnly(Side.CLIENT)
public class Render_Candy_Bullet extends Render
{
	private static ResourceLocation texture = new ResourceLocation(ExampleMod.MODID+":textures/entity/candyfireball.png");
    private static final String __OBFID = "CL_00000978";

    public Render_Candy_Bullet(RenderManager p_i46193_1_)
    {
        super(p_i46193_1_);
    }

    public void doRender(Entity_Candy_Bullet p_180551_1_, double p_180551_2_, double p_180551_4_, double p_180551_6_, float p_180551_8_, float p_180551_9_)
    {
        this.bindEntityTexture(p_180551_1_);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)p_180551_2_, (float)p_180551_4_, (float)p_180551_6_);
        GlStateManager.rotate(p_180551_1_.prevRotationYaw + (p_180551_1_.rotationYaw - p_180551_1_.prevRotationYaw) * p_180551_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(p_180551_1_.prevRotationPitch + (p_180551_1_.rotationPitch - p_180551_1_.prevRotationPitch) * p_180551_9_, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();


        float f5 = 32.0F;//size of image
        float f6 = 0.0F;// x cord min
        float f7 = 1.0F;//this is x cord max (value of 1 is size of image whatever f5 is)
        float f8 = 0.0F;// y cord min
        float f9 = 1.0F;//y cord max
        float f10 = 0.02625F;//this is the scale of image in the world
       
        
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(f10, f10, f10);
        GlStateManager.translate(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);
        worldrenderer.startDrawingQuads();
        worldrenderer.addVertexWithUV(-f5, -f5, -f5, (double)f6, (double)f8);
        worldrenderer.addVertexWithUV(-f5, -f5, f5, (double)f7, (double)f8);
        worldrenderer.addVertexWithUV(-f5, f5, f5, (double)f7, (double)f9);
        worldrenderer.addVertexWithUV(-f5, f5, -f5, (double)f6, (double)f9);
        tessellator.draw();
        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(p_180551_1_, p_180551_2_, p_180551_4_, p_180551_6_, p_180551_8_, p_180551_9_);
    }

    protected ResourceLocation getEntityTexture(Entity_Candy_Bullet p_180550_1_)
    {
        return texture;
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((Entity_Candy_Bullet)entity);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        this.doRender((Entity_Candy_Bullet)entity, x, y, z, p_76986_8_, partialTicks);
    }
}