package com.ppt;

import com.ppt.web.Url;

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

public interface WebCache {
    String returnsContent(Url url);
}