def max_product(arr):
    if len(arr) < 2:
        return "No pairs exist"
    
    max1 = max2 = float('-inf')
    for num in arr:
        if num > max1:
            max2 = max1
            max1 = num
        elif num > max2:
            max2 = num
    
    return max1 * max2

# Test the function
if __name__ == "__main__":
    array = [1, 20, 3, 10, 5]
    print(f"The maximum product is: {max_product(array)}")
