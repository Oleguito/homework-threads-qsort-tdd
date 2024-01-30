import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSorter {
    
    public int[] sort(int[] array) {
        
        System.out.println("");
        
        ForkJoinPool pool = new ForkJoinPool();
        QuickSortTask task = new QuickSortTask(array, 0, array.length - 1);
        
        pool.invoke(task);
        
        return array;
    }
    
    private void swap(int[] array, int one, int another) {
        int temp = array[one];
        array[one] = array[another];
        array[another] = temp;
    }
    
    private class QuickSortTask extends RecursiveAction {
        
        private final int[] array;
        private final int from;
        private final int to;
        
        public QuickSortTask(int[] array, int from, int to) {
            this.array = array;
            this.from = from;
            this.to = to;
        }
        
        @Override
        protected void compute() {
            if(to - from < 1) {
                return;
            }
            int pivotValue = array[to];
            
            int i = from - 1;
            int j = from;
            
            while(true) {
                if(array[j] >= pivotValue) {
                    j++;
                    if(j >= to) break;
                    continue;
                }
                i++;
                swap(array, i, j);
                j++;
                if(j >= to) break;
            }
            
            i++;
            swap(array, i, to);
            
            QuickSortTask left = new QuickSortTask(array, from, i - 1);
            QuickSortTask right = new QuickSortTask(array, i + 1, to);
            invokeAll(left,right);
        }
    }
}
