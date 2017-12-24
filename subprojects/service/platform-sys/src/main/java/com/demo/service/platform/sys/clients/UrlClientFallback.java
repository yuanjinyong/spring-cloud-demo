/**
 * 
 */
package com.demo.service.platform.sys.clients;

import org.springframework.http.ResponseEntity;

import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.Result;

/**
 * @author 袁进勇
 *
 */
public class UrlClientFallback implements UrlClient {

    @Override
    public ResponseEntity<Result<Page<Url>>> list() {
        return null;
    }

}
