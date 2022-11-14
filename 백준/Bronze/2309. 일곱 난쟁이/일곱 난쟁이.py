import sys

nan = [int(sys.stdin.readline().rstrip()) for _ in range(9)]
tot = sum(nan)

for i in range(9):
    for j in range(i+1, 9):
        if tot - (nan[i]+nan[j]) == 100:
            num1, num2 = nan[i], nan[j]
            break

nan.remove(num1)
nan.remove(num2)
nan.sort()

for i in nan:
    print(i)