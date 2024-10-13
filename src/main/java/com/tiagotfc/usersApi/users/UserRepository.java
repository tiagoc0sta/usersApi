package com.tiagotfc.usersApi.users;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    List<User> findAll() {
        return users;
    }

    //Optional = container object which may or may not contain a non-null value. This way we avoid error
    Optional<User> findById(Integer id) {
        return users.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void create(User run) {
        users.add(run);
    }

    void update(User user, Integer id) {
        Optional<User> existingRun = findById(id);
        if (existingRun.isPresent()) {
            users.set(users.indexOf(existingRun.get()), user);
        }
    }


    void delete (Integer id){
        users.removeIf(user -> user.id().equals(id));
    }

    @PostConstruct
    private void init() {
        users.add(new User(1,
                "ironman",
                "Tony",
                "Stark",
                "iron@gmail.com",
                "6479885550"));

        users.add(new User(2,
                "americanCaptain",
                "Steve",
                "Rogers",
                "stever@gmail.com",
                "9579885550"));

        users.add(new User(3,
                "hulk",
                "Bruce",
                "Banner",
                "bbanner@gmail.com",
                "8879885550"));
    }
}
