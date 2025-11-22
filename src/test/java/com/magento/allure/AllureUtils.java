package com.magento.allure;

import com.magento.commons.GlobalConstants;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.Properties;

public class AllureUtils {
    public static final Path REPORT_FOLDER = Paths.get("reports");
    public static final Path ALLURE_RESULTS = REPORT_FOLDER.resolve("allure-results");
    public static final String ENVIRONMENT_FILE_NAME = "environment.properties";
    public static final Path ENVIRONMENT_FILE = ALLURE_RESULTS.resolve(ENVIRONMENT_FILE_NAME);

    public static void cleanResults() {
        deleteDirectoryContents(ALLURE_RESULTS);
    }

    private static void deleteDirectoryContents(Path path) {
        try {
            Files.createDirectories(path);
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path entry : directoryStream) {
                    deleteRecursively(entry);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to clean directory: " + path, e);
        }
    }

    private static void deleteRecursively(Path path) {
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path child : stream) {
                    deleteRecursively(child);
                }
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to delete directory: " + path, e);
            }
        }
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to delete file: " + path, e);
        }
    }

    public static void createEnvironmentFile() {
        try {
            Files.createDirectories(ENVIRONMENT_FILE.getParent());
            Properties properties = buildProperties();
            try (var outputStream = Files.newOutputStream(
                    ENVIRONMENT_FILE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            )) {
                properties.store(outputStream, "Allure Environment Properties");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties buildProperties() {
        Properties prop = new Properties();
        prop.setProperty("OS", GlobalConstants.OS_NAME);
        prop.setProperty("Java.Version", GlobalConstants.JAVA_VERSION);
        prop.setProperty("Server", GlobalConstants.SERVER);
        prop.setProperty("ProjectName", GlobalConstants.PROJECT_NAME);
        return prop;
    }
}
