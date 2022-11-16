t = int(input())
for tc in range(1, t+1):
    n, k = map(int, input().split())
    dp = [0] * (k+1)
    for _ in range(n):
        v, c = map(int, input().split())
        for j in range(k, v-1, -1):
            dp[j] = max(dp[j], dp[j-v]+c)
    print('#%d' %tc, max(dp))