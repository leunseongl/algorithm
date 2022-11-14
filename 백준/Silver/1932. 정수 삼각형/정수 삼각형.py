import sys
input = sys.stdin.readline
n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    for j in range(len(li[i])):
        if j == 0:
            li[i][j] = li[i-1][j] + li[i][j]
        elif j == len(li[i])-1:
            li[i][j] = li[i-1][j-1] + li[i][j]
        else:
            li[i][j] = max(li[i-1][j-1], li[i-1][j]) + li[i][j]

print(max(li[n-1]))
