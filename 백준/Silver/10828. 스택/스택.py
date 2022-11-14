import sys
def push(x):
    stack.append(x)
def pop():
    if len(stack) == 0:
        return -1
    else:
        return stack.pop()
def size():
    return len(stack)
    return cnt
def empty():
    if len(stack)==0:
        return 1
    else:
        return 0
def top():
    if len(stack) != 0:
        return stack[-1]
    else:
        return -1

stack = []
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    input_split = sys.stdin.readline().rstrip().split()
    order = input_split[0]
    if order == "push":
        push(input_split[1])
    elif order == "pop":
        print(pop())
    elif order == "size":
        print(size())
    elif order == "empty":
        print(empty())
    elif order == "top":
        print(top())