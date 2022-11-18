import sys
input = sys.stdin.readline

def count(x):
    cnt = 0
    for i in t:
        cnt += x//i
    return cnt

n, m = map(int, input().split())
t = [int(input()) for _ in range(n)]
lt = 1
rt = m*max(t)
res = 0

while lt<=rt:
    mid = (lt+rt)//2
    if count(mid) >= m:
        res = mid
        rt = mid-1
    else:
        lt = mid+1

print(res)