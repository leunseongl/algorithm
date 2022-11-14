import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
li = set(li)
li = list(sorted(li))
print(*li)