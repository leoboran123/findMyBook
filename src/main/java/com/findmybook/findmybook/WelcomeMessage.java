package com.findmybook.findmybook;

import org.springframework.stereotype.Component;

// This component makes this WelcomeMessage class visible to Spring-boot.
@Component
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return "Merhaba";
    }
}
