for tc in range(1, 11):
    l, s = input().split()
    stack = []
    for i in s:
        if stack and int(i) == stack[-1]:
            stack.pop()
        else:
            stack.append(int(i))
    print('#%d' %tc, end=' ')
    for i in stack:
        print(i, end='')
    print()