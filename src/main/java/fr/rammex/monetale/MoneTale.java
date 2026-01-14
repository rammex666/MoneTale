package fr.rammex.monetale;

import fr.rammex.monetale.commands.entity.SpawnEntityCommand;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;
import java.util.logging.Level;

/**
 * Main plugin class.
 *
 * TODO: Create Pokemon Style Plugin.
 *
 * @author .rammex
 * @version 1.0.0
 */
@SuppressWarnings({"null", "removal"})
public class MoneTale extends JavaPlugin {

    private static MoneTale instance;

    public MoneTale(@Nonnull JavaPluginInit init) {
        super(init);
    }

    public static MoneTale get() {
        return instance;
    }

    @Override
    protected void setup() {
        instance = this;

        // Register commands
        getCommandRegistry().registerCommand(new SpawnEntityCommand());

        getLogger().at(Level.INFO).log("MoneTale setup complete!");
    }

    @Override
    protected void start() {
        getLogger().at(Level.INFO).log("MoneTale started!");
    }

    @Override
    protected void shutdown() {
        getLogger().at(Level.INFO).log("MoneTale shutting down!");
    }
}