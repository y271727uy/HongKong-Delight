package com.y271727uy.HongKongDelight.datagen;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HongKongDelightMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        itemModels().getBuilder("roasted_goose")
                .parent(itemModels().getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/roasted_goose"));
        itemModels().getBuilder("roasted_goose_meat")
                .parent(itemModels().getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/roasted_goose_meat"));
        itemModels().getBuilder("roasted_goose_leg")
                .parent(itemModels().getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/roasted_goose_leg"));
    }
}
