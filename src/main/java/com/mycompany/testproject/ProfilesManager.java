package com.mycompany.testproject;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfilesManager {

    @Autowired
    private DbManager dbManager;
    
    @Autowired
    private IProfileParser profileParser;

    public void processProfiles(String dirPath) {
        File profilesDir = new File(dirPath);
        if (!profilesDir.exists()) {
            return;
        }

        Arrays.stream(profilesDir.listFiles())
                .parallel()
                .forEach(f -> {

                    Optional.ofNullable(profileParser.parse(f))
                            .ifPresent(u -> {
                                dbManager.persistUser(u);
                            });

                });
    }
}
