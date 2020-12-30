package com.paco.challenge.challenge.challenge;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChallengeController {

    private final ChallengeRepository repository;

    ChallengeController(ChallengeRepository repository){
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/challenges")
    List<Challenge> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/challenges")
    Challenge newChallenge(@RequestBody Challenge newChallenge) {
        return repository.save(newChallenge);
    }

    @GetMapping("/challenges/{id}")
    Challenge one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ChallengeNotFoundException(id));
    }

    @PutMapping("/challenges/{id}")
    Challenge raplaceChallenge(@RequestBody Challenge newChallenge, @PathVariable Long id) {
        return repository.findById(id)
                .map(challenge -> {
                    challenge.setTitle(newChallenge.getTitle());
                    challenge.setDescription(newChallenge.getDescription());
                    return repository.save(challenge);
                }).orElseGet(() -> {
                    newChallenge.setId(id);
                    return repository.save(newChallenge);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
