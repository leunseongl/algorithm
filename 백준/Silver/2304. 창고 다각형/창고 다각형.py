import sys
input = sys.stdin.readline

n = int(input())
li = []
bigl = 0
bigh = 0
for _ in range(n):
    l, h = map(int, input().split())
    li.append((l, h))
    if l>bigl:
        bigl = l
    if h>bigh:
        bigh = h
        idx = l

arr = [0] * (bigl+1)
for l, h in li:
    arr[l] = h

res = 0
tmp = 0
for i in range(idx+1):
    if arr[i] > tmp:
        tmp = arr[i]
    res += tmp

tmp = 0
for i in range(bigl, idx, -1):
    if arr[i]>tmp:
        tmp = arr[i]
    res += tmp

print(res)