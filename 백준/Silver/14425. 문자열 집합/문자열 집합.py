import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
n_li = set([sys.stdin.readline().rstrip() for _ in range(n)])
cnt = 0

for _ in range(m):
    tmp = sys.stdin.readline().rstrip()
    if tmp in n_li:
        cnt += 1

print(cnt)
