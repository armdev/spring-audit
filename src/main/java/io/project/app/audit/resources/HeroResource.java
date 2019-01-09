package io.project.app.audit.resources;

import io.project.app.audit.domain.Hero;
import io.project.app.audit.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armdev
 */
@RestController
@RequestMapping("/api/v2/hero")
public class HeroResource {

    @Autowired
    private HeroService heroService;

    @GetMapping
    @CrossOrigin
    public Flux<String> find(@RequestHeader(value = "token", required = false) String token) {
        return heroService.findAll();
    }

    @GetMapping("/find/one")
    @CrossOrigin
    public Mono<Hero> get(@RequestParam(required = true, name = "id") Long id) {
        return heroService.findById(id);
    }

}
