package com.bellotech.urlshortener.domain.models;

import java.io.Serializable;

/**
 * DTO for {@link com.bellotech.urlshortener.domain.entities.User}
 */
public record UserDto(Long id, String name) implements Serializable {
}