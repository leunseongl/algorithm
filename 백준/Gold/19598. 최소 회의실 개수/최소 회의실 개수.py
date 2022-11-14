import sys
import heapq as hq

n = int(input())
meeting = []

for _ in range(n):
    s, e = map(int, input().split())
    meeting.append((s,e))

meeting.sort(key= lambda x: x[0])
cnt = 1
cur = [0]

for s, e in meeting:
    if s>=cur[0]:
        hq.heappop(cur)
    else:
        cnt += 1
    hq.heappush(cur, e)

print(cnt)