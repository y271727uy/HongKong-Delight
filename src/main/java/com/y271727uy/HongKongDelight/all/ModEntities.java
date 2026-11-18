package com.y271727uy.HongKongDelight.all;

import com.y271727uy.HongKongDelight.HongKongDelightMod;
import com.y271727uy.HongKongDelight.entity.GooseEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HongKongDelightMod.MODID);

    public static final RegistryObject<EntityType<GooseEntity>> GOOSE = ENTITY_TYPES.register(
            "goose",
            () -> EntityType.Builder.of(GooseEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.0F)
                    .build(HongKongDelightMod.MODID + ":goose")
    );

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(GOOSE.get(), GooseEntity.createAttributes().build());
    }
}
