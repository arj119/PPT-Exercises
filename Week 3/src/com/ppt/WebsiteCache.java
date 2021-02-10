package com.ppt;

import com.ppt.web.*;
import java.util.*;

/**
 * WebCache interface to implement. Represents a cache that can be used to speed
 * up web pages
 *
 * When a user requests a URL the following must be done: 
 * 1. Check if the cache contains the URL 
 *  a. If cache contains URL return stored page contents immediately 
 *  b. If cache does not contain URL move to step 2 
 * 2. Request page contents from a WebService 
 * 3. Store page contents received in Cache and return to requester 
 * 
 * EXTENSION: 
 * 4. If the cache is finitely sized remove an
 * entry from the cache and replace it with the latest fetched. Think about how
 * to choose the entry to be evicted.
 */
public class WebsiteCache implements WebCache {

  private final Map<Url, String> cache = new HashMap<>();
  private final WebService service;

  public WebsiteCache(WebService service) {
      this.service = service;
  }

//   @Override
//   public String returnsContent(Url url) {
//     if (cache.containsKey(url)) {
//         return cache.get(url);
//     } else {
//         // fetch url from the WebService
//         String resource = service.fetchResource(url);
//         cache.put(url, resource);
//         return resource;
//     }
//   }

  @Override
  public String returnsContent(Url url) {
    if (!cache.containsKey(url)) {
        cache.put(url, service.fetchResource(url));
    } 
    return cache.get(url);
  }
}
