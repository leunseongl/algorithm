import heapq

n = int(input())
q = []
for _ in range(n):
    li = list(map(int, input().split()))
    if not q:
        for i in li:
            heapq.heappush(q, i)
    else:
        for i in li:
            if q[0] < i:
                heapq.heappush(q, i)
                heapq.heappop(q)
print(q[0])