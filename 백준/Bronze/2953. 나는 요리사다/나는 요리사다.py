large = 0
num = 0

for i in range(5):
    score = list(map(int, input().split()))
    if sum(score) > large:
        large = sum(score)
        num = i+1

print(num, large)