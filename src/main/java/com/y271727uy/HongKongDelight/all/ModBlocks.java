package com.y271727uy.HongKongDelight.all;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
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
            () -> new RoastedGooseBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .strength(0.5F)
                    .sound(SoundType.WOOD)
                    .noOcclusion())
    );
}
