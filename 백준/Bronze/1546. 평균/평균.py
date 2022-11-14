k = int(input())
numbers = list(map(int, input().split()))
m = max(numbers)
plus = 0
for i in numbers:
    b = i/m*100
    plus += b
    avg = plus/len(numbers)
print(avg)