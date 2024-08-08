#Problem -1  TWO SUM - Arrays


#Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
#You may assume that each input would have exactly one solution, and you may not use the same element twice.
#You can return the answer in any order.

def two_sums(nums, target):
    for i in range(len(nums)):   #outer loop to iterate each element
        for j in range(i +1, len(nums)): #inner loop iterating i+1 to rest of the elements
            if nums[i] + nums[j] == target:
                return [i,j]
            
nums = [ 2,7,8,12,15]
target = 9
result = two_sums(nums,target)
print(f"Indicies of the element that sum to {target}:{result}")


#class and method signature
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        nums_to_index = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in nums_to_index:
                return[nums_to_index[complement],i]
            
            nums_to_index[num] = i



#Problem 2  - Check the given number is a palindrome or not 

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
# if x is negative or ends with 0 but is not 0 itself : return false 
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        original = x
        reversed_number = 0 

        while x > 0:
            #get the last digit 
            digit = x % 10
            #append to reversed num
            reversed_number = reversed_number *10 + digit
            #remove the last digit from x 
            x //= 10

        return original == reversed_number