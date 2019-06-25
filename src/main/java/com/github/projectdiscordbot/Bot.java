package com.github.projectdiscordbot;

import com.github.projectdiscordbot.configuration.Configuration;
import com.github.projectdiscordbot.database.DatabaseFactory;
import com.github.projectdiscordbot.listeners.MessageListener;
import dev.morphia.Datastore;
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
public class Bot {
    private Configuration configuration;
    private static Bot instance;
    private Datastore datastore;

    public Bot(Configuration configuration) {
        this.configuration = configuration;

        instance = this;
    }

    /**
     * Connect bot to database and Discord gateway
     */
    public void connect() throws LoginException {
        connectDatabase();
        connectDiscord();
    }

    /**
     * Connect to MongoDB database
     */
    private void connectDatabase() {
        datastore = DatabaseFactory.getInstance(configuration);
    }

    /**
     * Connect to Discord API gateway
     *
     * @throws LoginException if login failed, possibly due to an invalid token, or a network error.
     */
    private void connectDiscord() throws LoginException {
        val builder = new DefaultShardManagerBuilder();

        builder.setToken(getConfiguration().getAccessToken());
        builder.addEventListeners(new MessageListener());
        builder.build();
    }
}
