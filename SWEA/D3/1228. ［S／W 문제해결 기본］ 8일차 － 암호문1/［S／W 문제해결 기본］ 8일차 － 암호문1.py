for tc in range(1, 11):
    n = int(input())
    code = list(map(int, input().split()))
    do = int(input())
    this = list(input().split())
    for i in this:
        if i == 'I':
            pos = cnt = -1
        else:
            if pos == -1:
                pos = int(i)
            elif cnt == -1:
                cnt = int(i)
            else:
                code.insert(pos, int(i))
                pos += 1
    print('#%d' %tc, *code[:10])
