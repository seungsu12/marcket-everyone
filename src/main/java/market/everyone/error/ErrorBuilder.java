package market.everyone.error;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorBuilder {

    public static ResponseEntity createErrorMessage(BindingResult bindingResult) {
        List<String> fieldErrors = bindingResult.getFieldErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(fieldErrors);
    }
}
