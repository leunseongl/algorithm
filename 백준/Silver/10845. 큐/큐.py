from collections import deque
import sys

def push(x):
    dq.append(x)

def pop():
    if len(dq) == 0:
        print(-1)
    else:
        tmp = dq.popleft()
        print(tmp)

def size():
    print(len(dq))

def empty():
    if len(dq) == 0:
        print(1)
    else:
        print(0)

def front():
    if len(dq) == 0:
        print(-1)
    else:
        print(dq[0])

def back():
    if len(dq) == 0:
        print(-1)
    else:
        print(dq[-1])

n = int(sys.stdin.readline())
dq = deque()

for _ in range(n):
    put = sys.stdin.readline().split()
    if put[0] == 'push':
        push(put[1])
    elif put[0] == 'pop':
        pop()
    elif put[0] == 'size':
        size()
    elif put[0] == 'empty':
        empty()
    elif put[0] == 'front':
        front()
    elif put[0] == 'back':
        back()