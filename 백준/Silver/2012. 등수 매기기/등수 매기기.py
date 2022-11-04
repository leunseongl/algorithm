import sys
input = sys.stdin.readline

n = int(input())
rank = [int(input()) for _ in range(n)]
rank.insert(0,0)
rank.sort()

res = 0
for i in range(1, n+1):
    res += abs(rank[i]-i)

print(res)