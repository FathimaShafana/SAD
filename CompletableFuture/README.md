# Multi-threading with SpringBoot

This repository is used to write and explore asynchronous, non-blocking and multi-threaded code using CompletableFuture, which was introduced in Java 8. The CompletableFuture implements Future interface, it can combine multiple asynchronous computations, handle possible errors and offers much more capabilities. 
The Asynchronous method is implemented using a CarService layer.
Important terminologies:
  1.setCorePoolSize - set the number of threads
  2.setMaxPoolSize - allow the pool to accommodate an this "<i>specific</i>" number of concurrent tasks
  3.setQueueCapacity - number of items your threadPool will accept before rejecting them

<i><b>CorePoolSize and MaxPoolSize </b> are generally set as equal to have fixed-size thread pool </i>

### Output when the thread size is set to two and three files are uploaded:
![](https://github.com/FathimaShafana/SAD/blob/main/CompletableFuture/CompletableSnaps/TwoThread.JPG?raw=true)
The two threads accept the job simulataneously and third job needs to wait until the jobs are completed.

### Output when the thread size is set to three and three files are uploaded: 
![](https://github.com/FathimaShafana/SAD/blob/main/CompletableFuture/CompletableSnaps/FileUploadthree.JPG?raw=true)
The three threads accept the job simulataneously.

### The CorePoolSize is set to two and three jobs are made to run using GET:
![](https://github.com/FathimaShafana/SAD/blob/main/CompletableFuture/CompletableSnaps/ThreeTasks.JPG?raw=true)
Since there are only two threads, Two threads run simultaneously but the last job has to wait until the threads are free. Thus, the timestamp of the last one is quite late.


### The CorePoolSize is set to three and three jobs are made to run using GET:
![](https://github.com/FathimaShafana/SAD/blob/main/CompletableFuture/CompletableSnaps/GetThreePool.JPG?raw=true)
There are three threads and they run simultaneously. Timestamp of the three jobs confirm them.

### When you have only one job
No matter the number of your threads, when you submit a single job and run it, it runs as a single thread.
![](https://github.com/FathimaShafana/SAD/blob/main/CompletableFuture/CompletableSnaps/OneThread.JPG?raw=true)
