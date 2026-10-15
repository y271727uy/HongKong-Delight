package com.y271727uy.HongKongDelight.datagen;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import com.y271727uy.HongKongDelight.all.ModBlocks;
import com.y271727uy.HongKongDelight.all.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = HongKongDelightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {
    private ModDataGenerators() {
    }

    @SubscribeEvent
    public static void bindBlockItems(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> {
            Set<String> existingItems = ModItems.ITEMS.getEntries().stream()
                    .map(item -> item.getId().getPath())
                    .collect(Collectors.toSet());

            for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                String name = block.getId().getPath();
                if (!existingItems.contains(name)) {
                    helper.register(block.getId(), new BlockItem(block.get(), new Item.Properties()));
                }
            }
        });
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
    }

}
