import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
s = set(arr)
s = list(s)
s.sort()
dic = {}

for i in range(len(s)):
    dic[s[i]] = i

for i in arr:
    print(dic[i], end=' ')