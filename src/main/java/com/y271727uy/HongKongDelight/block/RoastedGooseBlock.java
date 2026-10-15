package com.y271727uy.HongKongDelight.block;

import com.y271727uy.HongKongDelight.all.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RoastedGooseBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 9);
    public static final int MAX_SERVINGS = 9;

    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 2.0D, 16.0D, 6.0D, 14.0D);

    public RoastedGooseBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SERVINGS, MAX_SERVINGS));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return takeServing(level, pos, state, player).consumesAction()
                    ? InteractionResult.SUCCESS
                    : InteractionResult.CONSUME;
        }
        return takeServing(level, pos, state, player);
    }

    private InteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        int servings = state.getValue(SERVINGS);
        if (servings <= 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            return InteractionResult.SUCCESS;
        }

        ItemStack serving = new ItemStack(ModItems.ROASTED_GOOSE_MEAT.get());
        level.setBlock(pos, state.setValue(SERVINGS, servings - 1), Block.UPDATE_ALL);
        if (!player.getAbilities().instabuild && !player.getInventory().add(serving)) {
            player.drop(serving, false);
        }
        level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return state.getValue(SERVINGS);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
