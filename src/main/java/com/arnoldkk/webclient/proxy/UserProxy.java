package com.arnoldkk.webclient.proxy;

import com.arnoldkk.webclient.exceptions.UsersNotException;
import com.arnoldkk.webclient.exceptions.helpers.ExceptionHandler;
import com.arnoldkk.webclient.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserProxy {
    private final WebClient webClient;

    public Flux<User> getUsers(){
        log.info("Obtaining users from the proxy link");
        return webClient.get().uri("/users").exchangeToFlux(res -> res.bodyToFlux(User.class));
    }

    public Mono<User> getUserById(int userId){
        log.info(String.format("Obtaining user with id %d from the proxy link", userId));
        return webClient.get()
                .uri("/users/"+userId)
                .exchangeToMono(res -> {

                            if (res.statusCode().is2xxSuccessful()) {
                                return res.bodyToMono(User.class);
                            } else {
                                throw new UsersNotException("Empty JSON object returned", HttpStatus.NOT_FOUND);
                            }
                        }
                );
    }

}
