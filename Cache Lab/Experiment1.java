import edu.westminstercollege.cmpt328.memory.*;

public class Experiment1 {
    //public static final ReplacementAlgorithm LRU

    public static void main(String... args) {
        // Make a simple two-level memory system

        // Due to the structure of the code we always start at the bottom (RAM)
        MainMemory ramA = new MainMemory(
                "RAM A",      // name of memory
                200     // access time in cycles
        );

        MainMemory ramB = new MainMemory(
            "RAM B", 
            200
        );

        // Make a cache to sit on top of the RAM
        // Since there are so many parameters to specify, the Cache class uses the "builder" pattern for construction
        Cache cacheA = Cache.builder()
                .name("Cache A")      // name of cache
                .drawingFrom(ramA)   // what memory it pulls from
                .lineCount(256)       // how many lines (of 64 bytes)
                .accessTime(20)     // access time in cycles
                .directMapping()    // use direct mapping
                .build();           // build the cache as configured

        Cache cacheB = Cache.builder()
            .name("Cache B")
            .drawingFrom(ramB)
            .lineCount(256)
            .accessTime(25)
            .setAssociative(2, ReplacementAlgorithm.LRU)
            .build();

        MemorySystem sysA = new MemorySystem(cacheA);
        MemorySystem sysB = new MemorySystem(cacheB);

        // Print out the cache in its current (vacant state)
        System.out.println("Cache before any accesses:");
        cacheA.print();
        System.out.println("\n");

        IntArrayValue a = sysB.allocateIntArray(6144);
        IntArrayValue b = sysB.allocateIntArray(6144);
        IntArrayValue c = sysB.allocateIntArray(6144);
        
        IntValue i = sysB.allocateInt();
        for (i.set(0); i.get() < a.getLength(); i.increment()) {
            b.set(i.get(), a.get(i.get()));
        }
        sysB.resetMemories();

        for (i.set(0); i.get() < a.getLength(); i.increment()) {
            c.set(i.get(), a.get(i.get()));
        }
    
        // How many CPU cycles did we use on our fictional computer with these memory accesses?
        System.out.printf("\n\nCycles used: %d\n", sysB.getTotalAccessTime());
        // Print out the cache again
        System.out.println("\nCache after these accesses:");
        cacheA.print();

        // The MemorySystem can also print out a summary of accesses, hit ratios, and so on
        System.out.println("\n");
        System.out.println("Memory system summary");
        sysB.printStatistics();

        System.out.println("Memory Address of a: " + a.getAddress());
        System.out.println("Memory Address of b: " + b.getAddress());
        System.out.println("Memory Address of c: " + c.getAddress());
        }
    }