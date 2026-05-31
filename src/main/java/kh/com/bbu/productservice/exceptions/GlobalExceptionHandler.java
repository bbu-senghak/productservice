package kh.com.bbu.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<MessageResponse> handleApiException(ApiException e) {

        // Assuming MessageResponse has a constructor or setter for the message
        MessageResponse response = new MessageResponse(e.getMessage());

        // Return the response body along with an HTTP status code
        // You can change BAD_REQUEST to whatever status your ApiException dictates
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}