n, k = map(int, input().split())
num = list(str(input()))
stack = []

for i in num:
    while stack and k>0 and stack[-1]<i:
        stack.pop()
        k-=1
    stack.append(i)

if k != 0:
    stack = stack[:-k]

for i in stack:
    print(i, end='')