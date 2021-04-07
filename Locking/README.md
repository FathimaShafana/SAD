# Pessimistic and Optimistic Locking

Locking is used to manage concurrency whenever there are multiple concurrent users accessing a system. There are mainly two ways such as:
1. Optimistic Locking is where the resources are not locked. Rather, it resolves any conflict when it occurs. @version is used to keep track of inconsictent state of objects. 
![](https://github.com/FathimaShafana/SAD/blob/main/Locking/LockingSnaps/Optim.JPG?raw=true)

2. Pessimistic Locking is where the resources are locked by either ReadLock or WriteLock. A read lock locks out resources and allows the other transactions to read but not perform any write
operations. Whereas, A write lock does not allow other transcations to either write or read. Pessimistic Locking is done by @Lock in this example.
![](https://github.com/FathimaShafana/SAD/blob/main/Locking/LockingSnaps/PL1.JPG?raw=true)

Some instances of making locks precedence are here:
### Write Locks takes precedence
![](https://github.com/FathimaShafana/SAD/blob/main/Locking/LockingSnaps/PL1.JPG?raw=true)

### Read Lock takes precedence
![](https://github.com/FathimaShafana/SAD/blob/main/Locking/LockingSnaps/ReadLock.JPG?raw=true)

### When both threads start the same
![](https://github.com/FathimaShafana/SAD/blob/main/Locking/LockingSnaps/ThreadSamet.JPG?raw=true)

### Exception is raised when the program is simulated to have readLockTransaction precede and the lock is kept for 10000 ms more.
![](https://github.com/FathimaShafana/SAD/blob/main/Locking/LockingSnaps/Exception.JPG?raw=true)
