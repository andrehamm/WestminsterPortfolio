import edu.westminstercollege.cmpt328.memory.*;
import java.util.*;

public class Experiment2 {

    private static void benchmark(MemorySystem sys) {
        Random random = new Random();
        IntArrayValue data = sys.allocateIntArray(100000);
        IntValue i = sys.allocateInt();
        IntValue tmp = sys.allocateInt();
        IntValue a = sys.allocateInt();
        IntValue b = sys.allocateInt();

        for (i.set(0); i.get() < 1000000; i.increment()) {
            a.set(random.nextInt(data.getLength()));
            b.set(random.nextInt(data.getLength()));

            tmp.set(data.get(a));
            data.set(a, data.get(b));
            data.set(b, tmp);
        }

        System.out.printf("\nTotal access time: %,d\n", sys.getTotalAccessTime());
        sys.printStatistics();
    }

    public static void main(String... args) {
        
        MainMemory ramA = new MainMemory(
            "RAM A",
            200
        );

        MainMemory ramB = new MainMemory(
            "RAM B",
            200
        );

        MainMemory ramC = new MainMemory(
            "RAM C",
            200
        );

        Cache cacheA = Cache.builder()
            .name("Cache A")
            .drawingFrom(ramA)
            .lineCount(256)
            .accessTime(25)
            .setAssociative(2, ReplacementAlgorithm.LRU)
            .build();

        Cache cacheB = Cache.builder()
            .name("Cache B")
            .drawingFrom(ramB)
            .lineCount(256)
            .accessTime(25)
            .setAssociative(8, ReplacementAlgorithm.LRU)
            .build();

        Cache cacheC = Cache.builder()
            .name("Cache C")
            .drawingFrom(ramC)
            .lineCount(256)
            .accessTime(25)
            .fullyAssociative(ReplacementAlgorithm.LRU)
            .build();

        MemorySystem sysA = new MemorySystem(cacheA);
        MemorySystem sysB = new MemorySystem(cacheB);
        MemorySystem sysC = new MemorySystem(cacheC);

        benchmark(sysA);
        benchmark(sysB);
        benchmark(sysC);
    }
    
}