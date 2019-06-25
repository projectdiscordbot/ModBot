package com.github.projectdiscordbot.database.models;

import dev.morphia.annotations.*;
import lombok.Data;
import org.bson.types.ObjectId;

@Entity("user")
@Indexes(
        @Index(fields = {
                @Field("discordId"),
                @Field("username"),
        })
)
@Data
public class User {
    @Id
    private ObjectId id;

    private String discordId;
    private String username;
    private String discriminator;
    private String avatar;

    private boolean bot;
}
