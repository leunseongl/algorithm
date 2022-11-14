import heapq as hq
import sys

n = int(sys.stdin.readline().rstrip())
li = []

for _ in range(n):
    a = int(sys.stdin.readline().rstrip())
    if a == 0:
        if len(li) == 0:
            print(0)
        else:
            print(-hq.heappop(li))
    else:
        hq.heappush(li, -a)