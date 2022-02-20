package market.everyone.api;

import market.everyone.dto.MemberRequestDto;
import market.everyone.error.ErrorBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @PostMapping("/valid")
    public ResponseEntity valid(@Valid @RequestBody MemberRequestDto request, BindingResult bindingResult) {

        ResponseEntity responseEntity;
        if(bindingResult.hasErrors()){
                responseEntity = ErrorBuilder.createErrorMessage(bindingResult);
        }
        else{
            responseEntity= ResponseEntity.ok(request);
        }
        return responseEntity;


    }

}
