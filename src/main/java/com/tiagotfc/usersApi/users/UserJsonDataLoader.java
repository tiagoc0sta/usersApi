package com.tiagotfc.usersApi.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class UserJsonDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserJsonDataLoader(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/users.json")) {
                UsersRecord allUsers = objectMapper.readValue(inputStream, UsersRecord.class);
                System.out.println("Reading " + allUsers.users().size() + " users from JSON data and saving to a database.");
                userRepository.saveAll(allUsers.users());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            System.out.println("Not loading Users from JSON data because the collection contains data.");
        }
    }
}
