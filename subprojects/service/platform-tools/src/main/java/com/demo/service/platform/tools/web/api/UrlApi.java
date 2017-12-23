package com.demo.service.platform.tools.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.Result;
import com.demo.framework.service.web.api.BaseApi;
import com.demo.service.platform.tools.entity.UrlEntity;

@RestController
@RequestMapping(value = "/api/tools/urls")
public class UrlApi extends BaseApi {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Result<Page<UrlEntity>>> list() {
        List<UrlEntity> list = new ArrayList<UrlEntity>();
        UrlEntity entity = new UrlEntity();
        list.add(entity);

        entity.setF_url("sdfadfsd");

        return page(list);
    }
}
