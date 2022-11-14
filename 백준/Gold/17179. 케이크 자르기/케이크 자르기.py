import sys
input = sys.stdin.readline

def count(x):
    ep = 0
    cnt = 0
    for i in xy:
        if i-ep>=x:
            cnt += 1
            ep = i
    return cnt

n, m, l = map(int, input().split())
xy = [int(input()) for _ in range(m)] + [l]

for _ in range(n):
    k = int(input())
    lt = 1
    rt = l
    res = 0
    while lt<=rt:
        mid = (lt+rt)//2
        if count(mid)>k:
            res = mid
            lt = mid+1
        else:
            rt = mid-1
    print(res)
