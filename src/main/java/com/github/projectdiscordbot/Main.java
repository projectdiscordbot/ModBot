package com.github.projectdiscordbot;

import com.github.projectdiscordbot.configuration.ConfigurationManager;
import lombok.val;

public class Main {
    public static void main(String[] args) throws Exception {
        val configurationManager = new ConfigurationManager();
        val configuration = configurationManager.loadOrDefault();

        val bot = new Bot(configuration);
        bot.connect();
    }
}
