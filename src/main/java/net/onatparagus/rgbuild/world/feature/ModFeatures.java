package net.onatparagus.rgbuild.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.PointedDripstoneFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onatparagus.rgbuild.RGBuild;
import net.onatparagus.rgbuild.world.feature.configurations.PointedSpectriumConfiguration;

import java.util.function.Supplier;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, RGBuild.MOD_ID);

    public static final RegistryObject<Feature<PointedSpectriumConfiguration>> POINTED_SPECTRIUM = registerFeature("pointed_spectrium",
            () -> new PointedSpectriumFeature(PointedSpectriumConfiguration.CODEC));

    /*private static <C extends FeatureConfiguration, F extends Feature<C>> F registerF(String p_65808_, F p_65809_) {
        return Registry.register(BuiltInRegistries.FEATURE, p_65808_, p_65809_);
    }*/

    private static <T extends Feature<?>> RegistryObject<T> registerFeature(String name, Supplier<T> feature){
        RegistryObject<T> toReturn = FEATURES.register(name,feature);
        return toReturn;
    }

    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }

}
