import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    li = []
    n = int(input())
    for _ in range(n):
        a, b = map(int, input().split())
        li.append((a, b))
    li.sort()
    meeting = li[0][1]
    cnt = 1
    for m in range(1, n):
        if li[m][1]<meeting:
            cnt += 1
            meeting = li[m][1]
    print(cnt)
