def meter(x):
    tmp = 0
    for i in tree:
        if i>x:
            tmp += i-x
    return tmp

n, m = map(int, input().split())
tree = list(map(int, input().split()))

lt = 1
rt = max(tree)
res = 0

while lt <= rt:
    mid = (lt+rt)//2
    if meter(mid) >= m:
        res = mid
        lt = mid+1
    else:
        rt = mid-1
print(res)