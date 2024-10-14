package com.tiagotfc.usersApi.users;

public record User(
        Integer id,
        String userName,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
