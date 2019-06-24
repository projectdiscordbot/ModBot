package com.github.projectdiscordbot;

import com.github.projectdiscordbot.configuration.Configuration;
import com.github.projectdiscordbot.listeners.MessageListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

import javax.security.auth.login.LoginException;

/**
 * Main Bot abstraction class.
 *
 * @author KernelFreeze
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class Bot {
    private Configuration configuration;

    /**
     * Connect to Discord API gateway
     *
     * @throws LoginException if login failed, possibly due to an invalid token, or a network error.
     */
    public void connect() throws LoginException {
        val builder = new DefaultShardManagerBuilder();

        builder.setToken(getConfiguration().getAccessToken());
        builder.addEventListeners(new MessageListener());
        builder.build();
    }
}
