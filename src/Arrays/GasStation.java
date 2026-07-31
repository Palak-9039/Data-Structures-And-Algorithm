package Arrays;

/*
 Gas Station (Brute Force with Skipping)

 Approach:
 - Try every gas station as the possible starting point.
 - For each starting station, simulate the complete journey while maintaining the current fuel.
 - At every station, add the available gas and subtract the cost required to reach the next station.
 - If the fuel becomes negative, the current starting station cannot complete the circuit.
 - Since every station visited before failure also cannot be a valid starting point, skip those stations and continue from the next possible candidate.
 - If a complete circle of n stations is successfully traversed, return the starting station.
 - If no starting station completes the circuit, return -1.

 Why This Works:

 - A valid starting station must be able to complete the entire circular journey without the fuel ever becoming negative.
 - If the journey fails after visiting a certain number of stations, all the stations visited before the failure can safely be skipped as potential starting points.
 - By simulating each valid candidate, we eventually find the unique starting station if it exists.

 Time Complexity: O(n^2) in the worst case.
 - For each starting station, we may traverse almost the entire array.

 Space Complexity: O(1)
 - Only a few variables are used for simulation.
*/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int right = 0;
        int count = 0;
        int left = 0;

        for (left = 0; left < n; left++) {
            int fuel = 0;
            count = 0;
            right = left;

            while (count < n) {
                fuel += gas[right];
                fuel -= cost[right];

                if (fuel < 0) {
                    left = left + count;
                    break;
                }

                right = (right + 1) % n;
                count++;
            }
            if (count == n) return left;
        }
        return -1;
    }
}
