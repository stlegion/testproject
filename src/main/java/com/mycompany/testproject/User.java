package com.mycompany.testproject;

import java.io.File;
import java.util.Date;

/**
 *
 * Класс для компактного хранения информации о пользователе.
 */
public class User {

    private final String name;
    private final String surname;
    private final Date birthdate;
    private final File profile;

    public User(String name, String surname, Date birthdate, File profile) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, surname, birthdate, profile);
    }

    public File getProfile() {
        return profile;
    }
    
}
