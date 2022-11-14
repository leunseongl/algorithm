import sys
input = sys.stdin.readline

n, m = map(int, input().split())
li = list(map(int, input().split()))
cnt = 0
p1 = 0
p2 = 1
tot = li[0]

while True:
    if tot<m:
        if p2<n:
            tot += li[p2]
            p2 += 1
        else:
            break
    elif tot == m:
        cnt += 1
        tot -= li[p1]
        p1 += 1
    else:
        tot -= li[p1]
        p1 += 1

print(cnt)