package com.y271727uy.HongKongDelight.all;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import com.y271727uy.HongKongDelight.item.BowlItem;
import com.y271727uy.HongKongDelight.item.GlassBottleItem;
import com.y271727uy.HongKongDelight.item.PorcelainPlateItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HongKongDelightMod.MODID);

    public static final RegistryObject<Item> HONG_KONG_FLAG = ITEMS.register(
            "hong_kong_special_administrative_region_flag",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> ROASTED_GOOSE_MEAT = ITEMS.register(
            "roasted_goose_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.8F)
                    .meat()
                    .build()))
    );

    public static final RegistryObject<Item> RAW_GOOSE = ITEMS.register(
            "raw_goose",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.8F)
                    .meat()
                    .build()))
    );

    public static final RegistryObject<Item> ROASTED_GOOSE_LEG = ITEMS.register(
            "roasted_goose_leg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.8F)
                    .meat()
                    .build()))
    );

    public static final RegistryObject<Item> FISH_BALL = ITEMS.register(
            "fish_ball",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3F)
                    .build()))
    );

    public static final RegistryObject<Item> WAFFLES = ITEMS.register(
            "waffles",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.6F)
                    .build()))
    );

    public static final RegistryObject<Item> EGG_WAFFLE = ITEMS.register(
            "egg_waffle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6F)
                    .build()))
    );

    public static final RegistryObject<Item> BEEF_BRISKET_RICE_NOODLES = ITEMS.register(
            "beef_brisket_rice_noodles",
            () -> new BowlItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.8F)
                    .build()))
    );

    public static final RegistryObject<Item> HONGKONG_STYLE_MILK_TEA = ITEMS.register(
            "hongkong_style_milk_tea",
            () -> new GlassBottleItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.6F)
                    .build()))
    );

    public static final RegistryObject<Item> PORCELAIN_PLATE = ITEMS.register(
            "porcelain_plate",
            () -> new PorcelainPlateItem(new Item.Properties())
    );

    public static final RegistryObject<Item> UNFIRED_PLATE = ITEMS.register(
            "unfired_plate",
            () -> new Item(new Item.Properties())
    );

}
