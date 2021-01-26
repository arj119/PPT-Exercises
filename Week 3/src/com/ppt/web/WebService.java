package com.ppt.web;

/**
 * A service that fetches resources for a url. This should only be used if the resource is not
 * present in cache.
 */
interface WebService {
  String fetchResource(Url url);
}
