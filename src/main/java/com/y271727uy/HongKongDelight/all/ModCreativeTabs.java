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
                                output.accept(ModItems.GOOSE_SPAWN_EGG.get());
                                output.accept(ModItems.PORCELAIN_PLATE.get());
                                output.accept(ModItems.UNFIRED_PLATE.get());
                                output.accept(ModItems.RAW_GOOSE.get());
                                output.accept(ModItems.COOKED_GOOSE.get());
                                output.accept(ModBlocks.ROASTED_GOOSE.get());
                                output.accept(ModBlocks.WORCESTERSHIRE_STEAK.get());
                                output.accept(ModBlocks.MORO_CHICKEN_RICE.get());
                                output.accept(ModBlocks.PASTA_IN_SOUP.get());
                                output.accept(ModBlocks.BAKED_PORK_CHOP_RICE.get());
                                output.accept(ModBlocks.SWISS_WING.get());
                                output.accept(ModItems.ROASTED_GOOSE_MEAT.get());
                                output.accept(ModItems.ROASTED_GOOSE_LEG.get());
                                output.accept(ModItems.FISH_BALL.get());
                                output.accept(ModItems.WAFFLES.get());
                                output.accept(ModItems.EGG_WAFFLE.get());
                                output.accept(ModItems.BEEF_BRISKET_RICE_NOODLES.get());
                                output.accept(ModItems.HONGKONG_STYLE_MILK_TEA.get());
                                 output.accept(ModItems.WORCESTERSHIRE_OYSTER_SAUCE.get());
                                 output.accept(ModItems.DRIED_SCALLOP.get());
                                 output.accept(ModItems.CANTONESE_CRISPY_SKIN_WATER.get());
                                 output.accept(ModItems.SCALLOP.get());
                                 output.accept(ModItems.TIGER_PRAWN.get());
                                 output.accept(ModItems.SATAY_SAUCE.get());
                                 output.accept(ModItems.SHACHA_SAUCE.get());
                                 output.accept(ModItems.HONG_KONG_CURRY_SAUCE.get());
                                 output.accept(ModItems.COOKED_PRAWN.get());
                                 output.accept(ModItems.COOKED_SCALLOP.get());
                                 output.accept(ModItems.COOKED_OYSTER.get());
                                 output.accept(ModItems.SWISS_SAUCE.get());
                                 output.accept(ModItems.WHITE_VINEGAR.get());
                                 output.accept(ModItems.DRIED_SHRIMP.get());
                                 output.accept(ModItems.DRIED_OYSTER.get());
                                 output.accept(ModItems.SOY_SAUCE.get());
                                 output.accept(ModItems.SOUR_PLUM_SAUCE.get());
                                 output.accept(ModItems.GREEN_PLUM.get());
                                 output.accept(ModItems.GREEN_CRAB.get());
                                 output.accept(ModItems.HONG_KONG_OYSTER.get());
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
