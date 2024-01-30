import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSorterTest {

    @Test
    @DisplayName("Test many arrays")
    void test_many_arrays() {
        var sorter = new QuickSorter();
        boolean allGood = true;
        List <int[]> arrays = new ArrayList <>();
        
        arrays.add(new int[] {1, 8, 3});
        arrays.add(new int[] {2, 7, 1});
        arrays.add(new int[] {8, 2, 4, 7, 1, 3, 9, 6, 5});
        arrays.add(new int[] {0, 0, 0});
        arrays.add(new int[] {3, 0, 0});
        arrays.add(new int[] {1, 0, -1});
        arrays.add(new int[] {1, 0});
        arrays.add(new int[] {1});
        arrays.add(new int[] {1, 2});
        arrays.add(new int[] {1, 2, 3});
        arrays.add(new int[] {1, 2, 3, 4});
        arrays.add(new int[] {1, 2, 3, 4, 5});
        arrays.add(new int[] {1, 1});
        
        for(var arr : arrays) {
            int[] toBeSorted = Arrays.copyOf(arr, arr.length);
            int[] original = Arrays.copyOf(toBeSorted, toBeSorted.length);
            int[] copy = Arrays.copyOf(toBeSorted, toBeSorted.length);
            
            Arrays.sort(toBeSorted);
            sorter.sort(original);
            
            boolean good = Arrays.equals(toBeSorted, original);
            if(!good) {
                System.out.printf("correct solution: %s\n", Arrays.toString(toBeSorted));
                System.out.printf("     my solution: %s\n", Arrays.toString(original));
                allGood = false;
                break;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            int[] toBeSorted = new ArrayGenerator().generate();
            int[] original = Arrays.copyOf(toBeSorted, toBeSorted.length);
            int[] copy = Arrays.copyOf(toBeSorted, toBeSorted.length);

            Arrays.sort(toBeSorted);
            sorter.sort(original);
            int[] sortedByMyCode = original;

            boolean good = Arrays.equals(toBeSorted, sortedByMyCode);
            if(!good) {
                System.out.printf("           array: %s\n", Arrays.toString(copy));
                System.out.printf("correct solution: %s\n", Arrays.toString(toBeSorted));
                System.out.printf("     my solution: %s\n", Arrays.toString(sortedByMyCode));
                allGood = false;
                break;
            }
        }
        
        assertTrue(allGood);
    }
    
}
