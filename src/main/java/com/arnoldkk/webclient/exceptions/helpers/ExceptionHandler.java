package com.arnoldkk.webclient.exceptions.helpers;

import com.arnoldkk.webclient.exceptions.PostsNotFoundException;
import com.arnoldkk.webclient.exceptions.UsersNotException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    ResponseEntity<JsonError> handleException(Exception exception, HttpStatus httpStatus) {

        if (exception instanceof UsersNotException usersNotException) {

            return new ResponseEntity<>(new JsonError(usersNotException.getMessage()), httpStatus);

        } else if (exception instanceof PostsNotFoundException postsNotFoundException) {

            return new ResponseEntity<>(new JsonError(postsNotFoundException.getMessage()), httpStatus);

        }else {
            return new ResponseEntity<>(new JsonError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
