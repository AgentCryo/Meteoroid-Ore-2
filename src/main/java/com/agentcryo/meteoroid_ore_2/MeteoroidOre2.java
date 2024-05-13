package com.agentcryo.meteoroid_ore_2;
import com.agentcryo.meteoroid_ore_2.modBlocks.ModBlocks;
import com.agentcryo.meteoroid_ore_2.modItems.ModItems;
import net.fabricmc.api.ModInitializer;
    public class MeteoroidOre2 implements ModInitializer {
        @Override
        public void onInitialize() {
            ModBlocks.initialize();
            ModItems.initialize();
        }
}
