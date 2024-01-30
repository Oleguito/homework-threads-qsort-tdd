import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

class ArrayGenerator {
    
    Random random = new Random();
    
    public int[] generate() {
        int size = randSize();
        var res = IntStream.range(0, size)
                .map(e -> randInt())
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();
        return res;
    }
    
    public int[] generate(long size, IntSupplier intSupplier) {
        int arraySize = randSize();
        var res = IntStream.range(0, arraySize)
                .map(e -> intSupplier.getAsInt())
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();
        return res;
    }
    
    private int randSize() {
        // return random.nextInt(1, 1_000);
        // return random.nextInt(1, 10);
        return 10;
    }
    
    private int randInt() {
        // return random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        return random.nextInt(0, 10);
    }
}
