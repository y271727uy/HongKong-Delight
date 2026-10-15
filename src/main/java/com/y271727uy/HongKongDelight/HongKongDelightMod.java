package com.y271727uy.HongKongDelight;

import com.mojang.logging.LogUtils;
import com.y271727uy.HongKongDelight.all.ModBlocks;
import com.y271727uy.HongKongDelight.all.ModCreativeTabs;
import com.y271727uy.HongKongDelight.all.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(HongKongDelightMod.MODID)
public class HongKongDelightMod {
    public static final String MODID = "hongkong_delight";

    private static final Logger LOGGER = LogUtils.getLogger();

    public HongKongDelightMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

    }



}


