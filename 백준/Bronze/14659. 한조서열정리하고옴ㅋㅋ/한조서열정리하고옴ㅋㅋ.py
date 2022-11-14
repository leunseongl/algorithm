import sys

n = int(sys.stdin.readline())
hanzo = list(map(int, sys.stdin.readline().split()))
cnt = 0
start = 0
res = 0

for i in hanzo:
    if i>start:
        start = i
        cnt = 0
    else:
        cnt += 1
    res = max(res, cnt)
print(res)