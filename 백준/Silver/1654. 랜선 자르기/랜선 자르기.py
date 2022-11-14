def Count(x):
    cnt = 0
    for i in line:
        cnt += i//x
    return cnt

k, n = map(int, input().split())
line = []
for _ in range(k):
    line.append(int(input()))

lt = 1
rt = max(line)
res = 0

while lt <= rt:
    mid = (lt+rt)//2
    if Count(mid) >= n:
        res = mid
        lt = mid+1
    else:
        rt = mid-1

print(res)