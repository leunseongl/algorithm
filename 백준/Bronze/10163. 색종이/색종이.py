import sys
input = sys.stdin.readline

n = int(input())
area = [[0]*1001 for _ in range(1001)]

for num in range(1, n+1):
    x, y, w, h = map(int, input().split())
    for i in range(x, w+x):
        for j in range(y, h+y):
            area[i][j] = num

cnt = [0] * (n+1)
for i in range(1001):
    for j in range(1001):
        if area[i][j]:
            cnt[area[i][j]] +=1

for i in range(1, n+1):
    print(cnt[i])