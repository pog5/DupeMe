package org.nightlyeu.dupeme;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

public final class DupeMeFabricClient implements ClientModInitializer {
    private static final KeyMapping DUPE_KEY = KeyMappingHelper.registerKeyMapping(
        new KeyMapping("key.dupeme.keybind", InputConstants.Type.KEYSYM,
            InputConstants.KEY_ADD,
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath(DupeMe.MOD_ID, "keys"))));

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(DupeMeFabricClient::tick);
    }

    private static void tick(Minecraft client) {
        if (DUPE_KEY.consumeClick() && client.player != null) {
            client.player.connection.sendCommand("dupe");
        }
    }
}
