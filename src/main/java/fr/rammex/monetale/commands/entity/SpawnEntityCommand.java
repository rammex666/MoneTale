package fr.rammex.monetale.commands.entity;

import com.hypixel.hytale.server.core.command.system.basecommands.AbstractCommandCollection;

public class SpawnEntityCommand extends AbstractCommandCollection {
    public SpawnEntityCommand() {
        super("spawnentity", "Spawn un pokemon !");

        // Add subcommands
        this.addSubCommand(new EntityTest());
    }
}
