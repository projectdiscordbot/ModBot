package com.github.projectdiscordbot.database.models;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.Data;
import org.bson.types.ObjectId;

@Entity("guild")
@Data
public class Guild {
    @Id
    private ObjectId id;
}
