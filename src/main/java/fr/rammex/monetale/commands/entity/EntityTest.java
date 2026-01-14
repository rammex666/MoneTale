package fr.rammex.monetale.commands.entity;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.HytaleServer;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.Entity;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.inventory.Inventory;
import com.hypixel.hytale.server.core.inventory.ItemStack;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import fr.rammex.monetale.MoneTale;

import javax.annotation.Nonnull;
import java.util.logging.Level;

public class EntityTest extends AbstractPlayerCommand {
    EntityTest() {
        super("test", "test command");
    }

    @Override
    protected void execute(@Nonnull CommandContext context,
                               @Nonnull Store<EntityStore> store,
                               @Nonnull Ref<EntityStore> ref,
                               @Nonnull PlayerRef playerRef,
                               @Nonnull World world) {

        // Get the Player entity and inventory
        Player player = store.getComponent(ref, Player.getComponentType());
        if (player == null) {
            context.sendMessage(Message.translation("Error: Could not access player data."));
            return;
        }

        ItemStack customItem = new ItemStack("Ingredient_Poop");

        Inventory inventory = player.getInventory();

        inventory.getStorage().addItemStack(customItem);

        // Send updated inventory to client
        player.sendInventory();

        MoneTale.get().getLogger().at(Level.INFO).log("Give Item to %s",player.getDisplayName());

        /*
        TODO: Find how to spawn an entity
         */
    }
}
