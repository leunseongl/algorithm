t = int(input())
for tc in range(1, t+1):
    s = input()
    s = ''.join(reversed(s))
    res = ''
    for i in s:
        if i == 'b':
            res += 'd'
        elif i == 'd':
            res += 'b'
        elif i == 'p':
            res += 'q'
        else:
            res += 'p'
    print('#%d' %tc, res)