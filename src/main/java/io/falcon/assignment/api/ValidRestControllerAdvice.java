package io.falcon.assignment.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidRestControllerAdvice extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException exception,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {

    ValidationErrorDto validationErrorDto = getDtoFromExceptionErrors(exception.getBindingResult());

    return super.handleExceptionInternal(
        exception, validationErrorDto, headers, status, webRequest);
  }

  private ValidationErrorDto getDtoFromExceptionErrors(Errors errors) {
    List<String> errorsFound = new ArrayList<>();

    for (ObjectError objectError : errors.getAllErrors()) {
      errorsFound.add(objectError.getDefaultMessage());
    }
    return new ValidationErrorDto("Error creating note", errorsFound);
  }

  public static final class ValidationErrorDto {
    private String status;
    private List<String> message;

    public ValidationErrorDto(String status, List<String> message) {
      this.status = status;
      this.message = message;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public List<String> getMessage() {
      return message;
    }

    public void setMessage(List<String> message) {
      this.message = message;
    }
  }
}
