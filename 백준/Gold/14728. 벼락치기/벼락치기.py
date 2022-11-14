import sys
input = sys.stdin.readline

n, t = map(int, input().split())
dp = [0] * (t+1)

for _ in range(n):
    k, s = map(int, input().split())
    for i in range(t, k-1, -1):
        dp[i] = max(dp[i-k]+s,dp[i])

print(dp[t])