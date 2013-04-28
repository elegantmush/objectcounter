# Object Counter

---

## Overview

Using AspectJ to experiment with counting objects created within a JVM.

To see it in action:

1. Clone the project within your chosen directory, from the command line 

        git clone https://github.com/elegantmush/objectcounter.git
    
2. Change to the project directory

        cd objectcounter
    
3. Execute the ObjectCounterIT integration test

        mvn -Dit.test=ObjectCounterIT clean verify
    
---

## What's going on?
    
The code to count created objects comprises an aspect, 
`com.elegantmush.objectcounter.aspect.CounterAspect` and a singleton enum, 
`com.elegantmush.objectcounter.ObjectRegistry`. The aspect captures all _initial_ calls to a 
constructor - i.e. it ignores implicit calls to super() and constructors called via this() chaining. 
The enum uses a `java.util.concurrent.ConcurrentMap<String, Integer>` to store fully qualified 
classnames and associated counts.


## What's next?

* JMX view on the object count
* Spring librari-fication, so that it can be dropped into an existing project seamlessly and without
  effort on the project owner's part.

  
## Why?

Well.. the object counting caper may not be of much use, but the principles of weaving into existing
code, being able to use JMX to monitor the effects of the woven-in functionality, and to be able
to provide drop-in Spring libraries that enable auxillary functionality to existing projects have
potentially far-reaching benefits.

We can gain an understanding of these principles and generalise how to practically effect them 
by using dummy example functionality such as object counting.

