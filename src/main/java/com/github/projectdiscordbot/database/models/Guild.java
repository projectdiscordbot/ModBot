package com.github.projectdiscordbot.database.models;

import com.github.projectdiscordbot.database.models.guild.GuildEnabledModules;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Reference;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Entity("guild")
@Data
public class Guild {
    @Id
    private ObjectId id;

    @Reference
    private List<User> users;

    @Embedded
    private GuildEnabledModules enabledModules;
}
