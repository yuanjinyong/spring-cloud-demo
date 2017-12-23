package com.demo.framework.service.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.demo.framework.core.model.Result;

public class ResponseResult<T> extends ResponseEntity<Result<T>> {
    public ResponseResult(Result<T> body) {
        super(body, HttpStatus.OK);
    }

    public ResponseResult(Result<T> body, HttpStatus status) {
        super(body, status);
    }

    public ResponseResult(Result<T> body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
