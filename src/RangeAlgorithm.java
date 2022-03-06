import java.util.Arrays;
import java.util.Random;

public class RangeAlgorithm {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        
        //N Sizes of different arrays to use for creating different arrays with N amount of elements
        int[] nIntegerSizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000, 
                                1000000, 2000000,4000000,8000000,16700000,33000000,65000000,130000000,260000000};
        
                                        
        int amountOfN = nIntegerSizes.length;

        //Creating a container for the arrays with N sizes
        int[][] integerRandomNumbers = new int[amountOfN][];
        
        //Fill the container with N sized arrays.
        //Each array will have N amount of random numbers
        for (int i = 0; i < amountOfN; i++) {
            //random.ints(ArraySize, Minimum Random Number, Maximum Random Number)
            integerRandomNumbers[i] = random.ints(nIntegerSizes[i], -1000000, 1000000).toArray();
        }

        //Measure range 1 algorithm
        System.out.printf("%30s","Range Algorithm 1\n");
        System.out.printf("%16s|%16s\n", "Array Size", "Time in ms");
        
        //Call RangeAlgorithm1 for each array with N sizes and measure time
        for (int i = 0; i < amountOfN; i++) {
            //Start Timer
            long startTime = System.currentTimeMillis();
            //Call algorithm On current Array with N size
            rangeAlgorithm1(integerRandomNumbers[i]);
            //Stop timer
            long stopTime = System.currentTimeMillis();
            //Computer how long it took
            long elapsedTime = stopTime - startTime;
            //Print out results: N size integer and elapsed time for algorithm to finish it
            System.out.printf("%15d | %15d \n", nIntegerSizes[i], elapsedTime);
        }
        
        //Same Process as range1 algorithm but for range 2 algorithm
        System.out.printf("\n\n%30s","Range Algorithm 2\n");
        System.out.printf("%16s|%16s\n", "Array Size", "Time in ms");
        for (int i = 0; i < amountOfN; i++) {
            long startTime = System.currentTimeMillis();
            rangeAlgorithm2(integerRandomNumbers[i]);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            
            System.out.printf("%15d | %15d \n", nIntegerSizes[i], elapsedTime);
        }
        
        //Same Process as range1 algorithm but for range 3 algorithm
        System.out.printf("\n\n%30s","Range Algorithm 3\n");
        System.out.printf("%16s|%16s\n", "Array Size", "Time in ms");
        for (int i = 0; i < amountOfN; i++) {
            long startTime = System.currentTimeMillis();
            rangeAlgorithm3(integerRandomNumbers[i]);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            
            System.out.printf("%15d | %15d \n", nIntegerSizes[i], elapsedTime);
        }
    }

    //Implementation of range 1 algorithm
    public static int rangeAlgorithm1(int [] numbers){
        int maxDiff = 0;
        int diff = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }

    //Implementation of range 2 algorithm
    public static int rangeAlgorithm2(int [] numbers){
        int maxDiff = 0;
        int diff = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }

    //Implementation of range 3 algorithm
    public static int rangeAlgorithm3(int [] numbers){
        int max = numbers[0];
        int min = max;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max - min;
    }
}
