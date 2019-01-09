/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.audit.services;


import io.project.app.audit.domain.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armdev
 */
@Service
@Slf4j
public class HeroService {   


    public Flux<String> findAll() {
        return Flux.just(" Hero User ", " Aloha User ", " Good Bye user ");
    }

    public Mono<Hero> findById(Long id) {
        return Mono.just(new Hero(25L, "Armen", "Arz"));
    }

  

}
