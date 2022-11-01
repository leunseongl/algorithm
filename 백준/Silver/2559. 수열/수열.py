import sys
input = sys.stdin.readline

n, k = map(int, input().split())
li = list(map(int, input().split()))
start = 0
res = []
res.append(sum(li[:k]))

for i in range(n-k):
    res.append(res[i]-li[i] + li[k+i])

print(max(res))