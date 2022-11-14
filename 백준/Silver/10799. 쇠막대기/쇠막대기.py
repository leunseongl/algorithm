a = input()
stack = []
tot = 0

for i in range(len(a)):
    if a[i] == '(':
        stack.append(a[i])
    else:
        if a[i-1] == '(':
            stack.pop()
            tot += len(stack)
        else:
            stack.pop()
            tot += 1
print(tot)

