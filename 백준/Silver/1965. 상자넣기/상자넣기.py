import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
li.insert(0,0)
dy = [0] * (n+1)
dy[1] = 1

for i in range(2, n+1):
    big = 0
    for j in range(i-1, 0, -1):
        if li[i]>li[j] and dy[j]>big:
            big = dy[j]
    dy[i] = big+1

print(max(dy))