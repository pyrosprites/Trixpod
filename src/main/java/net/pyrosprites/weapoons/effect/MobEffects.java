package net.pyrosprites.weapoons.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pyrosprites.weapoons.Weapoons;

public class MobEffects {
 public static final DeferredRegister<MobEffect> MOB_EFFECTS
         = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Weapoons.MOD_ID);

  public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
          () -> new freezeEffect(MobEffectCategory.HARMFUL, 7916284));

 public static final RegistryObject<MobEffect> PLAGUE = MOB_EFFECTS.register("plague",
         () -> new plagueEffect(MobEffectCategory.HARMFUL, 6434156));

 public static void register(IEventBus eventBus) {
  MOB_EFFECTS.register(eventBus);
 }
}
