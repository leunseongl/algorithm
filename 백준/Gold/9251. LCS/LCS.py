import sys
input = sys.stdin.readline
a = input().rstrip()
b = input().rstrip()
g = [[0 for _ in range(len(a)+1)] for _ in range(len(b)+1)]

for i in range(1, len(b)+1):
    for j in range(1, len(a)+1):
        if b[i-1] == a[j-1]:
            g[i][j] = g[i-1][j-1]+1
        else:
            g[i][j] = max(g[i-1][j], g[i][j-1])
print(g[len(b)][len(a)])
