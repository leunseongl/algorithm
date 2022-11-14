import sys
input = sys.stdin.readline

n = int(input())
area = [[0]*1001 for _ in range(1001)]
minx, miny = 1001, 1001
maxx, maxy = 0, 0

for num in range(1, n+1):
    x, y, w, h = map(int, input().split())
    for i in range(x, w+x):
        for j in range(y, h+y):
            area[i][j] = num
    minx, miny = min(x, minx), min(y, miny)
    maxx, maxy = max(x+w, maxx), max(y+h, maxy)

cnt = [0] * (n+1)
for i in range(minx, maxx):
    for j in range(miny, maxy):
        if area[i][j]:
            cnt[area[i][j]] +=1

for i in range(1, n+1):
    print(cnt[i])