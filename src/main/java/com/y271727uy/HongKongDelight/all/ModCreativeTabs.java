package com.y271727uy.HongKongDelight.all;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HongKongDelightMod.MODID);

    public static final RegistryObject<CreativeModeTab> HKDELIGHT_TAB =
            CREATIVE_TABS.register("hong_kong_delight", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.hongkong_delight.hong_kong_delight"))
                            .icon(() -> new ItemStack(ModItems.HONG_KONG_FLAG.get()))
                            .displayItems((parameters, output) -> {
                                output.accept(ModItems.HONG_KONG_FLAG.get());
                                output.accept(ModItems.PORCELAIN_PLATE.get());
                                output.accept(ModItems.UNFIRED_PLATE.get());
                                output.accept(ModItems.RAW_GOOSE.get());
                                output.accept(ModBlocks.ROASTED_GOOSE.get());
                                output.accept(ModItems.ROASTED_GOOSE_MEAT.get());
                                output.accept(ModItems.ROASTED_GOOSE_LEG.get());
                                output.accept(ModItems.FISH_BALL.get());
                                output.accept(ModItems.WAFFLES.get());
                                output.accept(ModItems.EGG_WAFFLE.get());
                                output.accept(ModItems.BEEF_BRISKET_RICE_NOODLES.get());
                                output.accept(ModItems.HONGKONG_STYLE_MILK_TEA.get());
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}