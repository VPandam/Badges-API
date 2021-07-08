package com.badges.APIBadges.persistence.mapper;

import com.badges.APIBadges.domain.BadgeDomain;
import com.badges.APIBadges.persistence.entity.Badge;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BadgeMapper {

    @Mappings({
            @Mapping(source = "idBadge", target = "idBadge"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "jobTitle", target = "jobTitle"),
            @Mapping(source = "twitter", target = "twitter"),
            @Mapping(source = "avatarUrl", target = "avatarUrl")
    })
    BadgeDomain toBadgeDomain (Badge badge);
    List<BadgeDomain> toBadgesDomain (List<Badge> badges);

    @InheritInverseConfiguration
    Badge toBadge (BadgeDomain badgeDomain);

}
