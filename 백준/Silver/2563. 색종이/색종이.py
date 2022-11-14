import sys
input = sys.stdin.readline

n = int(input())
paper = [[0] * 101 for _ in range(101)]
cnt = 0

for _ in range(n):
    a, b = map(int, input().split())
    for i in range(10):
        for j in range(10):
            if paper[i+a][j+b] == 0:
                paper[i+a][j+b] = 1
                cnt += 1
print(cnt)
