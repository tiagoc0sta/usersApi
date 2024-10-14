package com.tiagotfc.usersApi.users;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcClient jdbcClient;

    public UserRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<User> findAll() {
        return jdbcClient.sql("select * from UsersList")
                .query(User.class)
                .list();
    }


    public Optional<User> findById(Integer id) {
        return jdbcClient.sql("SELECT id,user_name, first_name, last_name, email, phone FROM UsersList WHERE id = :id" )
                .param("id", id)
                .query(User.class)
                .optional();
    }

    public void create(User user) {
        var updated = jdbcClient.sql("INSERT INTO UsersList(id, user_name, first_name, last_name, email, phone) values(?,?,?,?,?,?)")
                .params(List.of(user.id(),user.userName(),user.firstName(),user.lastName(),user.email(),user.phone().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create user " + user.userName());
    }

    public void update(User user, Integer id) {
        var updated = jdbcClient.sql("update UsersList set user_name = ?, first_name = ?, last_name = ?, email = ?, phone = ? where id = ?")
                .params(List.of(user.userName(),user.firstName(),user.lastName(),user.email(),user.phone().toString(), id))
                .update();

        Assert.state(updated == 1, "Failed to update UsersList " + user.userName());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from UsersList where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete user " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from UsersList").query().listOfRows().size();
    }

    public void saveAll(List<User> users) {
        users.stream().forEach(this::create);
    }

//    public List<User> findByLocation(String location) {
//        return jdbcClient.sql("select * from UsersList where location = :location")
//                .param("location", location)
//                .query(Run.class)
//                .list();
//    }

}
