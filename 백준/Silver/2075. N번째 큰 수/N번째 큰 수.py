import heapq

n = int(input())
q = []
for _ in range(n):
    li = list(map(int, input().split()))
    if len(q) < n:
        for i in li:
            heapq.heappush(q, i)
    else:
        for i in li:
            if i<=q[0]:
                continue
            else:
                heapq.heappop(q)
                heapq.heappush(q, i)
print(q[0])