def count(x):
    cnt = 0
    for i in snack:
        cnt += i//x
    return cnt

m, n = map(int, input().split())
snack = list(map(int, input().split()))
lt = 1
rt = max(snack)
res = 0

while lt<=rt:
    mid = (lt+rt)//2
    if count(mid)>=m:
        lt = mid+1
        res = mid
    else:
        rt = mid-1
print(res)