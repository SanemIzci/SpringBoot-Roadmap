package com.sanemizci.starter.handler;

import com.sanemizci.starter.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(BaseException baseException, WebRequest webRequest) {
        ApiError<String> error = createApiError(baseException.getMessage(), webRequest);
        return ResponseEntity.badRequest().body(error);
    }
        
    public <E> ApiError<E> createApiError(E message,WebRequest webRequest){
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        Exception <E> exception = new Exception();
        exception.setCreateDate(new Date());
        exception.setHostName(getHostName());
        exception.setPath(webRequest.getDescription(false));
        exception.setMessage(message);

        apiError.setException(exception);
        return  apiError;
    }
    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Hata mesajı: " + e);

        }
        return null;
    }

}
