/**
 * 
 */
package com.demo.service.platform.sys.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.Result;
import com.demo.framework.service.consts.ServiceConst;

/**
 * @author 袁进勇
 *
 */
@FeignClient(value = ServiceConst.PLATFORM_TOOLS, fallback = UrlClientFallback.class)
public interface UrlClient {
    @RequestMapping(value = "/api/platform/tools/urls", method = RequestMethod.GET)
    ResponseEntity<Result<Page<Url>>> list();
}
