package com.github.projectdiscordbot.configuration;

import lombok.val;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.*;

/**
 * Configuration Factory Loader
 */
public class ConfigurationManager {
    private static final String DEFAULT_CONFIG = "config.yml";

    private Yaml yaml = new Yaml();

    /**
     * Load default configuration from an internal resource file
     *
     * @return Configuration from resource
     */
    public Configuration loadDefault() throws IOException {
        try (val inputStream = getClass().getClassLoader().getResourceAsStream(DEFAULT_CONFIG)) {
            return yaml.loadAs(inputStream, Configuration.class);
        }
    }

    /**
     * Load configuration from file with default name
     *
     * @return Loaded configuration
     */
    public Configuration load() throws IOException {
        return load(DEFAULT_CONFIG);
    }

    /**
     * Load configuration from selected file name
     *
     * @param fileName Relative file name to load
     * @return Loaded configuration
     */
    public Configuration load(String fileName) throws IOException {
        try (val fileReader = new FileReader(fileName)) {
            try (val bufferedReader = new BufferedReader(fileReader)) {
                return yaml.loadAs(bufferedReader, Configuration.class);
            }
        }
    }

    /**
     * Load configuration from file or use {@link ConfigurationManager#loadDefault()} as fail-back
     * Also writes the default file to disk
     *
     * @return Loaded configuration
     */
    public Configuration loadOrDefault() throws IOException {
        try {
            return load(DEFAULT_CONFIG);
        } catch (IOException e) {
            val config = loadDefault();

            write(config);
            return config;
        }
    }

    /**
     * Write configuration to file with default name
     *
     * @param configuration configuration to write
     */
    public void write(Configuration configuration) throws IOException {
        write(configuration, DEFAULT_CONFIG);
    }

    /**
     * Write configuration to file with selected name
     *
     * @param configuration configuration to write
     * @param fileName Relative name of the file
     */
    public void write(Configuration configuration, String fileName) throws IOException {
        try (val fileWriter = new FileWriter(fileName)) {
            fileWriter.write(yaml.dumpAsMap(configuration));
        }
    }
}
