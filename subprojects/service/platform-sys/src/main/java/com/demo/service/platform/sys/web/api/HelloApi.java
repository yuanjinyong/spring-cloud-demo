package com.demo.service.platform.sys.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.Result;
import com.demo.service.platform.sys.clients.Url;
import com.demo.service.platform.sys.clients.UrlClient;

@RestController
@RequestMapping(value = "/api/hello")
public class HelloApi {
    @Autowired
    private UrlClient urlClient;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Result<Page<Url>>> list() {
        return urlClient.list();
    }
}
