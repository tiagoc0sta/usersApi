package com.tiagotfc.usersApi.model;

public record User(
        Integer id,
        String userName,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
