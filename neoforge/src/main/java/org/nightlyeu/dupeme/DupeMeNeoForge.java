package org.nightlyeu.dupeme;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod(DupeMe.MOD_ID)
public final class DupeMeNeoForge {
    public DupeMeNeoForge() {
        NeoForge.EVENT_BUS.addListener((RegisterCommandsEvent event) ->
            DupeMe.register(event.getDispatcher(), event.getBuildContext()));
    }
}
