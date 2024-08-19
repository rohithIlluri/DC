def longest_increasing_subsequence(nums):
    if not nums:
        return 0
    
    n = len(nums)
    # dp[i] represents the length of the LIS ending at index i
    dp = [1] * n
    
    # Compute LIS for each index
    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j]:
                dp[i] = max(dp[i], dp[j] + 1)
    
    # Return the maximum value in dp, which is the length of the LIS
    return max(dp)

# Function to reconstruct the LIS
def reconstruct_lis(nums):
    if not nums:
        return []
    
    n = len(nums)
    dp = [1] * n
    prev = [-1] * n  # To store the previous index in the LIS
    
    # Compute LIS and keep track of previous indices
    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j] and dp[j] + 1 > dp[i]:
                dp[i] = dp[j] + 1
                prev[i] = j
    
    # Find the index of the last element in the LIS
    last_index = dp.index(max(dp))
    
    # Reconstruct the LIS
    lis = []
    while last_index != -1:
        lis.append(nums[last_index])
        last_index = prev[last_index]
    
    return lis[::-1]  # Reverse the list to get the correct order

# Example usage
nums = [10, 9, 2, 5, 3, 7, 101, 18]
lis_length = longest_increasing_subsequence(nums)
lis = reconstruct_lis(nums)

print(f"Length of Longest Increasing Subsequence: {lis_length}")
print(f"Longest Increasing Subsequence: {lis}")