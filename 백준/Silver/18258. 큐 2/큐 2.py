import sys
from collections import deque

n = int(sys.stdin.readline())
que = deque()

for _ in range(n):
    input_split = sys.stdin.readline().rstrip().split()
    order = input_split[0]
    if order == 'push':
        que.append(input_split[1])
    elif order == 'pop':
        if len(que) == 0:
            print(-1)
        else:
            tmp = que.popleft()
            print(tmp)
    elif order == 'size':
        print(len(que))
    elif order == 'empty':
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif order == 'front':
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])
    elif order == 'back':
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])