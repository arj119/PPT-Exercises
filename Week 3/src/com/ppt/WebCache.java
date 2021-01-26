package com.ppt;

import com.ppt.web.Url;

/**
 * WebCache interface to implement. Represents a cache that can be used to speed up web pages
 *
 * When a user requests a URL the following must be done:
 * 1. Check if the cache contains the URL
 *      a. If cache contains URL return stored page contents immediately
 *      b. If cache does not contain URL move to step 2
 * 2. Request page contents from a WebService
 * 3. Store page contents received in Cache and return to requester
 * EXTENSION:
 * 4. If the cache is finitely sized remove an entry from the cache and replace it with
 *    the latest fetched.
 *
 */
public interface WebCache {
  /**
   * A url fetching service
   *
   * @param url to fetch
   * @return page contents associated with that url. If not available in the cache it should be
   *     fetched from the WebService
   */
  String fetchUrl(Url url);
}
