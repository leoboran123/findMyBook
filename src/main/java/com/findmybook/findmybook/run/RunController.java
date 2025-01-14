package com.findmybook.findmybook.run;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.Optional;


@RestController
// With that statement, we are clarifiyng that the return object is going
// to be a json...

@RequestMapping("/api/runs")
// With that statement, we are going to work under /api/runs url, therefore we don't have to
// write the same mapping and we can do get requests with id's, name's etc...  
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    @GetMapping("")
    // We are using an RequestMapping above, therefore we don't need to write /api/runs again.
    List<Run> findAll(){
        return runRepository.findAll();
    }

    
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        // By using PathVariable, we can get the value of the GET request...
        Optional<Run> run = runRepository.findById(id);

        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        else{
            return run.get();
        }

    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    // put -> update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
