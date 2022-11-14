import sys
input = sys.stdin.readline

n, k = map(int, input().split())
girl = [0] * 7
boy = [0] * 7
for _ in range(n):
    s, y = map(int, input().split())
    if s == 0:
        girl[y] += 1
    if s == 1:
        boy[y] += 1

for i in range(1, 7):
    if girl[i] % k == 0:
        girl[i] = girl[i]//k
    else:
        girl[i] = girl[i]//k+1
    if boy[i] % k == 0:
        boy[i] = boy[i]//k
    else:
        boy[i] = boy[i]//k+1

print(sum(girl) + sum(boy))