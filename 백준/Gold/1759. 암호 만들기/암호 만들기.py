import sys
input = sys.stdin.readline

def DFS(x):
    if len(s) == l:
        m, j = 0, 0
        for i in s:
            if i in mo:
                m += 1
            else:
                j += 1
        if m>=1 and j>=2:
            for i in s:
                print(i, end='')
            print()
    else:
        for i in range(x, c):
            s.append(li[i])
            DFS(i+1)
            s.pop()

l, c = map(int, input().split())
li = list(input().split())
li.sort()
mo = ['a','e','i','o','u']
s = []
DFS(0)


