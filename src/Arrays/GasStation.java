package Arrays;

/*
 Gas Station

 Approach:
 - Traverse the gas stations once while maintaining the current fuel in the tank.
 - At each station, calculate the net fuel gained by subtracting the travel cost from the available gas.
 - Add this net gain to both the current tank and the total fuel.
 - If the current tank becomes negative, the current starting station cannot complete the journey.
 - Since none of the stations between the current starting station and the current station can be valid starting points, update the starting station to the next index and reset the current tank to zero.
 - After traversing all the stations, check whether the total fuel is non-negative.
 - If the total fuel is negative, completing the circuit is impossible; otherwise, return the recorded starting station.

 Why This Works:

 - If the current tank becomes negative at any station, every station between the current starting station and the failure point can safely be discarded as a possible starting station.
 - A valid journey is only possible if the total amount of gas is greater than or equal to the total travel cost.
 - Since the array is traversed only once, the first valid starting station found after eliminating invalid candidates is the unique answer.


 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - Only a few variables are used.
*/

public class GasStation {

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];

            total += diff;
            tank += diff;

            // Cannot reach the next station
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }


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
