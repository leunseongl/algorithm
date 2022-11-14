import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline

def BFS(v):
    dq = deque([v])
    while dq:
        tmp = dq.popleft()
        if tmp == g:
            return dis[g]
        for i in(tmp+u, tmp-d):
            if 0<i<=f and ch[i] == 0 and i != tmp:
                ch[i] = 1
                dis[i] = dis[tmp]+1
                dq.append(i)
    return "use the stairs"


f, s, g, u, d = map(int, input().split())
ch = [0]*(f+1)
ch[s] = 1
dis = [0]*(f+1)
print(BFS(s))
