import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    dq = deque()
    dq.append([home[0], home[1]])
    while dq:
        x, y = dq.popleft()
        if abs(x-rock[0]) + abs(y-rock[1]) <= 1000:
            print("happy")
            return
        for i in range(cu_n):
            if visit[i] == 0 :
                cu1, cu2 = cu[i]
                if abs(x-cu1) + abs(y-cu2) <= 1000:
                    dq.append([cu1, cu2])
                    visit[i] = 1
    print("sad")
    return

t = int(input())
for _ in range(t):
    cu_n = int(input())
    home = [int(x) for x in input().split()]
    cu = []
    for _ in range(cu_n):
        a, b = map(int, input().split())
        cu.append([a,b])
    rock = [int(x) for x in input().split()]
    visit = [0] * (cu_n)
    bfs()