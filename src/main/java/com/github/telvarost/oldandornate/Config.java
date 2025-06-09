package com.github.telvarost.oldandornate;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "OldAndOrnate")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigEntry(
                name = "Bows Have Durability",
                description = "Restart required for changes to take effect",
                multiplayerSynced = true
        )
        public Boolean bowsHaveDurability = false;
    }
}
