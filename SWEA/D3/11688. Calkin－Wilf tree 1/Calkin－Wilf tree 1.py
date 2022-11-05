t = int(input())
for tc in range(1, t+1):
    a = b = 1
    st = input()
    for i in st:
        if i == 'L':
            a = a
            b = a+b
        else:
            a = a+b
            b = b
    print('#%d' %tc, a, b)
