from collections import deque

n, k = map(int, input().split())
big = 100000
dis = [0] * (big+1)
ch = [0] * (big+1)
dis[n] = 0
ch[n] = 1
dq = deque()
dq.append(n)

while dq:
    now = dq.popleft()
    if now == k:
        print(dis[now])
    else:
        for i in(now-1, now+1, now*2):
            if 0<=i<=big and ch[i] == 0:
                dis[i] = dis[now]+1
                ch[i] = 1
                dq.append(i)
