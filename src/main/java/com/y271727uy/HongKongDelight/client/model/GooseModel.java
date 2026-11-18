package com.y271727uy.HongKongDelight.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.y271727uy.HongKongDelight.HongKongDelightMod;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GooseModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(HongKongDelightMod.MODID, "goose"), "main");

    private final ModelPart root;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart neck;

    public GooseModel(ModelPart root) {
        this.root = root;
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.rightWing = root.getChild("right_wing");
        this.leftWing = root.getChild("left_wing");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.neck = root.getChild("neck");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        // Blockbench feet are zero-thickness planes sitting exactly on the ground.
        // Give them one pixel of thickness so they stay visible.
        root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                .texOffs(34, 28)
                .addBox(-3.0F, -2.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 11)
                .addBox(-4.0F, 1.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 22.0F, 0.0F));

        root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                .texOffs(34, 28)
                .addBox(-3.0F, 7.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 25)
                .addBox(-4.0F, 10.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition rightWing = root.addOrReplaceChild("right_wing", CubeListBuilder.create(),
                PartPose.offset(0.0F, 16.0F, 0.0F));
        rightWing.addOrReplaceChild("cube_r1", CubeListBuilder.create()
                .texOffs(16, 16)
                .addBox(0.0F, -3.0F, -1.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition leftWing = root.addOrReplaceChild("left_wing", CubeListBuilder.create(),
                PartPose.offset(0.0F, 21.0F, 0.0F));
        leftWing.addOrReplaceChild("cube_r2", CubeListBuilder.create()
                .texOffs(0, 16)
                .addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, -5.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(18, 28)
                .addBox(-2.0F, -15.0F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 20.0F, -1.0F));
        head.addOrReplaceChild("mouse", CubeListBuilder.create()
                .texOffs(37, 0)
                .addBox(-1.0F, -13.0F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 0)
                .addBox(-2.0F, -14.0F, -6.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(),
                PartPose.offset(0.0F, 20.0F, -1.0F));
        body.addOrReplaceChild("cube_r3", CubeListBuilder.create()
                .texOffs(34, 5)
                .addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -2.0F, 9.0F, -0.1745F, 0.0F, 0.0F));
        body.addOrReplaceChild("cube_r4", CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.0F, -7.0F, -1.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition beast = body.addOrReplaceChild("beast", CubeListBuilder.create(),
                PartPose.offset(0.0F, -2.0F, -1.0F));
        beast.addOrReplaceChild("cube_r5", CubeListBuilder.create()
                .texOffs(0, 28)
                .addBox(-3.0F, -5.0F, -2.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition neck = root.addOrReplaceChild("neck", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 13.0F, -2.0F, 0.0436F, 0.0F, 0.0F));
        neck.addOrReplaceChild("cube_r6", CubeListBuilder.create()
                .texOffs(5, 25)
                .addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 2.0787F, -0.3945F, -0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        // Keep the Blockbench rest pose. The exported animations are not applied here
        // because their scale channels currently stretch the model.
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
