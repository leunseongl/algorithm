import sys
input = sys.stdin.readline

n, k = map(int, input().split())
dp = [0] * (n+1)

for _ in range(k):
    i, t = map(int, input().split())
    for j in range(n, t-1, -1):
        dp[j] = max(dp[j], dp[j-t]+i)

print(dp[n])