import sys
input = sys.stdin.readline
import heapq as hq

heap = []

n = int(input())
for _ in range(n):
    a = int(input())
    if a == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(hq.heappop(heap)[1])
    else:
        hq.heappush(heap, (abs(a),a))