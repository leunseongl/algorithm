import sys

n = int(input())
li = []
for _ in range(n):
    li.append(int(sys.stdin.readline()))
li.sort()
for i in li:
    sys.stdout.write(str(i) + '\n')