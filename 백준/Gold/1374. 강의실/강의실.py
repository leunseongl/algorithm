import sys
input = sys.stdin.readline
import heapq as hq

n = int(input())
lecture = []

for _ in range(n):
    num, s, e = map(int, input().split())
    lecture.append((num,s,e))

lecture.sort(key=lambda x:x[1])
cnt = 1
heap = [0]

for _, s, e in lecture:
    if s>=heap[0]:
        hq.heappop(heap)
    else:
        cnt +=1
    hq.heappush(heap, e)

print(cnt)