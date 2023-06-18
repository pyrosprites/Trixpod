package net.pyrosprites.weapoons.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pyrosprites.weapoons.Weapoons;
import net.pyrosprites.weapoons.item.custom.plagueSword;
import net.pyrosprites.weapoons.item.custom.timeSword;

public class modItems {
 public static final DeferredRegister<Item> ITEMS =
         DeferredRegister.create(ForgeRegistries.ITEMS, Weapoons.MOD_ID);

 public static final RegistryObject<Item> CARBON_ALLOY = ITEMS.register("carbon_alloy",
         () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
public static final RegistryObject<Item> PLAGUE_SWORD = ITEMS.register("plague_sword",
         () -> new plagueSword(ModTiers.WEAPOONS, 2, 3f,
                 new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
 public static final RegistryObject<Item> TIME_SWORD = ITEMS.register("time_sword",
         () -> new timeSword(ModTiers.WEAPOONS, 2, 3f,
                 new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

 public static void register(IEventBus eventBus) {
  ITEMS.register(eventBus);
 }

}
