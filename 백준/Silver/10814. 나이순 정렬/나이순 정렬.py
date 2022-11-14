import sys

n = int(sys.stdin.readline())
mem = []

for _ in range(n):
    mem.append(list(sys.stdin.readline().split()))
mem.sort(key = lambda x:int((x[0])))

for i in range(n):
    print(mem[i][0], mem[i][1])
