import sys
input = sys.stdin.readline

n, m = map(int, input().split())
res = 0
if n ==1:
    res = 1
elif n == 2:
    res = min(4, (m-1)//2+1)
else:
    if m <= 6:
        res = min(4, m)
    else:
        res = (m-2)
print(res)