package com.findmybook.findmybook.run;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// With that statement, we are clarifiyng that the return object is going
// to be a json...
@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    @GetMapping("/api/runs")
    List<Run> findAll(){
        return runRepository.findAll();
    }


}
