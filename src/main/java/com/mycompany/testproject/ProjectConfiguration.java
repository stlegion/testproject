package com.mycompany.testproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * Класс с настройкой IOC. Импортирует доп. настройки из xml-config.xml
 */
@Configuration
@ImportResource("classpath:/xml-config.xml")
public class ProjectConfiguration {

    @Bean
    DbManager createDbManager() {
        return new DbManager();
    }
    
    @Bean
    ProfilesManager createProfilesManager() {
        return new ProfilesManager();
    }
    
    @Bean
    ProfileParser createFilenameParser() {
        return new ProfileParser();
    }
    
    @Bean
    UserCreator createUserCreator() {
        return new UserCreator();
    }

}
