import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    coin = list(map(int, input().split()))
    m = int(input())
    tmp = [0] * (m+1)
    tmp[0] = 1
    for i in coin:
        for j in range(i, m+1):
            if tmp[j]>0:
                tmp[j] = tmp[j-i] + tmp[j]
            else:
                tmp[j] = tmp[j-i]
    print(tmp[m])
