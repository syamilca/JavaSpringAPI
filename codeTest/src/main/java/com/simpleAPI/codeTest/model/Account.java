package com.simpleAPI.codeTest.model;

import org.springframework.data.annotation.Id;

public record Account(
        @Id
        Integer id,
        String username,
        String password
) {
}
