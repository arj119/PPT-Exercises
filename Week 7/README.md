# Week 7

This week we are exploring the concepts of thread safety in data structures!
We will be implementing a ConcurrentSet

## Part 1
1. Read and understand the implementation for [BinarySearchTreeSet](./src/com/ppt/binarySearchTreeSet/BinarySearchTreeSet.java)
2. Implement a coarse-grained locking implementation in [CoarseBinarySearchTreeSet](./src/com/ppt/binarySearchTreeSet/CoarseBinarySearchTreeSet.java)
3. Implement a fine-grained locking in [FineBinarySearchTreeSet](./src/com/ppt/binarySearchTreeSet/FineBinarySearchTreeSet.java) \
**Make sure both implementations pass existing tests**
4. Discuss the trade-offs of both approaches\
**EXTENSION**
5. Implement optimistic locking and lock free implementations.

## Part 2
1. Design the best thread safe implementation of a set implemented with a linked list in [LinkedSet](./src/com/ppt/linkedSet/LinkedSet.java)