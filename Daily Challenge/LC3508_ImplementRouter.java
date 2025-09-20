/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 3508. Implement Router
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
Design a data structure that manages packets in a network router. Each packet has:  

- `source`: ID of the machine sending the packet.  
- `destination`: ID of the machine receiving the packet.  
- `timestamp`: Arrival time.  

Implement class `Router`:  
- `Router(int memoryLimit)`: Initializes with a fixed memory limit.  
- `boolean addPacket(int source, int destination, int timestamp)`: Adds a packet unless duplicate. If memory full, remove oldest.  
- `int[] forwardPacket()`: Forwards/removes the oldest packet in FIFO order. Returns `[]` if none.  
- `int getCount(int destination, int startTime, int endTime)`: Returns number of packets with given destination and timestamp in `[startTime, endTime]`.  

Notes:  
- Duplicate = same `(source, destination, timestamp)`.  
- `addPacket` queries given in increasing timestamp order.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input:  
["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]  
[[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]  

Output:  
[null, true, true, false, true, true, [2, 5, 90], true, 1]  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
- Maintain **packets in FIFO** order using a `Queue`.  
- Use a **map to detect duplicates** (key = `(source, destination, timestamp)`).  
- For destination queries, store timestamps in a **sorted list per destination** (so binary search can handle ranges).  
- Evict oldest packet when memory exceeds.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Encode `(source, destination, timestamp)` as a unique long key.  
2. Use `HashMap<Long, int[]>` for packet storage.  
3. Use `Queue<Long>` for FIFO ordering.  
4. Use `Map<Integer, List<Integer>>` for destination → timestamps.  
5. On `forwardPacket`, remove from all structures.  
6. For `getCount`, use binary search (`lowerBound`, `upperBound`) on timestamps list.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- `addPacket`: O(1) amortized (except eviction cost).  
- `forwardPacket`: O(1).  
- `getCount`: O(log N) per query due to binary search.  
- Space: O(N) for at most memoryLimit packets.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Router {
    private final int size;
    private final Map<Integer, List<Integer>> counts;
    private final Map<Long, int[]> packets;
    private final Queue<Long> queue;

    public Router(final int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public boolean addPacket(final int source, final int destination, final int timestamp) {
        final long key = encode(source, destination, timestamp);

        if (packets.containsKey(key))
            return false;

        if (packets.size() >= size)
            forwardPacket();

        packets.put(key, new int[] { source, destination, timestamp });
        queue.offer(key);

        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty())
            return new int[] {};

        final long key = queue.poll();
        final int[] packet = packets.remove(key);

        if (packet == null)
            return new int[] {};

        final int destination = packet[1];
        final List<Integer> list = counts.get(destination);

        list.remove(0);

        return packet;
    }

    public int getCount(final int destination, final int startTime, final int endTime) {
        final List<Integer> list = counts.get(destination);
        if (list == null || list.isEmpty())
            return 0;

        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);

        return right - left;
    }

    private long encode(final int source, final int destination, final int timestamp) {
        return ((long) source << 40) | ((long) destination << 20) | timestamp;
    }

    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while (low < high) {
            final int mid = (low + high) >>> 1;
            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while (low < high) {
            final int mid = (low + high) >>> 1;

            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}

