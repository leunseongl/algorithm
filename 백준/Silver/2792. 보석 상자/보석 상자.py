import sys
input = sys.stdin.readline

def count(x):
    cnt = 0
    for i in jew:
        if i%x == 0:
            cnt += i//x
        else:
            cnt += (i//x)+1
    return cnt

n, m = map(int, input().split())
jew = [int(input()) for _ in range(m)]
lt = 1
rt = max(jew)

while lt<=rt:
    mid = (lt+rt)//2
    if count(mid)>n:
        lt = mid+1
    else:
        rt = mid-1

print(lt)