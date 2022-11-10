import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    li = list(map(int, input().split()))
    li = list(reversed(li))
    big = li[0]
    profit = 0
    for i in range(1, n):
        if li[i] >= big:
            big = li[i]
        else:
            profit += (big-li[i])
    print(profit)