package com.y271727uy.HongKongDelight.all;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import com.y271727uy.HongKongDelight.block.DirectFoodBlock;
import com.y271727uy.HongKongDelight.all.ModItems;
import com.y271727uy.HongKongDelight.block.RoastedGooseBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HongKongDelightMod.MODID);

    public static final RegistryObject<Block> ROASTED_GOOSE = BLOCKS.register(
            "roasted_goose",
            () -> new RoastedGooseBlock(foodProperties())
    );

    public static final RegistryObject<Block> WORCESTERSHIRE_STEAK = BLOCKS.register(
            "worcestershire_steak",
            () -> new DirectFoodBlock(foodProperties(), Block.box(0, 0, 2, 16, 4, 14), 3, 7, 0.8F)
    );

    public static final RegistryObject<Block> MORO_CHICKEN_RICE = BLOCKS.register(
            "moro_chicken_rice",
            () -> new DirectFoodBlock(foodProperties(), Block.box(1, 0, 1, 15, 4, 15), 6, 7, 0.8F)
    );

    public static final RegistryObject<Block> PASTA_IN_SOUP = BLOCKS.register(
            "pasta_in_soup",
            () -> new DirectFoodBlock(foodProperties(), Block.box(2, 5, 2, 14, 9, 14), 5, 6, 0.6F,
                    () -> net.minecraft.world.item.Items.BOWL)
    );

    public static final RegistryObject<Block> BAKED_PORK_CHOP_RICE = BLOCKS.register(
            "baked_pork_chop_rice",
            () -> new DirectFoodBlock(foodProperties(), Block.box(1, 0, 1, 15, 6, 15), 4, 8, 0.8F)
    );

    public static final RegistryObject<Block> SWISS_WING = BLOCKS.register(
            "swiss_wing",
            () -> new DirectFoodBlock(foodProperties(), Block.box(0, 0, 3, 16, 4, 13), 4, 6, 0.6F)
    );

    private static BlockBehaviour.Properties foodProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_ORANGE)
                .strength(0.5F)
                .sound(SoundType.WOOD)
                .noOcclusion();
    }
}
