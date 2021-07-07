package com.badges.APIBadges.persistence.crud;


import com.badges.APIBadges.persistence.entity.Badge;
import org.springframework.data.repository.CrudRepository;

public interface BadgeCrudRepository extends CrudRepository <Badge, Integer> {

}
