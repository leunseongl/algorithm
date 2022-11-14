import sys

def Count(x):
    cnt = 1
    ep = xy[0]
    for i in range(1, n):
        if xy[i]-ep >= x:
            cnt += 1
            ep = xy[i]
    return cnt

n, c = map(int, sys.stdin.readline().split())
xy = []
for _ in range(n):
    xy.append(int(sys.stdin.readline()))
xy.sort()
lt = 1
rt = max(xy)
res = 0

while lt <= rt:
    mid = (lt+rt)//2
    if Count(mid) >= c:
        res = mid
        lt = mid+1
    else:
        rt = mid-1
print(res)