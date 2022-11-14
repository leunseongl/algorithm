import sys

n, m = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))
tot = [0]
tmp = 0
for i in num:
    tmp += i
    tot.append(tmp)

for _ in range(m):
    i, j = map(int, sys.stdin.readline().split())
    print(tot[j] -  tot[i-1])