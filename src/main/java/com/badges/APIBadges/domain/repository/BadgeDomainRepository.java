package com.badges.APIBadges.domain.repository;

import com.badges.APIBadges.domain.BadgeDomain;
import com.badges.APIBadges.persistence.entity.Badge;

import java.util.List;
import java.util.Optional;

public interface BadgeDomainRepository {
    List<BadgeDomain> getAll();
    Optional<BadgeDomain> getById(int id);
    BadgeDomain save(BadgeDomain badge);
    void delete (int idBadge);
}
