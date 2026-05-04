package net.neiram.tastyheal.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.stat.Stat;

public class ModFoodComponents {
    // ici on gère la faim
    public static final FoodComponent GLISTERING_BEETROOT_SOUP = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .build();
    public static final FoodComponent HONEYED_APPLE = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.42f)
            .build();
    public static final FoodComponent NOTCHED_APPLE = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .build();

//   ici on gère les effets supplémentaires (potion-like)
    public static final ConsumableComponent GLISTERING_BEETROOT_SOUP_CONSUMABLE = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0),
                    1.0f
            ))
            .build();
    public static final ConsumableComponent HONEYED_APPLE_CONSUMABLE = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.SPEED, 600, 2), 1.0f
            ))
            .build();
    public static final ConsumableComponent NOTCHED_APPLE_CONSUMABLE = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 100, 2), 1.0f
            ))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.SPEED, 600, 2), 1.0f
            ))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0), 1.0f
            ))
            .build();

}