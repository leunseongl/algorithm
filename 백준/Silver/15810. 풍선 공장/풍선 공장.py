import sys
input = sys.stdin.readline

n, m = map(int, input().split())
time = list(map(int, input().split()))
lt = min(time)
rt = max(time)*m
res = 0

while lt<=rt:
    mid = (lt+rt)//2
    cnt = 0
    for i in time:
        cnt += mid//i
    if cnt >= m:
        res = mid
        rt = mid-1
    else:
        lt = mid+1

print(res)