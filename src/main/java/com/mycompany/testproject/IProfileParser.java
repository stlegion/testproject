package com.mycompany.testproject;

import java.io.File;

/**
 *
 * Общий интерфейс для логики парсинга имени файла с профилем пользователя.
 */
public interface IProfileParser {
    public User parse(File profile);
}
