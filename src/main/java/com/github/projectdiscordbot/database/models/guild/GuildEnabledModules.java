package com.github.projectdiscordbot.database.models.guild;

import dev.morphia.annotations.Embedded;
import lombok.Data;

@Embedded
@Data
public class GuildEnabledModules {
    private boolean moderation;
    private boolean music;
}
