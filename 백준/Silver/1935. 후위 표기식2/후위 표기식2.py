import sys

n = int(sys.stdin.readline())
a = input()
num_li = []
stack = []
for _ in range(n):
    num_li.append(int(sys.stdin.readline()))

for i in a:
    if i.isalpha():
        stack.append(num_li[ord(i)-ord('A')])
    else:
        tmp1 = float(stack.pop())
        tmp2 = float(stack.pop())
        if i == '+':
            stack.append(tmp2+tmp1)
        elif i == '-':
            stack.append(tmp2-tmp1)
        elif i == '*':
            stack.append(tmp2*tmp1)
        else:
            stack.append(tmp2/tmp1)

print('%.2f' %stack[0])