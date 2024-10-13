package com.tiagotfc.usersApi.users;

public record User(
        String username,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
