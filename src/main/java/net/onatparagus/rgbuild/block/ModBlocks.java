package net.onatparagus.rgbuild.block;

import net.minecraft.client.model.ModelUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onatparagus.rgbuild.RGBuild;
import net.onatparagus.rgbuild.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RGBuild.MOD_ID);

    public static final RegistryObject<Block> SPECTRIUM_ORE = registerBlock("spectrium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops().lightLevel(ModBlocks::oreLight), UniformInt.of(2,6)));

    public static final RegistryObject<Block> DEEPSLATE_SPECTRIUM_ORE = registerBlock("deepslate_spectrium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops().lightLevel(ModBlocks::oreLight), UniformInt.of(2,8)));

    public static final RegistryObject<Block> SPECTRIUM_BLOCK = registerBlock("spectrium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel(ModBlocks::fullLight)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    public static int fullLight(BlockState state){
        return 15;
    }
    public static int oreLight(BlockState state) {return 6;}
}
