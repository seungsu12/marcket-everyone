package market.everyone.api;

import market.everyone.dto.UserRequestDto;
import market.everyone.error.ErrorBuilder;
import market.everyone.exception.PostNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @PostMapping("/valid")
    public ResponseEntity valid(@Valid @RequestBody UserRequestDto request, BindingResult bindingResult) {

        ResponseEntity responseEntity;
        if(bindingResult.hasErrors()){
                responseEntity = ErrorBuilder.createErrorMessage(bindingResult);
        }
        else{
            responseEntity= ResponseEntity.ok(request);
        }
        return responseEntity;


    }

    @GetMapping("/test")
    public String test() {
        int a=1;
        if (a!=0) {
            throw new PostNotFoundException();
        }
        return "test";
    }

}
