import sys
input = sys.stdin.readline

n, k = map(int, input().split())
li = [list(map(int, input().split())) for _ in range(n)]
li.sort(key=lambda x:(x[1],x[2],x[3]), reverse=True)

for i in range(n):
    if li[i][0] == k:
        idx = i
for i in range(n):
    if li[idx][1:] == li[i][1:]:
        print(i+1)
        break