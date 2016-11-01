package com.mycompany.testproject;

import java.util.Arrays;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        if(args.length == 0) return;
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        ProfilesManager dbManager = context.getBean(ProfilesManager.class);
        dbManager.processProfiles(args[0]);
    }
}
