package com.findmybook.findmybook.run;

import com.findmybook.findmybook.run.*;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;
import java.util.Optional;


import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);

        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.Id().equals(id));
    }



    Optional<Run> findById(Integer id){
        // Optional is a container object which may or may not contain a non-null value. 
        // so basically, when we do a database or API request, it return the values, if values does
        // not exist, it returns an exception.

        return runs.stream()
            .filter(run -> run.Id() == id)
            .findFirst();
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(
            1,
            "Monday morning run", 
            LocalDateTime.now(), 
            LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 
            3, 
            Location.INDOOR));
        runs.add(new Run(
            2, 
            "Wend evening run", 
            LocalDateTime.now(), 
            LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 
            6, 
            Location.INDOOR));
    }

    

}
