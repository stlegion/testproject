package com.mycompany.testproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс приложения.
 * Здесь основные инициализации зависимостей и запуск обработки файлов.
 */
public class Main {

    /**
     *
     * @param args массив, первый элемент которого должен быть путь до папки с файлами.
     */
    public static void main(String[] args) {
        if(args.length == 0) return;
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        ProfilesManager dbManager = context.getBean(ProfilesManager.class);
        dbManager.processProfiles(args[0]);
    }
}
