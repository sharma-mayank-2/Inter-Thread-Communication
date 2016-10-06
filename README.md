# Inter-Thread-Communication

Here i created a bank class and 2 methods to withdraw and deposit and amount.
Using Threads and Lock Therads(Syncronization) to lock the threads and achieve a interThread Communication using wait() and notify() methods.

Firstly withdraw() will be called and if amount to be withdraw is less than amount in bank then wait will be called and lock will be acquired by deposit() method. finally we will unlock it using notify() and lock will be transfered to withdraw() method.