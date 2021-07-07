package com.badges.APIBadges.persistence;

import com.badges.APIBadges.persistence.crud.BadgeCrudRepository;
import com.badges.APIBadges.persistence.entity.Badge;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BadgeRepository {
    private BadgeCrudRepository badgeCrudRepository;

    public List<Badge> getAll(){
        return (List<Badge>) badgeCrudRepository.findAll();
    }

    public Optional<Badge> getById(int id){
        return badgeCrudRepository.findById(id);
    }
    public Badge save(Badge badge){
        return badgeCrudRepository.save(badge);
    }

    public void delete (int idBadge){
        badgeCrudRepository.deleteById(idBadge);
    }
}
