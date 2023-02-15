package net.onatparagus.rgbuild.block;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.onatparagus.rgbuild.RGBuild;
import net.onatparagus.rgbuild.item.ModItems;

@Mod.EventBusSubscriber(modid = RGBuild.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab RGBUILD_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.Register event){
        RGBUILD_TAB = event.registerCreativeModeTab(new ResourceLocation(RGBuild.MOD_ID, "rgbuild_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.SPECTRIUM_SHARD.get()))
                        .title(Component.translatable("creativemodetab.rgbuild_tab")));
    }
}
