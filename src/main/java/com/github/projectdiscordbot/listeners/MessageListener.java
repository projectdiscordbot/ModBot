package com.github.projectdiscordbot.listeners;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

@Slf4j
public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            log.info("[PM] {}: {}",
                    event.getAuthor().getName(),
                    event.getMessage().getContentDisplay()
            );
            return;
        }

        log.info("[{}][{}] {}: {}",
                event.getGuild().getName(),
                event.getTextChannel().getName(),
                Objects.requireNonNull(event.getMember()).getEffectiveName(),
                event.getMessage().getContentDisplay()
        );
    }
}
