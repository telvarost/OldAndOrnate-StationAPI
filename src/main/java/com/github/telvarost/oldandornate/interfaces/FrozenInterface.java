package com.github.telvarost.oldandornate.interfaces;

import net.modificationstation.stationapi.api.util.Util;

public interface FrozenInterface {
    default int oldAndOrnate_getFrozenTicks() {
        return Util.assertImpl();
    }

    default void oldAndOrnate_setFrozenTicks(int frozenTicks) {
        Util.assertImpl();
    }
}
