package com.github.projectdiscordbot.database;

import com.github.projectdiscordbot.configuration.Configuration;
import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import lombok.val;

public class DatabaseFactory {
    public static Datastore getInstance(Configuration configuration) {
        val morphia = new Morphia();

        // tell Morphia where to find your classes
        morphia.mapPackage("com.github.projectdiscordbot.database.models");

        val datastore = morphia.createDatastore(new MongoClient(configuration.getDatabaseUrl()), "bot");
        datastore.ensureIndexes();

        return datastore;
    }
}
