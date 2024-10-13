package com.tiagotfc.usersApi.users;

public record User(
        Integer id,
        String username,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
