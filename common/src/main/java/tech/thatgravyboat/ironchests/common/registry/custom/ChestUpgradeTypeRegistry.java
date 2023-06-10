package tech.thatgravyboat.ironchests.common.registry.custom;

import tech.thatgravyboat.ironchests.api.IUpgradeRegistry;
import tech.thatgravyboat.ironchests.api.chesttype.ChestBlockType;
import tech.thatgravyboat.ironchests.api.chesttype.ChestUpgradeType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChestUpgradeTypeRegistry implements IUpgradeRegistry {

    public static final ChestUpgradeTypeRegistry INSTANCE = new ChestUpgradeTypeRegistry();

    private final Set<ChestUpgradeType> UPGRADES = new HashSet<>();

    private ChestUpgradeTypeRegistry() {}

    @Override
    public Set<ChestUpgradeType> getUpgrades() {
        return Collections.unmodifiableSet(UPGRADES);
    }

    @Override
    public void register(ChestUpgradeType type) {
        if (type.to().blockType() != ChestBlockType.CHEST) {
            throw new IllegalArgumentException("Chest Upgrade Type must be for a chest.");
        }
        if (type.from() != null && type.from().blockType() != ChestBlockType.CHEST) {
            throw new IllegalArgumentException("Chest Upgrade Type must be for a chest.");
        }
        UPGRADES.add(type);
    }
}
