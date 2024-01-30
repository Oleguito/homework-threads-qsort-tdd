import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class QuickSorterTimedTest {
    
    @Test
    void logarithmicIncrement() {
        var sorter = new QuickSorter();
        var random = new Random();
        for (int i = 0; i < 20; i++) {
            long arraySize = (long) Math.pow(10, i);
            int[] array = new ArrayGenerator().generate(arraySize, () -> {
                        return random.nextInt(0, 10); });
            long nanos = timeIt(() -> {
                sorter.sort(array);
            });
            System.out.printf("It took %10.4f ms to sort an array of %d elements\n",
                    nanos / 1e6,
                    arraySize);
        }
    }
    
    private long timeIt(Runnable function) {
        long start = System.nanoTime();
        function.run();
        long end = System.nanoTime();
        return end - start;
    }
    
    
}
