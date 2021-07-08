package com.badges.APIBadges.web.controller;

import com.badges.APIBadges.domain.BadgeDomain;
import com.badges.APIBadges.domain.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    public List<BadgeDomain> getAll() {
        return badgeService.getAll();
    }

    public Optional<BadgeDomain> getBadgeDomain(int badgeDomainId){
        return badgeService.getBadge(badgeDomainId);
    }

    public BadgeDomain save (BadgeDomain badgeDomain){
        return badgeService.save(badgeDomain);
    }

    public boolean delete (int badgeId){
        return badgeService.delete(badgeId);
    }
}

