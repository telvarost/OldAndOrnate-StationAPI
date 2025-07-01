package com.github.telvarost.oldandornate;

import java.util.Random;

public class ModHelperElementalCreepers {
    public static String getRandomEntity(Random random) {
        int var2 = random.nextInt(8);

        if (var2 == 0) {
            return "Creeper";
        } else if (var2 == 1) {
            return "EarthCreeper";
        } else if (var2 == 2) {
            return "ElectricCreeper";
        } else if (var2 == 3) {
            return "FireCreeper";
        } else if (var2 == 4) {
            return "GhostCreeper";
        } else if (var2 == 5) {
            return "MagmaCreeper";
        } else if (var2 == 6) {
            return "PsychicCreeper";
        } else if (var2 == 7) {
            return "WaterCreeper";
        } else {
            return "Creeper";
        }
    }
}
