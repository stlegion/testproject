package com.mycompany.testproject;

import java.io.File;
import java.util.Date;

/**
 *
 * Класс с фабричным методом для получения экземпляров пользователя.
 */
public class UserCreator {
    public User create(String name, String surname, Date birthDate, File profile){
        return new User(name, surname, birthDate, profile);
    }
}
