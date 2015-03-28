package net.minecraftforge.client.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition.MissingVariantException;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition.Variant;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition.Variants;
import net.minecraft.client.renderer.texture.IIconCreator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.BuiltInModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.client.resources.model.WeightedBakedModel;
import net.minecraft.item.Item;
import net.minecraft.util.IRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameData;

import org.apache.logging.log4j.Level;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import net.minecraft.client.renderer.block.model.ModelBlockDefinition.MissingVariantException;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition.Variant;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition.Variants;
public class ModelLoader extends ModelBakery
{
    private final Map<ModelResourceLocation, IModel> stateModels = new HashMap<ModelResourceLocation, IModel>();
    private final Set<ResourceLocation> resolveTextures = new HashSet<ResourceLocation>();
    private final Set<ResourceLocation> textures = new HashSet<ResourceLocation>();
    private final Set<ResourceLocation> loadingModels = new HashSet<ResourceLocation>();

    public ModelLoader(IResourceManager manager, TextureMap map, BlockModelShapes shapes)
    {
        super(manager, map, shapes);
        VanillaLoader.instance.setLoader(this);
        ModelLoaderRegistry.clearModelCache();
    }

    @Override
    public IRegistry func_177570_a()
    {
        loadBlocks();
        loadItems();
        stateModels.put(field_177604_a, getModel(new ResourceLocation(field_177604_a.func_110624_b(), field_177604_a.func_110623_a())));
        textures.remove(TextureMap.field_174945_f);
        textures.addAll(field_177602_b);
        field_177609_j.func_174943_a(field_177598_f, new IIconCreator()
        {
            public void func_177059_a(TextureMap map)
            {
                for(ResourceLocation t : textures)
                {
                    field_177599_g.put(t, map.func_174942_a(t));
                }
            }
        });
        field_177599_g.put(new ResourceLocation("missingno"), field_177609_j.func_174944_f());
        Function<ResourceLocation, TextureAtlasSprite> textureGetter = Functions.forMap(field_177599_g, field_177609_j.func_174944_f());
        for(Entry<ModelResourceLocation, IModel> e : stateModels.entrySet())
        {
            field_177605_n.func_82595_a(e.getKey(), e.getValue().bake(e.getValue().getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT, textureGetter));
        }
        return field_177605_n;
    }

    private void loadBlocks()
    {
        Map<IBlockState, ModelResourceLocation> stateMap = field_177610_k.func_178120_a().func_178446_a();
        Collection<ModelResourceLocation> variants = Lists.newArrayList(stateMap.values());
        variants.add(new ModelResourceLocation("minecraft:item_frame", "normal")); //Vanilla special cases item_frames so must we
        variants.add(new ModelResourceLocation("minecraft:item_frame", "map"));
        func_177591_a(variants);
    }

