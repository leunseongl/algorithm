import sys
from collections import deque

dq = deque()
n = int(sys.stdin.readline())

for _ in range(n):
    input_split = sys.stdin.readline().rstrip().split()
    order = input_split[0]
    if order == "push_front":
        dq.appendleft(input_split[1])
    elif order == "push_back":
        dq.append(input_split[1])
    elif order == "pop_front":
        if len(dq)==0:
            print(-1)
        else:
            tmp = dq.popleft()
            print(tmp)
    elif order == "pop_back":
        if len(dq) == 0:
            print(-1)
        else:
            tmp = dq.pop()
            print(tmp)
    elif order == "size":
        print(len(dq))
    elif order == "empty":
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    elif order == "front":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
    elif order == "back":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[-1])