package com.mycompany.testproject;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Класс определяющий функционал парсинга имени файла.
 */
public class ProfileParser implements IProfileParser{
    
    @Autowired
    private UserCreator userCreator;

    /**
     *
     * @param profile файл с профилем пользователя. Имя файла должно следовать определенному формату: <b>имя фамилия дд_мм_гг</b>
     * @return объект с полученными данными о пользователе
     */
    @Override
    public User parse(File profile) {
            String fileName = profile.getName();
            User user = null;
        try {
            String[] userData = fileName.split(" ");
            if(userData.length != 3) return user;
            DateFormat format = new SimpleDateFormat("dd_MM_yy");
            Date birthDate = format.parse(userData[2]);
            String name = userData[0];
            String surname = userData[1];
            user = userCreator.create(name, surname, birthDate, profile);
            return user;
        } catch (ParseException ex) {
            return user;
        }
    }
    
}
