def count(x):
    cnt = 1
    tot = 0
    for i in lecture:
        tot += i
        if tot>x:
            cnt += 1
            tot = i
    return cnt

n, m = map(int, input().split())
lecture = list(map(int, input().split()))
lt = 1
rt = sum(lecture)
res = 0

while lt<=rt:
    mid = (lt+rt)//2
    if count(mid) <= m and mid>=max(lecture):
        res = mid
        rt = mid-1
    else:
        lt = mid+1

print(res)
