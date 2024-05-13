package com.agentcryo.meteoroid_ore_2;

import com.agentcryo.meteoroid_ore_2.modItems.ModItems;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    REFINED_METEOROID(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,5, 1400, 5f, 4.5f, 30, () -> Ingredient.ofItems(ModItems.REFINED_METEOROID_ORE)),
    METEOROID(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,3, 800, 3f, 3, 26, () -> Ingredient.ofItems(ModItems.RAW_METEOROID_ORE));

    private final TagKey<Block> inverseTag;
    private final int miningLevel;
    private final int itemDurablility;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantablility;
    private final Supplier<Ingredient> repairMaterial;

    ModToolMaterial(final TagKey inverseTag, int miningLevel, int itemDurablility, float miningSpeed, float attackDamage, int enchantablility, Supplier<Ingredient> repairMaterial) {
        this.inverseTag = inverseTag;
        this.miningLevel = miningLevel;
        this.itemDurablility = itemDurablility;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantablility = enchantablility;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability() {
        return this.itemDurablility;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantablility;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
