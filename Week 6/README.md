# Week 6

This week we will try to cover concurrency as well as abstract classes. The exercises
should help develop your knowledge of threads (lifecycle management and implementation),
thread-safety and abstract classes.

## Part 1
1. Look at the implementation of the Dining Philosopher's program to understand what it is doing
2. Run it a few times. Is there an issue? What is the issue? Can you explain why this occurs
3. Turn Philosopher into an abstract class.
4. Extend Philosopher with different locking strategies

## Part 2
We are trying to make a counting program that will consistently count to a specified target. I want
it to be fast so implement a multithreaded approach to this.

1. Write the main function: This should instantiate a group of Incrementer threads and
wait for their execution to stop. Finally, the count should be printed as well as what is 
   expected.
   
2. After running the program a few times what issue do you notice? Why is this happening?
3. Can you implement multiple strategies to mitigate the above issue?