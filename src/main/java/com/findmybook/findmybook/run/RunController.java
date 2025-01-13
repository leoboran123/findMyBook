package com.findmybook.findmybook.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// With that statement, we are clarifiyng that the return object is going
// to be a json...
@RestController
public class RunController {

    @GetMapping("/hello")
    String home(){
        return "Helllooo";
    }


}
