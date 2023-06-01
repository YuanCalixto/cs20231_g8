package com.ufg.g8.imagerepoapi.infrastructure.exceptions.handler;

import com.ufg.g8.imagerepoapi.infrastructure.exceptions.DuplicateKeyException;
import com.ufg.g8.imagerepoapi.infrastructure.exceptions.FileIOException;
import com.ufg.g8.imagerepoapi.infrastructure.exceptions.InvalidValueException;
import com.ufg.g8.imagerepoapi.infrastructure.exceptions.NotFoundException;
import com.ufg.g8.imagerepoapi.infrastructure.exceptions.details.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ExceptionDetails> handleDuplicateKeyException(DuplicateKeyException exception){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Chave Duplicada")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(exception.getMessage())
                        .developerMessage(DuplicateKeyException.EXCEPTION_DEVELOPER_MESSAGE)
                        .className(Arrays.stream(exception.getStackTrace()).findFirst().get().getClassName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(FileIOException.class)
    public ResponseEntity<ExceptionDetails> handleFileIOException(FileIOException exception){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Erro na Manipulação de Arquivos")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(exception.getMessage())
                        .developerMessage(FileIOException.EXCEPTION_DEVELOPER_MESSAGE)
                        .className(Arrays.stream(exception.getStackTrace()).findFirst().get().getClassName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ExceptionDetails> handleInvalidValueException(InvalidValueException exception){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Valor e/ou Parâmetro Inválido")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(exception.getMessage())
                        .developerMessage(InvalidValueException.EXCEPTION_DEVELOPER_MESSAGE)
                        .className(Arrays.stream(exception.getStackTrace()).findFirst().get().getClassName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(NotFoundException exception){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Não Encontrado")
                        .status(HttpStatus.NOT_FOUND.value())
                        .details(exception.getMessage())
                        .developerMessage(NotFoundException.EXCEPTION_DEVELOPER_MESSAGE)
                        .className(Arrays.stream(exception.getStackTrace()).findFirst().get().getClassName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND
        );
    }

}
