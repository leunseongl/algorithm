import heapq

t = int(input())
for tc in range(1, t+1):
    q = []
    res = []
    n = int(input())
    for _ in range(n):
        do = input().split()
        if do[0] == '1':
            heapq.heappush(q, -int(do[1]))
        else:
            if len(q) > 0:
                tmp = -heapq.heappop(q)
                res.append(tmp)
            else:
                res.append(-1)
    print('#%d' %tc, *res)