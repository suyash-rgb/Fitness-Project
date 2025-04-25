package com.fitness.activityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.logging.*;

@Service

public class UserValidationService {

    @Autowired
    private WebClient userServiceWebClient;

    private static Logger logger = Logger.getLogger(UserValidationService.class.getName());


    public boolean validateUser(String userId){
        logger.info("Calling User Validation API for userId: "+userId);
        try{
            return Boolean.TRUE.equals(userServiceWebClient.get()
                    .uri("api/users/{userId}/validate", userId)
                    .retrieve()//make the api call
                    .bodyToMono(Boolean.class)
                    .block());
        } catch(WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new RuntimeException("User Not Found: "+userId);
            }
            else if(e.getStatusCode() == HttpStatus.BAD_REQUEST){
                throw new RuntimeException("Invalid Request: "+userId);
            }
        }
        return false;
    }
}
