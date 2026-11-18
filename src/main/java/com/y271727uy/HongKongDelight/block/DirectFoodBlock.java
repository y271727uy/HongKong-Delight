package com.y271727uy.HongKongDelight.block;

import com.y271727uy.HongKongDelight.all.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.function.Supplier;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DirectFoodBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 9);
    private final VoxelShape foodShape;
    private final int maxServings;
    private final int nutrition;
    private final float saturation;
    private final Supplier<Item> container;

    public DirectFoodBlock(Properties properties, VoxelShape foodShape,
                           int maxServings, int nutrition, float saturation) {
        this(properties, foodShape, maxServings, nutrition, saturation, ModItems.PORCELAIN_PLATE);
    }

    public DirectFoodBlock(Properties properties, VoxelShape foodShape,
                           int maxServings, int nutrition, float saturation, Supplier<Item> container) {
        super(properties);
        this.container = container;
        this.foodShape = foodShape;
        this.maxServings = maxServings;
        this.nutrition = nutrition;
        this.saturation = saturation;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SERVINGS, maxServings));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(SERVINGS, maxServings);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level,
                               BlockPos pos, CollisionContext context) {
        return foodShape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, net.minecraft.world.level.BlockGetter level,
                                        BlockPos pos, CollisionContext context) {
        return foodShape;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        int servings = state.getValue(SERVINGS);
        if (servings > 0) {
            player.getFoodData().eat(nutrition, saturation);
            level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0F,
                    0.9F + level.random.nextFloat() * 0.2F);
            if (servings == 1) {
                giveContainer(level, pos, player);
            } else {
                level.setBlock(pos, state.setValue(SERVINGS, servings - 1), Block.UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }

        giveContainer(level, pos, player);
        return InteractionResult.SUCCESS;
    }

    private void giveContainer(Level level, BlockPos pos, Player player) {
        ItemStack emptyContainer = new ItemStack(container.get());
        level.removeBlock(pos, false);
        if (!player.getAbilities().instabuild && !player.getInventory().add(emptyContainer)) {
            player.drop(emptyContainer, false);
        }
        level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.8F, 1.0F);
    }
}
