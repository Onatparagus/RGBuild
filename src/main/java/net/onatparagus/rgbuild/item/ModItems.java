package net.onatparagus.rgbuild.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.onatparagus.rgbuild.RGBuild;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RGBuild.MOD_ID);

    public static final RegistryObject<Item> SPECTRIUM_SHARD = ITEMS.register("spectrium_shard",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