    @Override
    protected void func_177569_a(ModelBlockDefinition definition, ModelResourceLocation location)
    {
        Variants variants = null;
        try
        {
            variants = definition.func_178330_b(location.func_177518_c());
        }
        catch(MissingVariantException e) {}
        if(variants == null)
        {
            // adding default variant for simple blocks
            ResourceLocation loc = new ResourceLocation(location.func_110624_b(), "block/" + location.func_110623_a());
            variants = new Variants("normal", Lists.newArrayList(new Variant(loc, ModelRotation.X0_Y0, false, 1)));
        }
        if(!variants.func_178420_b().isEmpty())
        {
            try
            {
                stateModels.put(location, new WeightedRandomModel(variants));

            }
            catch(Throwable e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadItems()
    {
        func_177592_e();
        for(Item item : GameData.getItemRegistry().typeSafeIterable())
        {
            for(String s : (List<String>)func_177596_a(item))
            {
                ResourceLocation file = func_177583_a(s);
                ModelResourceLocation memory = new ModelResourceLocation(s, "inventory");
                resolveTextures.add(ModelLoaderRegistry.getActualLocation(file));
                IModel model = getModel(file);
                if(model != null) stateModels.put(memory, model);
            }
        }
    }

    public IModel getModel(ResourceLocation location)
    {
        if(!ModelLoaderRegistry.loaded(location)) loadAnyModel(location);
        return ModelLoaderRegistry.getModel(location);
    }

    @Override
    protected ResourceLocation func_177580_d(ResourceLocation model)
    {
        return new ResourceLocation(model.func_110624_b(), model.func_110623_a() + ".json");
    }

    private void loadAnyModel(ResourceLocation location)
    {
        if(loadingModels.contains(location))
        {
            throw new IllegalStateException("circular model dependencies involving model " + location);
        }
        loadingModels.add(location);
        IModel model = ModelLoaderRegistry.getModel(location);
        for(ResourceLocation dep : model.getDependencies())
        {
            getModel(dep);
        }
        textures.addAll(model.getTextures());
        loadingModels.remove(location);
    }

    private class VanillaModelWrapper implements IModel
    {
        private final ResourceLocation location;
        private final ModelBlock model;

        public VanillaModelWrapper(ResourceLocation location, ModelBlock model)
        {
            this.location = location;
            this.model = model;
        }

        public Collection<ResourceLocation> getDependencies()
        {
            if(model.func_178305_e() == null || model.func_178305_e().func_110623_a().startsWith("builtin/")) return Collections.emptyList();
            return Collections.singletonList(model.func_178305_e());
        }

        public Collection<ResourceLocation> getTextures()
        {
            // setting parent here to make textures resolve properly
            if(model.func_178305_e() != null)
            {
                IModel parent = getModel(model.func_178305_e());
                if(parent instanceof VanillaModelWrapper)
                {
                    model.field_178315_d = ((VanillaModelWrapper) parent).model;
                }
                else
                {
                    throw new IllegalStateException("vanilla model" + model + "can't have non-vanilla parent");
                }
            }

            if(!resolveTextures.contains(location)) return Collections.emptyList();

            ImmutableSet.Builder<ResourceLocation> builder = ImmutableSet.builder();
            builder.add(new ResourceLocation(model.func_178308_c("particle")));

            if(func_177581_b(model))
            {
                for(String s : (List<String>)ItemModelGenerator.field_178398_a)
                {
                    String r = model.func_178308_c(s);
                    ResourceLocation loc = new ResourceLocation(r);
                    if(!r.equals(s))
                    {
                        builder.add(loc);
                    }
                    // mojang hardcode
                    if(model.func_178310_f() == field_177618_p && !loc.equals(TextureMap.field_174945_f))
                    {
                        TextureAtlasSprite.func_176603_b(loc.toString());
                    }
                    else if(model.func_178310_f() == field_177617_q && !loc.equals(TextureMap.field_174945_f))
                    {
                        TextureAtlasSprite.func_176602_a(loc.toString());
                    }
                }
            }
            if(location.func_110623_a().startsWith("models/block/") || !ModelLoader.this.isBuiltinModel(model.func_178310_f()))
            {
                builder.addAll(ModelLoader.this.func_177585_a(model));
            }
            return builder.build();
        }

        public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
        {
            if(!Attributes.moreSpecific(format, Attributes.DEFAULT_BAKED_FORMAT))
            {
                throw new IllegalArgumentException("can't bake vanilla models to the format that doesn't fit into the default one: " + format);
            }
            ModelBlock model = this.model;
            if(func_177581_b(model)) model = func_177582_d(model);
            if(func_177587_c(model)) return new IFlexibleBakedModel.Wrapper(new BuiltInModel(new ItemCameraTransforms(model.func_178296_g(), model.func_178306_h(), model.func_178301_i(), model.func_178297_j())), Attributes.DEFAULT_BAKED_FORMAT);
            return new IFlexibleBakedModel.Wrapper(bakeModel(model, state.apply(this), state instanceof UVLock), Attributes.DEFAULT_BAKED_FORMAT);
        }

        public IModelState getDefaultState()
        {
            return ModelRotation.X0_Y0;
        }
    }

    public static class UVLock implements IModelState
    {
        private final IModelState state;

        public UVLock(IModelState state)
        {
            this.state = state;
        }

        public TRSRTransformation apply(IModelPart part)
        {
            return state.apply(part);
        }
    }

    // Weighted models can contain multiple copies of 1 model with different rotations - this is to make it work with IModelState (different copies will be different objects).
    private static class WeightedPartWrapper implements IModel
    {
        private final IModel model;

        public WeightedPartWrapper(IModel model)
        {
            this.model = model;
        }

        public Collection<ResourceLocation> getDependencies()
        {
            return model.getDependencies();
        }

        public Collection<ResourceLocation> getTextures()
        {
            return model.getTextures();
        }

        public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
        {
            return model.bake(state, format, bakedTextureGetter);
        }

        public IModelState getDefaultState()
        {
            return model.getDefaultState();
        }
    }

    private class WeightedRandomModel implements IModel
    {
        private final List<Variant> variants;
        private final List<ResourceLocation> locations = new ArrayList<ResourceLocation>();
        private final List<IModel> models = new ArrayList<IModel>();
        private final IModelState defaultState;

        public WeightedRandomModel(Variants variants)
        {
            this.variants = variants.func_178420_b();
            ImmutableMap.Builder<IModelPart, TRSRTransformation> builder = ImmutableMap.builder();
            for(Variant v : (List<Variant>)variants.func_178420_b())
            {
                ResourceLocation loc = v.func_178431_a();
                resolveTextures.add(ModelLoaderRegistry.getActualLocation(loc));
                locations.add(loc);
                IModel model = new WeightedPartWrapper(getModel(loc));
                models.add(model);
                builder.put(model, new TRSRTransformation(v.func_178432_b()));
            }
            defaultState = new MapModelState(builder.build());
        }

        public Collection<ResourceLocation> getDependencies()
        {
            return ImmutableList.copyOf(locations);
        }

        public Collection<ResourceLocation> getTextures()
        {
            /*ImmutableSet.Builder<ResourceLocation> builder = ImmutableSet.builder();
            for(ResourceLocation loc : locations)
            {
                builder.addAll(getModel(loc).getTextures());
            }
            return builder.build();*/
            return Collections.emptyList();
        }

        private IModelState addUV(boolean uv, IModelState state)
        {
            if(uv) return new UVLock(state);
            return state;
        }

        public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
        {
            if(!Attributes.moreSpecific(format, Attributes.DEFAULT_BAKED_FORMAT))
            {
                throw new IllegalArgumentException("can't bake vanilla weighted models to the format that doesn't fit into the default one: " + format);
            }
            if(variants.size() == 1)
            {
                Variant v = variants.get(0);
                IModel model = models.get(0);
                return model.bake(addUV(v.func_178433_c(), state.apply(model)), format, bakedTextureGetter);
            }
            WeightedBakedModel.Builder builder = new WeightedBakedModel.Builder();
            for(int i = 0; i < variants.size(); i++)
            {
                IModel model = models.get(i);
                Variant v =  variants.get(i);
                builder.func_177677_a(model.bake(addUV(v.func_178433_c(), state.apply(model)), format, bakedTextureGetter), variants.get(i).func_178430_d());
            }
            return new IFlexibleBakedModel.Wrapper(builder.func_177676_a(), Attributes.DEFAULT_BAKED_FORMAT);
        }

        public IModelState getDefaultState()
        {
            return defaultState;
        }
    }

    private boolean isBuiltinModel(ModelBlock model)
    {
        return model == field_177606_o || model == field_177618_p || model == field_177617_q || model == field_177616_r;
    }

    public IModel getMissingModel()
    {
        return getModel(new ResourceLocation(field_177604_a.func_110624_b(), field_177604_a.func_110623_a()));
    }

    static enum VanillaLoader implements ICustomModelLoader
    {
        instance;

        private ModelLoader loader;

        void setLoader(ModelLoader loader)
        {
            this.loader = loader;
        }

        ModelLoader getLoader()
        {
            return loader;
        }

        public void func_110549_a(IResourceManager resourceManager)
        {
            // do nothing, cause loader will store the reference to the resourceManager
        }

        public boolean accepts(ResourceLocation modelLocation)
        {
            return true;
        }

        public IModel loadModel(ResourceLocation modelLocation)
        {
            try
            {
                return loader.new VanillaModelWrapper(modelLocation, loader.func_177594_c(modelLocation));
            }
            catch(IOException e)
            {
                FMLLog.log(Level.ERROR, e, "Exception loading model %s with vanilla loader, skipping", modelLocation);
                return loader.getMissingModel();
            }
        }
    }
}
