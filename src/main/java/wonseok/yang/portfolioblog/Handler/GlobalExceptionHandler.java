package wonseok.yang.portfolioblog.Handler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 에러가 다 여기로 오도록 하는 어노테이션
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class) //Exception발생시 value를 매개변수 e로 전달해줌
    public String IllegalArgumentException(IllegalArgumentException e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class) //Exception발생시 value를 매개변수 e로 전달해줌
    public String EmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }
}
