package com.agentcryo.meteoroid_ore_2.modItems;

import com.agentcryo.meteoroid_ore_2.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static <T extends Item> T register(T item, String ID) {
        Identifier itemID = new Identifier("meteoroid_ore_2", ID);

        T registeredItem = Registry.register(Registries.ITEM, itemID, item);

        return registeredItem;
    }

    public static final Item RAW_METEOROID_ORE = register(
            new Item(new Item.Settings()), "raw_meteoroid_ore"
    );

    public static final Item REFINED_METEOROID_ORE = register(
            new Item(new Item.Settings()), "refined_meteoroid_ore"
    );

    public static final Item METEOROID_PICKAXE = register(
            new PickaxeItem(ModToolMaterial.METEOROID, new Item.Settings()), "meteoroid_pickaxe"
    );

    public static final Item REFINED_METEOROID_PICKAXE = register(
            new PickaxeItem(ModToolMaterial.REFINED_METEOROID, new Item.Settings()), "refined_meteoroid_pickaxe"
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.RAW_METEOROID_ORE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.REFINED_METEOROID_ORE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.REFINED_METEOROID_PICKAXE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.METEOROID_PICKAXE));
    }
}