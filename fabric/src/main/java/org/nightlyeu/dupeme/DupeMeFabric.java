package org.nightlyeu.dupeme;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DupeMeFabric implements ModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DupeMe.MOD_ID);

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, context, selection) ->
            DupeMe.register(dispatcher, context));
        LOGGER.info("DupeMe: Server ready!");
    }
}
