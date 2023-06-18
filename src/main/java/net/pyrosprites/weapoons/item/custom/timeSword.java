package net.pyrosprites.weapoons.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class timeSword extends SwordItem {
 public timeSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
  super(p_43269_, p_43270_, p_43271_, p_43272_);
 }

 @Override
 public void appendHoverText(ItemStack stack, @Nullable Level lvl, List<Component> components, TooltipFlag flag) {

  if (Screen.hasShiftDown()) {
   components.add(Component.translatable("tooltip.weapoons.timeSword:Yshift"));
  } else {
   components.add(Component.translatable("tooltip.weapoons.timeSword:Nshift"));
  }

  super.appendHoverText(stack, lvl, components, flag);
 }

 @Override
 public boolean hurtEnemy(ItemStack stack, LivingEntity pVictim, LivingEntity pAttacker) {
  if (pVictim instanceof Player) {
   Player player = (Player) pVictim;
   player.getPersistentData().putInt("freezeTime", 100);
  }
  pVictim.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200));
  pAttacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200));
  return super.hurtEnemy(stack, pVictim, pAttacker);
 }

 @SubscribeEvent
 public void onPlayerTick(TickEvent.PlayerTickEvent event) {
  Player player = event.player;
  int freezeTime = player.getPersistentData().getInt("freezeTime");
  if (freezeTime > 0) {
   player.setDeltaMovement(0, 0, 0);
   player.getPersistentData().putInt("freezeTime", freezeTime - 1);
  }
 }
}