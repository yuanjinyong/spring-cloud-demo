package com.demo.framework.service.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.Result;

public abstract class BaseApi extends SuperApi {
    protected <T> ResponseEntity<Result<Page<T>>> page(List<T> items) {
        return new ResponseEntity<Result<Page<T>>>(new Result<Page<T>>(new Page<T>(items)), HttpStatus.OK);
    }
}
