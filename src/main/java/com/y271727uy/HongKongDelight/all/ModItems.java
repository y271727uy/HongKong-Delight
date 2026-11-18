package com.y271727uy.HongKongDelight.all;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import com.y271727uy.HongKongDelight.item.BowlItem;
import com.y271727uy.HongKongDelight.item.GlassBottleItem;
import com.y271727uy.HongKongDelight.item.PorcelainPlateItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HongKongDelightMod.MODID);

    public static final RegistryObject<Item> HONG_KONG_FLAG = ITEMS.register(
            "hong_kong_special_administrative_region_flag",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> GOOSE_SPAWN_EGG = ITEMS.register(
            "goose_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOOSE, 0xFFFFFF, 0xE67E22, new Item.Properties())
    );

    public static final RegistryObject<Item> ROASTED_GOOSE_MEAT = ITEMS.register(
            "roasted_goose_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8).saturationMod(0.8F).meat().build()))
    );
    public static final RegistryObject<Item> RAW_GOOSE = ITEMS.register(
            "raw_goose",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3).saturationMod(0.8F).meat().build()))
    );
    public static final RegistryObject<Item> COOKED_GOOSE = ITEMS.register(
            "cooked_goose",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6).saturationMod(0.8F).meat().build()))
    );
    public static final RegistryObject<Item> ROASTED_GOOSE_LEG = ITEMS.register(
            "roasted_goose_leg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6).saturationMod(0.8F).meat().build()))
    );
    public static final RegistryObject<Item> FISH_BALL = ITEMS.register(
            "fish_ball",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationMod(0.3F).build()))
    );
    public static final RegistryObject<Item> WAFFLES = ITEMS.register(
            "waffles",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6).saturationMod(0.6F).build()))
    );
    public static final RegistryObject<Item> EGG_WAFFLE = ITEMS.register(
            "egg_waffle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5).saturationMod(0.6F).build()))
    );
    public static final RegistryObject<Item> BEEF_BRISKET_RICE_NOODLES = ITEMS.register(
            "beef_brisket_rice_noodles",
            () -> new BowlItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8).saturationMod(0.8F).build()))
    );
    public static final RegistryObject<Item> HONGKONG_STYLE_MILK_TEA = ITEMS.register(
            "hongkong_style_milk_tea",
            () -> new GlassBottleItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationMod(0.6F).build()))
    );
    public static final RegistryObject<Item> PORCELAIN_PLATE = ITEMS.register(
            "porcelain_plate", () -> new PorcelainPlateItem(new Item.Properties())
    );
    public static final RegistryObject<Item> UNFIRED_PLATE = ITEMS.register(
            "unfired_plate", () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> WORCESTERSHIRE_OYSTER_SAUCE = simpleItem("worcestershire_oyster_sauce");
    public static final RegistryObject<Item> DRIED_SCALLOP = simpleItem("dried_scallop");
    public static final RegistryObject<Item> CANTONESE_CRISPY_SKIN_WATER = simpleItem("cantonese_crispy_skin_water");
    public static final RegistryObject<Item> SCALLOP = simpleItem("scallop");
    public static final RegistryObject<Item> TIGER_PRAWN = simpleItem("tiger_prawn");
    public static final RegistryObject<Item> SATAY_SAUCE = simpleItem("satay_sauce");
    public static final RegistryObject<Item> SHACHA_SAUCE = simpleItem("shacha_sauce");
    public static final RegistryObject<Item> HONG_KONG_CURRY_SAUCE = simpleItem("hong_kong_curry_sauce");
    public static final RegistryObject<Item> COOKED_PRAWN = simpleItem("cooked_prawn");
    public static final RegistryObject<Item> COOKED_SCALLOP = simpleItem("cooked_scallop");
    public static final RegistryObject<Item> COOKED_OYSTER = simpleItem("cooked_oyster");
    public static final RegistryObject<Item> SWISS_SAUCE = simpleItem("swiss_sauce");
    public static final RegistryObject<Item> WHITE_VINEGAR = simpleItem("white_vinegar");
    public static final RegistryObject<Item> DRIED_SHRIMP = simpleItem("dried_shrimp");
    public static final RegistryObject<Item> DRIED_OYSTER = simpleItem("dried_oyster");
    public static final RegistryObject<Item> SOY_SAUCE = simpleItem("soy_sauce");
    public static final RegistryObject<Item> SOUR_PLUM_SAUCE = simpleItem("sour_plum_sauce");
    public static final RegistryObject<Item> GREEN_PLUM = simpleItem("green_plum");
    public static final RegistryObject<Item> GREEN_CRAB = simpleItem("green_crab");
    public static final RegistryObject<Item> HONG_KONG_OYSTER = simpleItem("hong_kong_oyster");

    private static RegistryObject<Item> simpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
