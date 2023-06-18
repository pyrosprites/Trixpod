package net.pyrosprites.weapoons.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.pyrosprites.weapoons.effect.MobEffects;
import net.pyrosprites.weapoons.effect.plagueEffect;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class plagueSword extends SwordItem {
 public plagueSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
  super(p_43269_, p_43270_, p_43271_, p_43272_);
 }

 @Override
 public void appendHoverText(ItemStack stack, @Nullable Level lvl, List<Component> components, TooltipFlag flag) {

  if(Screen.hasShiftDown()) {
   components.add(Component.translatable("tooltip.weapoons.plagueSword:Yshift"));
  } else {
   components.add(Component.translatable("tooltip.weapoons.plagueSword:Nshift"));
  }

  super.appendHoverText(stack, lvl, components, flag);
 }

 @Override
 public boolean hurtEnemy(ItemStack stack, LivingEntity pEntity, LivingEntity pAttacker) {
  pEntity.addEffect(new MobEffectInstance(new plagueEffect(MobEffectCategory.HARMFUL, 0), 200), pAttacker);
  return super.hurtEnemy(stack, pEntity, pAttacker);
 }
}
