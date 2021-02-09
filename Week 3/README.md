# Week 3 / 5 Exercise: To implement a web cache

## Background

A cache is a memory buffer used to temporarily store frequently accessed data. It improves performance since data does
not have to be retrieved again from the original source. Caching is actually a concept that has been applied in various
areas of the computer/networking industry for quite some time, so there are different ways of implementing cache
depending upon the use case. In fact, devices such as routers, switches, and PCs use caching to speed up memory access.
Another very common cache, used on almost all PCs, is the web browser cache for storing requested objects so that the
same data doesn't need to be retrieved multiple times.

[Read more here](https://dzone.com/articles/introducing-amp-assimilating-caching-quick-read-fo)

## Exercise instructions

1. Design a WebCache interface based on the specification in [WebCache.java](./src/com/ppt/WebCache.java)
2. Implement a concrete implementation for your WebCache interface
   1. Check if the cache contains the URL \
      a. If cache contains URL return stored page contents immediately \
      b. If cache does not contain URL, move to step ii
   2. Request page contents from a WebService
   3. Store page contents received in Cache and return to requester 

## Extension
3. Caches cannot be infinitely sized, so implement a cache that takes the size
   as a parameter and when full will remove an entry from the cache and replace it with the latest fetched. Think about how
   to choose the entry to be evicted.
4. A lot of the functionality you have implemented in the previous steps are quite general and can be used for different
   types of caches. Redesign a generic interface that can cache any object and can lookup via any object. Your existing
   implementation should still work. 

### Multi-threaded Cache
5. Describe possible race conditions or deadlocks that could occur.
6. Can you make the cache thread-safe in a coarse-grained manner?
7. Can you make the cache thread-safe in a fine-grained manner?
8. Discuss the difference in performance that fine-grained locking vs coarse-grained locking provides.

