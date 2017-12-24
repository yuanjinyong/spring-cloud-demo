package com.demo.service.platform.tools.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.Result;
import com.demo.framework.service.web.api.BaseApi;
import com.demo.service.platform.tools.entity.UrlEntity;

@RestController
@RequestMapping(value = "/api/platform/tools/urls")
public class UrlApi extends BaseApi {
    @Value("${foo}")
    private String foo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Result<Page<UrlEntity>>> list() {
        List<UrlEntity> list = new ArrayList<UrlEntity>();
        UrlEntity entity = new UrlEntity();
        list.add(entity);

        entity.setF_url(foo);

        return page(list);
    }
}
