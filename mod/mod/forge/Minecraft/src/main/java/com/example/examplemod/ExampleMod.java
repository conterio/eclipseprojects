package com.example.examplemod;

import java.util.Iterator;
import plants.*;
import tools.*;
import items.*;
import biomes.Biome_Apple_Forest;
import blocks.*;
import combat.*;
import entitys.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static final BiomeGenBase crazyBiome = (new Biome_Apple_Forest(50)).setColor(0xef213e).setBiomeName("Crazybiome");
    
    


    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    
    	

    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	
    	if(event.getSide() == Side.CLIENT)
    	{
 			
    	    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    	    	
    	    	
    	    	//Create and render items****************************************************************************************************
    	    	renderItem.getItemModelMesher().register(new Gummy_Worm(8,.06F,false), 0, new ModelResourceLocation("examplemod:gummyworm", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Chocolate(3,.06F,false), 0, new ModelResourceLocation("examplemod:chocolate", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Chocolate_Milk(), 0, new ModelResourceLocation("examplemod:chocolatemilk", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Cocoa_Powder(), 0, new ModelResourceLocation("examplemod:cocoapowder", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Cotton_Candy(0,false), 0, new ModelResourceLocation("examplemod:cottoncandy", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Gum(0,false), 0, new ModelResourceLocation("examplemod:gum", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Lollipop(2,false), 0, new ModelResourceLocation("examplemod:lollipop", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Sour_Gummy_Worm(1,false), 0, new ModelResourceLocation("examplemod:sourgummyworm", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Launcher(), 0, new ModelResourceLocation("examplemod:candylauncher", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Red_Hot_Candy(-5,false), 0, new ModelResourceLocation("examplemod:redhotcandy", "inventory"));

    	    	
    	    	//Create and render blocks****************************************************************************************************
    	    	//start at 198
    	    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(new Gummy_Dirt()), 0, new ModelResourceLocation("examplemod:gummydirt", "inventory"));
    	    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(new Candy_Sand()), 0, new ModelResourceLocation("examplemod:candysand", "inventory"));
    	    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(new Candy_Brick(MapColor.blueColor)), 0, new ModelResourceLocation("examplemod:candybrick", "inventory"));
    	    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(new Candy_Stripes(Material.rock)), 0, new ModelResourceLocation("examplemod:cb", "inventory"));
    	    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(new Candy_Bush()), 0, new ModelResourceLocation("examplemod:candybush", "inventory"));
    	    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(new Red_Hot()), 0, new ModelResourceLocation("examplemod:redhot", "inventory"));
    	    	
    	    	
    	    	//Create and render tools
    	    	renderItem.getItemModelMesher().register(new Candy_Hoe(), 0, new ModelResourceLocation("examplemod:candyhoe", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Pickaxe(), 0, new ModelResourceLocation("examplemod:candypickaxe", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Shovel(), 0, new ModelResourceLocation("examplemod:candyshovel", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Axe(), 0, new ModelResourceLocation("examplemod:candyaxe", "inventory"));
    	    	
    	    	
    	    	//Create and render combat gear*************************************************************************************************
    	    	renderItem.getItemModelMesher().register(new Peppermint_Sword(), 0, new ModelResourceLocation("examplemod:peppermintsword", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Armor(0,0), 0, new ModelResourceLocation("examplemod:candyhelmet", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Armor(0,1), 0, new ModelResourceLocation("examplemod:candychestplate", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Armor(0,2), 0, new ModelResourceLocation("examplemod:candyleggings", "inventory"));
    	    	renderItem.getItemModelMesher().register(new Candy_Armor(0,3), 0, new ModelResourceLocation("examplemod:candyboots", "inventory"));

    	    	
    	    	//Recipes***********************************************************************************************************
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "gummyworm"),9), "#",'#',GameRegistry.findItem("examplemod", "candybrick"));
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candybrick")), "###", "###", "###", '#',GameRegistry.findItem("examplemod", "gummyworm"));
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "peppermintsword")), "X","X","#",'X',GameRegistry.findItem("examplemod", "lollipop"),'#',Items.stick);
    	    	//tool recipes
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candyhoe"))," XX"," # "," # ",'X',GameRegistry.findItem("examplemod", "chocolate"),'#',Items.stick);
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candypickaxe")),"XXX"," # "," # ",'X',GameRegistry.findItem("examplemod", "chocolate"),'#',Items.stick);
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candyshovel")),"X","#","#",'X',GameRegistry.findItem("examplemod", "chocolate"),'#',Items.stick);
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candyaxe")),"XX ","X# "," # ",'X',GameRegistry.findItem("examplemod", "chocolate"),'#',Items.stick);
    	    	//armor recipes
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candyhelmet")), "XXX","X X", 'X',GameRegistry.findItem("examplemod","chocolate"));
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candychestplate")), "X X","XXX","XXX", 'X',GameRegistry.findItem("examplemod","chocolate"));
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candyleggings")), "XXX","X X","X X", 'X',GameRegistry.findItem("examplemod","chocolate"));
    	    	GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("examplemod", "candyboots")),"X X","X X", 'X',GameRegistry.findItem("examplemod","chocolate"));
    	    	
    	    	
    	    	//custom smelting
    	    	//item/block you want to put in (candyore), item/block you want out (candyignot), how many you want to come out, xp you get from it.
    	    	GameRegistry.addSmelting(Block.getBlockFromName("examplemod:candybrick"), new ItemStack(GameRegistry.findItem("examplemod", "chocolate"), 10), 1F);
    	    	//Create Plant types
    	    	renderItem.getItemModelMesher().register(new Candy_Bush_Seed(3, 0.3F, Block.getBlockFromName("examplemod:candybush") , Blocks.farmland), 0, new ModelResourceLocation("examplemod:candybushseed", "inventory"));
    	    	
    	    	
    	    	//Create and render monsters*****************************************************************************************************
    	    	EntityRegistry.registerModEntity(Candy_Zombie.class, "candyzombie", 1, this, 80, 3, true);
    	    	RenderingRegistry.registerEntityRenderingHandler(Candy_Zombie.class, new Render_Candy_Zombie(Minecraft.getMinecraft().getRenderManager()));
    	    	EntityList.addMapping(Candy_Zombie.class, "Cz" , 300);
    	    	
    	    	EntityRegistry.registerModEntity(Candy_Villager.class, "candyvillager", 3, this, 80, 3, true);
    	    	RenderingRegistry.registerEntityRenderingHandler(Candy_Villager.class, new Render_Candy_Villager(Minecraft.getMinecraft().getRenderManager(), new ModelVillager(0), 0.5F, 6F));
    	    	EntityList.addMapping(Candy_Villager.class, "Cv" , 302);
    	    	
    	    	
    	    	EntityRegistry.registerModEntity(Candy_Cow.class, "candycow", 2, this, 80, 3, true);
    	    	RenderingRegistry.registerEntityRenderingHandler(Candy_Cow.class, new Render_Candy_Cow(Minecraft.getMinecraft().getRenderManager(),new ModelCow(), 3.0F));
    	    	EntityList.addMapping(Candy_Cow.class, "Cc" , 301);
    	    	
    	    	EntityRegistry.registerModEntity(Entity_Candy_Bullet.class, "candybullet", 4, this, 80, 3, true);
    	    	RenderingRegistry.registerEntityRenderingHandler(Entity_Candy_Bullet.class, new Render_Candy_Bullet(Minecraft.getMinecraft().getRenderManager()));

    	    	

    			BiomeGenBase[] biomes = new BiomeGenBase[BiomeGenBase.explorationBiomesList.size()];
    			Iterator<BiomeGenBase> it = BiomeGenBase.explorationBiomesList.iterator();
    			for (int i = 0; i < biomes.length; i++) {
    			  biomes[i] = it.next();
    			}
    			EntityRegistry.addSpawn(Candy_Zombie.class, 30, 1, 3, EnumCreatureType.MONSTER, biomes);
    			EntityRegistry.addSpawn(Candy_Cow.class, 30, 1, 2, EnumCreatureType.CREATURE, biomes);
    	    	

    			
    			
    			
    			
    	    	
    	    	
   	    	

    	}
        	
    }
}
