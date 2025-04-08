package com.bellotech.urlshortener.services;

import com.bellotech.urlshortener.domain.entities.ShortUrl;
import com.bellotech.urlshortener.domain.entities.User;
import com.bellotech.urlshortener.domain.models.ShortUrlDto;
import com.bellotech.urlshortener.domain.models.UserDto;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public ShortUrlDto shortUrlDto(ShortUrl shortUrl) {

        UserDto userDto = null;
        if (shortUrl.getCreatedBy() != null) {

            userDto = toUserDto(shortUrl.getCreatedBy());

        }
        return new ShortUrlDto(
                shortUrl.getId(),
                shortUrl.getShortKey(),
                shortUrl.getOriginalUrl(),
                shortUrl.getIsPrivate(),
                shortUrl.getExpiresAt(),
                userDto,
                shortUrl.getClickCount(),
                shortUrl.getCreatedAt()
        );
    }

    public UserDto  toUserDto(User user) {

        return new UserDto(user.getId(),user.getName());
    }
}
