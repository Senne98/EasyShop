package io.papermc.paper.configuration;

import org.spongepowered.configurate.NodePath;

import static org.spongepowered.configurate.NodePath.path;

interface RemovedConfigurations {

    NodePath[] REMOVED_WORLD_PATHS = {
        path("elytra-hit-wall-damage"),
        path("queue-light-updates"),
        path("save-queue-limit-for-auto-save"),
        path("max-chunk-sends-per-tick"),
        path("max-chunk-gens-per-tick"),
        path("fire-physics-event-for-redstone"),
        path("fix-zero-tick-instant-grow-farms"),
        path("bed-search-radius"),
        path("lightning-strike-distance-limit"),
        path("fix-wither-targeting-bug"),
        path("remove-corrupt-tile-entities"),
        path("allow-undead-horse-leashing"),
        path("reset-arrow-despawn-timer-on-fall"),
        path("seed-based-feature-search"),
        path("seed-based-feature-search-loads-chunks"),
        path("viewdistances.no-tick-view-distance"),
        path("seed-based-feature-search"), // unneeded as of 1.18
        path("seed-based-feature-search-loads-chunks"), // unneeded as of 1.18
        path("reset-arrow-despawn-timer-on-fall"),
        path("squid-spawn-height"),
        path("viewdistances"),
        path("use-alternate-fallingblock-onGround-detection"),
        path("skip-entity-ticking-in-chunks-scheduled-for-unload"),
        path("tracker-update-distance"),
        path("allow-block-location-tab-completion"),
        path("cache-chunk-maps"),
        path("disable-mood-sounds"),
        path("fix-cannons"),
        path("player-blocking-damage-multiplier"),
        path("remove-invalid-mob-spawner-tile-entities"),
        path("use-hopper-check"),
        path("use-async-lighting"),
        path("tnt-explosion-volume"),
        path("entities", "spawning", "despawn-ranges", "soft"),
        path("entities", "spawning", "despawn-ranges", "hard")
    };

    NodePath[] REMOVED_GLOBAL_PATHS = {
        path("queue-light-updates-max-loss"),
        path("sleep-between-chunk-saves"),
        path("remove-invalid-statistics"),
        path("min-chunk-load-threads"),
        path("use-versioned-world"),
        path("save-player-data"), // to spigot (converted)
        path("log-named-entity-deaths"), // default in vanilla
        path("chunk-tasks-per-tick"), // removed in tuinity merge
        path("item-validation", "loc-name"),
        path("commandErrorMessage"),
        path("baby-zombie-movement-speed"),
        path("limit-player-interactions"),
        path("warnWhenSettingExcessiveVelocity"),
        path("logging", "use-rgb-for-named-text-colors")
    };

}
