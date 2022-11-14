import sys

def fx(x):
    cnt = 0
    tot = 0
    for i in please:
        if x >= i:
            cnt += 1
            tot += i
        else:
            cnt += 1
            tot += x
    if tot <= m:
        return True
    else:
        return False

n = int(sys.stdin.readline())
please = list(map(int, input().split()))
m = int(sys.stdin.readline())
please.sort()
lt = 0
rt = max(please)
res = 0

while lt <= rt:
    mid = (lt+rt)//2
    if fx(mid):
        res = mid
        lt = mid+1
    else:
        rt = mid-1

print(res)