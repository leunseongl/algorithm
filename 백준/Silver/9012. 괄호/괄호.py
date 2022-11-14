t = int(input())
for tc in range(1, t+1):
    stack = []
    li = list(input())
    for i in range(len(li)):
        if li[i] == '(':
            stack.append(li[i])
        else:
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(li[i])
    if len(stack) == 0:
        print("YES")
    else:
        print("NO")