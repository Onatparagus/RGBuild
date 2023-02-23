package net.onatparagus.rgbuild.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.onatparagus.rgbuild.RGBuild;
import net.onatparagus.rgbuild.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RGBuild.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModBlocks.SPECTRIUM_BLOCK);
        //blockWithItem(ModBlocks.SPECTRIUM_ORE);
        //blockWithItem(ModBlocks.DEEPSLATE_SPECTRIUM_ORE);
        //blockWithItem(ModBlocks.SPECTRITE);
        //blockWithItem(ModBlocks.POINTED_SPECTRITE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
