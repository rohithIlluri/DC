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


def reverse_string(s):
    return s[::-1]

# Test the function
if __name__ == "__main__":
    string = "hello"
    print(f"The reverse of '{string}' is '{reverse_string(string)}'")


def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

# Test the function
if __name__ == "__main__":
    number = 5
    print(f"The factorial of {number} is {factorial(number)}")



def is_palindrome(s):
    return s == s[::-1]

# Test the function
if __name__ == "__main__":
    string = "racecar"
    print(f"Is '{string}' a palindrome? {is_palindrome(string)}")


def fizz_buzz(n):
    result = []
    for i in range(1, n + 1):
        if i % 3 == 0 and i % 5 == 0:
            result.append("FizzBuzz")
        elif i % 3 == 0:
            result.append("Fizz")
        elif i % 5 == 0:
            result.append("Buzz")
        else:
            result.append(str(i))
    return ", ".join(result)

# Test the function
if __name__ == "__main__":
    number = 15
    print(f"FizzBuzz up to {number}: {fizz_buzz(number)}")
