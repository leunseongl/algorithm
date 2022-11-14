import sys
input = sys.stdin.readline

def Count(x):
    cnt = 1
    tot = 0
    for i in lecture:
        if tot+i > x:
            cnt += 1
            tot = i
        else:
            tot += i
    return cnt

n, m = map(int, input().split())
lecture = list(map(int, input().split()))
large = max(lecture)

lt = max(lecture)
rt = sum(lecture)
res = 0

while lt <= rt:
    mid = (lt+rt)//2
    if mid >= large and Count(mid) <= m:
        res = mid
        rt = mid-1
    else:
        lt = mid+1

print(res)
