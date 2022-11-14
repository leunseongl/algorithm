import sys
input = sys.stdin.readline

def count(x):
    cnt = 0
    for i in drink:
        cnt += i//x
    return cnt

n, k = map(int, input().split())
drink = [int(input()) for _ in range(n)]
lt = 1
rt = max(drink)
res = 0

while lt<=rt:
    mid = (lt+rt)//2
    if count(mid) >= k:
        res = mid
        lt = mid+1
    else:
        rt = mid-1

print(res)