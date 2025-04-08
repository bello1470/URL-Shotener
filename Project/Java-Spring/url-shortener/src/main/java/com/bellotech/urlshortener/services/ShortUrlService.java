package com.bellotech.urlshortener.services;

import com.bellotech.urlshortener.domain.entities.ShortUrl;
import com.bellotech.urlshortener.domain.models.ShortUrlDto;
import com.bellotech.urlshortener.domain.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;
    private final EntityMapper entityMapper;

    public ShortUrlService(ShortUrlRepository shortUrlRepository, EntityMapper entityMapper) {
        this.shortUrlRepository = shortUrlRepository;
        this.entityMapper = entityMapper;
    }

    public List<ShortUrlDto> findByPublicShortUrls () {
        return shortUrlRepository.findPublicShortUrls().stream().map(entityMapper::shortUrlDto).toList();
    }
}
