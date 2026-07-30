package org.nightlyeu.dupeme;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public final class DupeMe {
    public static final String MOD_ID = "dupeme";
    private static final int MAX_AMOUNT = 2500;

    private DupeMe() {}

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher,
                                CommandBuildContext context) {
        dispatcher.register(Commands.literal("dupe")
            .executes(DupeMe::execute)
            .then(Commands.argument("count", IntegerArgumentType.integer(1))
                .executes(DupeMe::execute)));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        if (player == null) return 0;

        int amount;
        try {
            amount = IntegerArgumentType.getInteger(context, "count");
        } catch (IllegalArgumentException ignored) {
            amount = 1;
        }
        amount = Math.min(amount, MAX_AMOUNT);
        ItemStack item = player.getMainHandItem();
        for (int i = 0; i < amount; i++) player.addItem(item.copy());
        return 1;
    }
}
