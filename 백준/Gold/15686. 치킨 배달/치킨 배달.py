import sys
input = sys.stdin.readline
from itertools import combinations

def chick_dis(v):
    tot = 0
    for i in home:
        x1, y1 = i
        dis = 2147000000
        for k in v:
            x2, y2 = k
            dis = min(dis, abs(x1-x2) + abs(y1-y2))
        tot += dis
    return tot

n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]
home = []
chicken = []
res = 2147000000

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            home.append((i, j))
        elif city[i][j] == 2:
            chicken.append((i, j))

cur = combinations(chicken, m)

for i in cur:
    res = min(res, chick_dis(i))

print(res)