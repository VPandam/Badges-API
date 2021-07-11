package com.badges.APIBadges.web.controller;

import com.badges.APIBadges.domain.BadgeDomain;
import com.badges.APIBadges.domain.service.BadgeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<BadgeDomain>> getAll() {
        try {
            return new ResponseEntity<>(badgeService.getAll(), HttpStatus.OK);
        }catch(Error e){
           return new ResponseEntity<>(HttpStatus.valueOf(e.toString()));
        }

    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<BadgeDomain> getBadgeDomain(@PathVariable("id") int badgeDomainId){
        return badgeService.getBadge(badgeDomainId).map(badgeDomain -> new ResponseEntity<>(badgeDomain, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<BadgeDomain> save (@RequestBody BadgeDomain badgeDomain){
        return new ResponseEntity<>(badgeService.save(badgeDomain), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<BadgeDomain> update (@PathVariable("id") int badgeId, @RequestBody BadgeDomain badgeDomain){
        BadgeDomain badgeDomain1 = badgeService.getBadge(badgeId).get();
        badgeDomain1.setFirstName(badgeDomain.getFirstName());
        badgeDomain1.setLastName(badgeDomain.getLastName());
        badgeDomain1.setEmail(badgeDomain.getEmail());
        badgeDomain1.setJobTitle(badgeDomain.getJobTitle());
        badgeDomain1.setTwitter(badgeDomain.getTwitter());
        badgeService.save(badgeDomain1);
        return new ResponseEntity<>(badgeDomain1, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable("id") int badgeId){
        if (badgeService.delete(badgeId)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }


}

