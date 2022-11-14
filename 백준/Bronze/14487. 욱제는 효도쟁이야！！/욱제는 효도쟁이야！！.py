n = int(input())
cost = list(map(int, input().split()))
cost.sort()
res = 0
for i in range(n-1):
    res += cost[i]
print(res)