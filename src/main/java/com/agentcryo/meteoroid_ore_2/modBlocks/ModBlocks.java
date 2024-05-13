package com.agentcryo.meteoroid_ore_2.modBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static <T extends Block> T register(T block, String name, boolean shouldRegisterItem) {
        Identifier id = new Identifier("meteoroid_ore_2", name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Block METEORITE_BLOCK = register(
            new Block(
                    AbstractBlock.Settings
                            .copy(Blocks.DEEPSLATE)
                            .hardness(5f)),
            "meteorite_block", true
    );

    public static final Block METEOROID_ORE = register(
            new Block(
                    AbstractBlock.Settings
                            .copy(Blocks.DEEPSLATE)
                            .hardness(4f)),
            "meteoroid_ore", true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> itemGroup.add(ModBlocks.METEORITE_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> itemGroup.add(ModBlocks.METEOROID_ORE));
    }
}