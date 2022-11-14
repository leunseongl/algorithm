import sys
input = sys.stdin.readline
n = int(input())
stack = []
res = []
cur = 1
flag = 0

for _ in range(n):
    a = int(input())
    while cur<=a:
        stack.append(cur)
        res.append("+")
        cur += 1
    if stack[-1] != a:
        print("NO")
        flag = 1
        break
    else:
        stack.pop()
        res.append("-")

if flag == 0:
    for i in res:
        print(i)