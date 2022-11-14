n = int(input())
weight = []
for i in range(n):
    weight.append(int(input()))
weight.sort(reverse=True)
res = []
for j in range(1, n+1):
    res.append(weight[j-1]*j)
print(max(res))
