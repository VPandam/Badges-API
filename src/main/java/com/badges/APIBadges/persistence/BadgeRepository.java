package com.badges.APIBadges.persistence;

import com.badges.APIBadges.domain.BadgeDomain;
import com.badges.APIBadges.domain.repository.BadgeDomainRepository;
import com.badges.APIBadges.persistence.crud.BadgeCrudRepository;
import com.badges.APIBadges.persistence.entity.Badge;
import com.badges.APIBadges.persistence.mapper.BadgeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BadgeRepository implements BadgeDomainRepository {

    @Autowired
    private BadgeCrudRepository badgeCrudRepository;

    @Autowired
    private BadgeMapper mapper;

    public List<BadgeDomain> getAll(){
        List<Badge> badges = (List<Badge>) badgeCrudRepository.findAll();
        return mapper.toBadgesDomain(badges);
    }

    public Optional<BadgeDomain> getById(int id){

        return badgeCrudRepository.findById(id).map(badge -> mapper.toBadgeDomain(badge));
    }


    public BadgeDomain save(BadgeDomain badgeDomain){
        Badge badge = mapper.toBadge(badgeDomain);
        return mapper.toBadgeDomain(badgeCrudRepository.save(badge));
    }

    @Override
    public void delete (int idBadge){
        badgeCrudRepository.deleteById(idBadge);
    }
}
