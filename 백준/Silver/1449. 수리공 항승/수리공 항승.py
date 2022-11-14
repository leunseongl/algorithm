import sys
input = sys.stdin.readline
n, l = map(int, input().split())
li = list(map(int, input().split()))
li.sort()
cur = li[0]
cnt = 1

for i in li[1:]:
    if i in range(cur, cur + l):
        continue
    else:
        cur = i
        cnt += 1

print(cnt)