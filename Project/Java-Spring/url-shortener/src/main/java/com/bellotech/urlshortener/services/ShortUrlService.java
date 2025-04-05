package com.bellotech.urlshortener.services;

import com.bellotech.urlshortener.domain.entities.ShortUrl;
import com.bellotech.urlshortener.domain.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public List<ShortUrl> findByPublicShortUrls () {
        return shortUrlRepository.findPublicShortUrls();
    }
}
