t = int(input())
for tc in range(1, t+1):
    s = list(input())
    s.sort()
    stack = []
    for i in s:
        if stack and stack[-1] == i:
            stack.pop()
            continue
        else:
            stack.append(i)
    if stack:
        res = ''
        for i in stack:
            res += i
        print('#%d' %tc, res)
    else:
        print('#%d' %tc, 'Good')