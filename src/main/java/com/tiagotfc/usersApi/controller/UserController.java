package com.tiagotfc.usersApi.controller;


import com.tiagotfc.usersApi.model.User;
import com.tiagotfc.usersApi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET (read in CRUD)
    @GetMapping("")
    List<User> findAll() {
        return userRepository.findAll();
    }


    //GET (read by ID in CRUD)
    @GetMapping("/{id}")
    //@PathVariable to reach the current id typed by user
    User findById(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return  user.get();
    }

    //POST - (Create in CRUD)
    @ResponseStatus(HttpStatus.CREATED)  //Informs that run was created
    @PostMapping("")
    void create(@RequestBody User user) {  //pass a body in a form of request
        userRepository.create(user);
    }

    // PUT (Update),
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody User user, @PathVariable Integer id) {
        userRepository.update(user,id);
    }


    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        userRepository.delete(id);
    }
}
