import sys
input = sys.stdin.readline

n = int(input())
info = list(map(int, input().split()))
res = []

for i in range(n):
    res.insert(i-info[i], i+1)

print(*res)