//package com.ecommarce.api.exception.handler;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//	/*
//	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
//	 * ResponseEntity<Map<String, List<String>>>
//	 * handleValidationErrors(MethodArgumentNotValidException ex) { List<String>
//	 * errors = ex.getBindingResult().getFieldErrors()
//	 * .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//	 * return new ResponseEntity(getErrorsMap(errors), HttpStatus.BAD_REQUEST); }
//	 * private Map<String, List<String>> getErrorsMap(List<String> errors) {
//	 * Map<String, List<String>> errorResponse = new HashMap<>();
//	 * errorResponse.put("errors", errors); return errorResponse; }
//	 */
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult()
//            .getFieldErrors()
//            .stream()
//            .map(FieldError::getDefaultMessage)
//            .collect(Collectors.toList());
//
//        return ResponseEntity.badRequest().body(errors.toString());
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//}
