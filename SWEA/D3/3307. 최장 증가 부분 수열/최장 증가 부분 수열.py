t = int(input())
for tc in range(1, t+1):
    n = int(input())
    li = list(map(int, input().split()))
    li.insert(0,0)
    dp = [0] * (n+1)
    dp[1] = 1
    for i in range(2, n+1):
        big = 0
        for j in range(i-1, 0, -1):
            if li[j]<li[i] and dp[j]>big:
                big = dp[j]
        dp[i] = big+1
    print('#%d' %tc, max(dp))