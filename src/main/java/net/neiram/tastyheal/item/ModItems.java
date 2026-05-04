package net.neiram.tastyheal.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;
import net.neiram.tastyheal.TastyHeal;

import java.util.function.Function;

public class ModItems {
    // ajout de la soupe brillante
    public static final Item GLISTERING_BEETROOT_SOUP = registerItem(
            "glistering_beetroot_soup",
            settings -> new Item(settings
                    .maxCount(1)
                    .food(
                            ModFoodComponents.GLISTERING_BEETROOT_SOUP,
                            ModFoodComponents.GLISTERING_BEETROOT_SOUP_CONSUMABLE
                    )
                    .useRemainder(Items.BOWL)
            )
    );
    //ajout de la pomme au miel
    public static final Item HONEYED_APPLE = registerItem(
            "honeyed_apple",
            settings -> new Item(settings
                    .maxCount(64)
                    .food(
                            ModFoodComponents.HONEYED_APPLE,
                            ModFoodComponents.HONEYED_APPLE_CONSUMABLE
                    ))
    );
    //ajout de la pomme de notch
    public static final Item NOTCHED_APPLE = registerItem(
            "notched_apple",
            settings -> new Item(settings
                    .maxCount(1)
                    .food(
                            ModFoodComponents.NOTCHED_APPLE,
                            ModFoodComponents.NOTCHED_APPLE_CONSUMABLE
                    )
                    .rarity(Rarity.RARE))
    );

    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory) {
        RegistryKey<Item> itemKey = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(TastyHeal.MOD_ID, name)
        );

        Item item = itemFactory.apply(new Item.Settings().registryKey(itemKey));

        return Registry.register(Registries.ITEM, itemKey, item);
    }

// ajout au mode créatif dans les onglets
    public static void registerModItems() {
        TastyHeal.LOGGER.info("Registering Mod Items for " + TastyHeal.MOD_ID);
// onglet food and drink
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(GLISTERING_BEETROOT_SOUP);
            entries.add(HONEYED_APPLE);
            entries.add(NOTCHED_APPLE);
        });
    }
}
