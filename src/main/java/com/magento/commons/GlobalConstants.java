package com.magento.commons;

public class GlobalConstants {

    // 1. System Info
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // 2. Environment Config
    public static final String SERVER = System.getProperty("server", "live");
    public static final String PROJECT_NAME = "Magento";

    // 3. TIMEOUT
    public static final long LONG_TIMEOUT = 10;


}
