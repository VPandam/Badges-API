package com.badges.APIBadges.domain.service;

import com.badges.APIBadges.domain.BadgeDomain;
import com.badges.APIBadges.domain.repository.BadgeDomainRepository;
import com.badges.APIBadges.persistence.entity.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {

    @Autowired
    private BadgeDomainRepository badgeDomainRepository;

    public List<BadgeDomain> getAll() {
        return badgeDomainRepository.getAll();
    }

    public Optional<BadgeDomain> getBadge(int badgeId) {
        return badgeDomainRepository.getById(badgeId);
    }

    public BadgeDomain save(BadgeDomain badgeDomain) {
        return badgeDomainRepository.save(badgeDomain);
    }

    public boolean delete (int badgeId){
        return getBadge(badgeId).map(badge -> {
                badgeDomainRepository.delete(badgeId);
                return true;
        }).orElse(false);

    }

}
