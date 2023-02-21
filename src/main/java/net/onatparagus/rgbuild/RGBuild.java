package net.onatparagus.rgbuild;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.onatparagus.rgbuild.block.ModBlocks;
import net.onatparagus.rgbuild.block.ModCreativeModeTab;
import net.onatparagus.rgbuild.item.ModItems;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import static net.minecraft.world.level.biome.Biomes.PLAINS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RGBuild.MOD_ID)
public class RGBuild
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "rgbuild";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    /*
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
    */
    public RGBuild()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);





        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        /*// Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);*/

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        /*// Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));*/
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTab.RGBUILD_TAB){
            event.accept(ModItems.SPECTRIUM_SHARD);
            event.accept(ModBlocks.SPECTRIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_SPECTRIUM_ORE);
            event.accept(ModBlocks.SPECTRIUM_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.SPECTRIUM_SHARD);
        }
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.SPECTRIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_SPECTRIUM_ORE);
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.SPECTRIUM_BLOCK);
        }
    }

    /*public void addCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "tab"), builder ->

                builder.title(Component.translatable("RGBuild"))

                        .icon(() -> new ItemStack(ModItems.SPECTRIUM_SHARD.get()))

                        .displayItems((enabledFlags, populator, hasPermissions) -> {
                            populator.accept(ModItems.SPECTRIUM_SHARD.get());
                        })
        );
    }*/
/*
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
*/
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            /*// Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());*/

        }
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
            event.getBlockColors().register(new BlockColor() {
                @Override
                public int getColor(BlockState p_92567_, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos p_92569_, int p_92570_) {
                    return 8431445;
                }
                    },ModBlocks.SPECTRIUM_BLOCK.get());
        }

    }
/*
    @Mod.EventBusSubscriber(value = Dist.CLIENT)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerBlockColors(final RegisterColorHandlersEvent.Block event){ //this event is never fired
            event.getBlockColors().register(
                    (s,w,p,i) -> {
                        return FoliageColor.getBirchColor();
                    },ModBlocks.SPECTRIUM_BLOCK.get());
        }
        //other SubscribeEvents are in here
    }*/
}
