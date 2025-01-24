

# Algorithm to Find the Lower Bound

To find the **lower bound** of an element in a sorted array using binary search, you need to determine the first position in the array where the element is not less than the target. 
The lower bound is essentially the smallest index `i` such that `arr[i] >= target`. If no such index exists, it returns the position where the target could be inserted while maintaining the sorted order.

1. **Initialization**:
   - Set `start` to `0` and `end` to `n - 1` (where `n` is the length of the array).
   - Initialize `sol` to `end + 1` to handle cases where the target is greater than all elements.

2. **Binary Search Loop**:
   - Calculate the middle index `mid` as `(start + end) / 2`.
   - If the `target` is less than or equal to `arr[mid]`, update `sol` to `mid` (as `mid` might be the lower bound) and move the `end` pointer to `mid - 1` to search the left half.
   - If the `target` is greater than `arr[mid]`, move the `start` pointer to `mid + 1` to search the right half.

3. **Return**:
   - After exiting the loop, `sol` will contain the index of the lower bound of `target`.

### Code Implementation

```java
class Solution {

    public int binarySearch(int[] arr, int start, int end, int target) {
        int sol = end + 1; // Initialize solution as end + 1
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= arr[mid]) {
                sol = mid;  // Potential lower bound found
                end = mid - 1; // Search the left half
            } else {
                start = mid + 1; // Search the right half
            }
        }
        return sol;
    }

    public int findLowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = binarySearch(nums, start, end, target);
        return index;
    }
}
```

### Explanation

- **Initialization**: `sol` is initially set to `end + 1`, which acts as a default position (beyond the last element) in case all elements are smaller than the target.
- **Binary Search**: 
  - If `target <= arr[mid]`, update `sol` to `mid` because `mid` might be the first position where `arr[mid] >= target`.
  - If `target > arr[mid]`, move to the right half of the array.
- **Return**: The function returns `sol`, which holds the index of the first element that is greater than or equal to the target.

### Edge Cases Handled

- **Target smaller than all elements**: Returns `0` because the lower bound is the first element.
- **Target greater than all elements**: Returns `nums.length` because the target is greater than all elements.
- **Target exactly matches an element**: Returns the index of the first occurrence of the target.

# Algorithm to Find the Upper Bound

To find the **upper bound** of an element in a sorted array using binary search, you need to determine the first position in the array where the element is strictly greater than the target. The upper bound is essentially the smallest index `i` such that `arr[i] > target`. If no such index exists, it returns the position where the target could be inserted while maintaining the sorted order.

1. **Initialization**:
   - Set `start` to `0` and `end` to `n - 1` (where `n` is the length of the array).
   - Initialize `sol` to `end + 1` to handle cases where the target is greater than or equal to all elements.

2. **Binary Search Loop**:
   - Calculate the middle index `mid` as `(start + end) / 2`.
   - If the `target` is less than `arr[mid]`, update `sol` to `mid` (as `mid` might be the upper bound) and move the `end` pointer to `mid - 1` to search the left half.
   - If the `target` is greater than or equal to `arr[mid]`, move the `start` pointer to `mid + 1` to search the right half.

3. **Return**:
   - After exiting the loop, `sol` will contain the index of the upper bound of `target`.

### Code Implementation

```java
class Solution {

    public int binarySearchUpperBound(int[] arr, int start, int end, int target) {
        int sol = end + 1; // Initialize solution as end + 1
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < arr[mid]) {
                sol = mid;  // Potential upper bound found
                end = mid - 1; // Search the left half
            } else {
                start = mid + 1; // Search the right half
            }
        }
        return sol;
    }

    public int findUpperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = binarySearchUpperBound(nums, start, end, target);
        return index;
    }
}
```

### Explanation

- **Initialization**: `sol` is initially set to `end + 1`, which acts as a default position (beyond the last element) in case all elements are less than or equal to the target.
- **Binary Search**:
  - If `target < arr[mid]`, update `sol` to `mid` because `mid` might be the first position where `arr[mid] > target`.
  - If `target >= arr[mid]`, move to the right half of the array.
- **Return**: The function returns `sol`, which holds the index of the first element that is strictly greater than the target.

### Edge Cases Handled

- **Target greater than all elements**: Returns `nums.length` because the target is less than or equal to all elements.
- **Target smaller than all elements**: Returns `0` because the upper bound is the first element.
- **Target exactly matches an element**: Returns the index of the first element that is greater than the target.


# Algorithm to Find the Floor and Ceil of an Element in a Sorted Array

**1. Initialization**:
   - Set `start` to `0` and `end` to `n - 1` (where `n` is the length of the array).
   - Initialize two variables `solFloor` and `solCeil` to `-1`. These will store the floor and ceil values, respectively.

**2. Finding the Floor**:
   - Use a binary search approach:
     - Calculate the middle index `mid` as `(start + end) / 2`.
     - If `arr[mid]` is less than or equal to `target`, update `solFloor` to `arr[mid]` (as it might be the floor) and move the `start` pointer to `mid + 1` to search the right half.
     - If `arr[mid]` is greater than `target`, move the `end` pointer to `mid - 1` to search the left half.
   - Repeat until `start` exceeds `end`.

**3. Finding the Ceil**:
   - Again, use a binary search approach:
     - Calculate the middle index `mid` as `(start + end) / 2`.
     - If `arr[mid]` is greater than or equal to `target`, update `solCeil` to `arr[mid]` (as it might be the ceil) and move the `end` pointer to `mid - 1` to search the left half.
     - If `arr[mid]` is less than `target`, move the `start` pointer to `mid + 1` to search the right half.
   - Repeat until `start` exceeds `end`.

**4. Return the Results**:
   - Return an array containing the values of `solFloor` and `solCeil`.

### Code Implementation

```java
class Solution {

    // Function to find the ceiling of target
    public int ceiling(int[] arr, int start, int end, int target) {
        int sol = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                sol = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return sol;
    }

    // Function to find the floor of target
    public int floor(int[] arr, int start, int end, int target) {
        int sol = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                sol = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return sol;
    }

    // Function to get both floor and ceiling of target
    public int[] getFloorAndCeil(int x, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int indexFloor = floor(arr, start, end, x);
        int indexCeil = ceiling(arr, start, end, x);

        int[] solution = {indexFloor, indexCeil};
        return solution;
    }
}
```

### Explanation

- **Ceiling Calculation**:
  - The `ceiling` function finds the smallest element in the array that is greater than or equal to the target.
  - It updates `sol` whenever a potential ceiling is found and moves to the left half to find a smaller but valid ceiling.

- **Floor Calculation**:
  - The `floor` function finds the largest element in the array that is less than or equal to the target.
  - It updates `sol` whenever a potential floor is found and moves to the right half to find a larger but valid floor.

- **getFloorAndCeil**:
  - This function calls both `floor` and `ceiling` functions to get the floor and ceiling values and returns them as an array.

### Edge Cases Handled
- **Target smaller than all elements**: The floor will be `-1`, and the ceiling will be the smallest element in the array.
- **Target greater than all elements**: The ceiling will be `-1`, and the floor will be the largest element in the array.
- **Target exactly matches an element**: Both floor and ceiling will be that element.