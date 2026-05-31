package kh.com.bbu.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
<<<<<<< HEAD
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
=======
    public ResponseEntity<MessageResponse<?>> handleApiException(ApiException e) {
        HttpStatus status = switch (e.getError()) {
            case "404" -> HttpStatus.NOT_FOUND;
            case "400" -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.BAD_REQUEST;
        };

        MessageResponse<?> response = new MessageResponse<>();
        response.setMessage(e.getMessage());
        response.setErrorCode(e.getError());
        response.setSuccess(false);

        // Return the response body along with an HTTP status code
        // You can change BAD_REQUEST to whatever status your ApiException dictates
        return ResponseEntity.status(status).body(response);
    }
}
>>>>>>> 417d379 (feat(product): resolve merge conflict and add product unit)
