// https://practice.geeksforgeeks.org/problems/5ae4f296db3e6bb74641c4087d587b6f89d9d135/1


class Solution
{
    public static long totalTime(int n,int arr[],int time[])
    {
    // Create a map to store the last pick time of each element
    Map<Integer, Integer> lastPickTimes = new HashMap<>();

    // Initialize the total time to zero
    long totalTime = 0;

    // Iterate over the array of elements
    for (int i = 0; i < n; i++) {
        /* If the element has not been picked before, add it to the map with the current time 
        as its last pick time*/
        if (!lastPickTimes.containsKey(arr[i])) {
            lastPickTimes.put(arr[i], (int) totalTime);
        }
        /* If the element has been picked before, update the total time based on the last pick time and 
        the time required before it can be picked again*/
        else {
            totalTime = Math.max(totalTime, lastPickTimes.get(arr[i]) + time[arr[i] - 1]);
            lastPickTimes.put(arr[i], (int) totalTime);
        }

        // Increment the total time by one to simulate the time taken to pick the current element
        totalTime++;
    }

    // Subtract one from the total time to account for the final increment
    return totalTime - 1;
        
    }

}
