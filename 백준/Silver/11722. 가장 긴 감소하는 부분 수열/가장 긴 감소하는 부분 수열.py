import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
li.insert(0,0)
dp = [0] * (n+1)
dp[1] = 1

for i in range(2, n+1):
    tmp = 0
    for j in range(i-1, 0, -1):
        if li[i]<li[j] and dp[j]>tmp:
            tmp = dp[j]
    dp[i] = tmp+1

print(max(dp))