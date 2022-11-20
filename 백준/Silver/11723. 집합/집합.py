import sys
input = sys.stdin.readline

m = int(input())
s = set()
for _ in range(m):
    do = input().strip().split()
    if do[0] == 'add':
        this = int(do[1])
        if this not in s:
            s.add(this)
    elif do[0] == 'remove':
        this = int(do[1])
        if this in s:
            s.remove(this)
    elif do[0] == 'check':
        this = int(do[1])
        if this in s:
            print(1)
        else:
            print(0)
    elif do[0] == 'toggle':
        this = int(do[1])
        if this in s:
            s.remove(this)
        else:
            s.add(this)
    elif do[0] == 'all':
        s = set(range(1,21))
    elif do[0] == 'empty':
        s = set()
