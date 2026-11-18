package com.y271727uy.HongKongDelight.client.renderer;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import com.y271727uy.HongKongDelight.client.model.GooseModel;
import com.y271727uy.HongKongDelight.entity.GooseEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GooseRenderer extends MobRenderer<GooseEntity, GooseModel<GooseEntity>> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(HongKongDelightMod.MODID, "textures/entity/goose.png");

    public GooseRenderer(EntityRendererProvider.Context context) {
        super(context, new GooseModel<>(context.bakeLayer(GooseModel.LAYER_LOCATION)), 0.45F);
    }

    @Override
    public ResourceLocation getTextureLocation(GooseEntity entity) {
        return TEXTURE;
    }
}
