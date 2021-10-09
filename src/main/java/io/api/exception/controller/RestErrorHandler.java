package io.api.exception.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.api.exception.NotFoundException;
import io.api.exception.StandardErrorBadRequest;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {

		StandardErrorBadRequest error = new StandardErrorBadRequest(exception.getMessage());

		return new ResponseEntity<Object>(error, headers, status);
	}

	@ExceptionHandler({ NotFoundException.class })

	public ResponseEntity<StandardErrorBadRequest> defaultException(Throwable e, HttpServletRequest request) {
		StandardErrorBadRequest error = new StandardErrorBadRequest(e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
