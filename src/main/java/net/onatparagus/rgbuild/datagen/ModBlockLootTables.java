package net.onatparagus.rgbuild.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.onatparagus.rgbuild.block.ModBlocks;
import net.onatparagus.rgbuild.item.ModItems;


import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SPECTRIUM_BLOCK.get());

        add(ModBlocks.SPECTRIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SPECTRIUM_ORE.get(), ModItems.SPECTRIUM_SHARD.get()));
        add(ModBlocks.DEEPSLATE_SPECTRIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SPECTRIUM_ORE.get(), ModItems.SPECTRIUM_SHARD.get()));
        add(ModBlocks.SPECTRITE.get(),
                (block) -> createOreDrop(ModBlocks.SPECTRITE.get(), ModItems.SPECTRIUM_SHARD.get()));
        add(ModBlocks.POINTED_SPECTRITE.get(),
                (block) -> createOreDrop(ModBlocks.POINTED_SPECTRITE.get(), ModItems.SPECTRIUM_SHARD.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}