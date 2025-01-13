package com.findmybook.findmybook.run;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return run.get();
        }

    }
}
