package io.telconet.app.config;

import java.io.*;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 13/10/2021
 */
@Configuration
@Log4j2
public class Log4j2Load {

    private String log4j2DirectoryFile="/app/config/log4j2.xml";

    @Bean
    public String logConfig(){

        String loggerConfig = log4j2DirectoryFile;
        LoggerContext context = LoggerContext.getContext(false);

        File file = new File(loggerConfig);
        log.info("Loading configuration log4j2..");
        context.setConfigLocation(file.toURI());
        log.info("Loaded configuration log4j2 succesfully");
        return "OK";
    }
}
