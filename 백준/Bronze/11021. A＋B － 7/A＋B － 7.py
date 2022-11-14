import sys
a = int(input())
count = 0
for i in range(a):
  count += 1
  b,c = map(int, sys.stdin.readline().split())
  print("Case #%d:" %count, b+c)