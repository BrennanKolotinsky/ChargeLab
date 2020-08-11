# ChargeLab
Creating a Maven based project -- Priority Queue with Multithreading

Problem A: Design a priority queue
This unique priority queue stores a set number of items, each with a given priority. A simple logic
determines the egress sequence of items.
The usage of this data structure is exclusively within multi-threaded environments where multiple
parallel producers and consumers enqueue and dequeue items.
The specification is as below:
 Each queue-item is a combination of priority and value of type T (T: general type - can be
anything)
 Priority is defined as an integer with “1” being the highest priority.
 When items are requested from the queue, the following constraints must be strictly observed:
o Constraint A: Items are only FIFO within their priority class.
o Constraint B: Items with the highest priority are dequeued first unless the following
condition applies: For every 2 items dequeued with priority "P", the next item must be of
priority "P+1". We call the count “2” as the Burst Rate of a priority class. The two items
dequeued must not necessarily be dequeued consecutively for this constraint to apply.
See examples below.

 The queue must be thread safe as it is used exclusively in multi-threaded environments.
o The queue has a pre-determined size (capacity) and the total number of items in the
queue must never exceed its capacity.
o If enqueing an item into the queue exceeds the queue capacity, the requesting call must
be blocked until capacity is available on a first-come-first-serve basis.
o When dequeuing, if the queue has no items, the requesting call must also be blocked
until items are available on a first-come-first-serve basis.

Problem A1: Identify a scenario where lower priority items may never exit the queue. Provide a
solution.
Problem A2: Implement this data structure. If applicable, please incorporate your answer to A1.
