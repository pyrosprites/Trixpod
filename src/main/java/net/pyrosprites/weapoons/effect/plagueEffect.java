package net.pyrosprites.weapoons.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class plagueEffect extends MobEffect {
 public plagueEffect(MobEffectCategory mobEffectCategory, int color) {
  super(mobEffectCategory, color);
 }

 @Override
 public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
  if (!pLivingEntity.level.isClientSide()) {
   if (pLivingEntity instanceof Player) {
    Player player = (Player) pLivingEntity;
    player.getFoodData().eat(-1, 0.0F);
    player.hurt(DamageSource.WITHER, 0.75F);
    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200));
   }
  }
  super.applyEffectTick(pLivingEntity, pAmplifier);
 }

 @Override
 public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
  int k = 40 >> pAmplifier;
  if (k > 0) {
   return pDuration % k == 0;
  } else {
   return true;
  }
 }
}
