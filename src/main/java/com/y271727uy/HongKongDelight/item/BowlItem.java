package com.y271727uy.HongKongDelight.item;

import com.y271727uy.HongKongDelight.all.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BowlItem extends Item {
    public BowlItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack remaining = super.finishUsingItem(stack, level, entity);
        ItemStack plate = new ItemStack(ModItems.PORCELAIN_PLATE.get());

        if (remaining.isEmpty()) {
            return plate;
        }
        if (entity instanceof Player player && !player.getAbilities().instabuild
                && !player.getInventory().add(plate)) {
            player.drop(plate, false);
        }
        return remaining;
    }
}
