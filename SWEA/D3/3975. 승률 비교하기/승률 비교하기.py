t = int(input())
res = []
for tc in range(1, t+1):
    a,b,c,d = map(int, input().split())
    x = b/a
    y = d/c
    if x>y:
        res.append('BOB')
    elif x == y:
        res.append('DRAW')
    else:
        res.append('ALICE')
for i in range(t):
    print('#%d' %(i+1), res[i])