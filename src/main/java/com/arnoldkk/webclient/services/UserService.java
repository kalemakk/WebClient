package com.arnoldkk.webclient.services;

import com.arnoldkk.webclient.models.User;
import com.arnoldkk.webclient.proxy.UserProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserProxy userProxy;

    public Flux<User> getUsers(){
        return userProxy.getUsers();
    }

    public Mono<?> getUserById(int userId){


//        return userProxy.getUserById(userId) == null ? Mono.just("user is present") : userProxy.getUserById(userId);

        return userProxy.getUserById(userId);
    }

}
