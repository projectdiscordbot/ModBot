package com.github.projectdiscordbot.database.models;

import dev.morphia.annotations.Entity;
import lombok.Data;

@Entity("guild_enabled_modules")
@Data
public class GuildEnabledModules {
    private boolean moderation;
    private boolean music;
}
