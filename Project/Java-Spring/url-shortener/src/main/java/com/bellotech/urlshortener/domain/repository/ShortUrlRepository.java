package com.bellotech.urlshortener.domain.repository;

import com.bellotech.urlshortener.domain.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
   @Query(
           "select su from ShortUrl su left join fetch su.createdBy where su.isPrivate = false order by su.createdAt desc "
   )
    List<ShortUrl> findPublicShortUrls();
}
