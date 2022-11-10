for tc in range(1, 11):
    n = int(input())
    code = list(map(int, input().split()))
    do = int(input())
    this = list(input().split())
    com = ''
    for i in this:
        if i in ['I', 'D']:
            com = i
            pos = cnt = -1
        else:
            if com == 'I':
                if pos == -1:
                    pos = int(i)
                elif cnt == -1:
                    cnt = int(i)
                else:
                    code.insert(pos, int(i))
                    pos += 1
            elif com == 'D':
                if pos == -1:
                    pos = int(i)
                elif cnt == -1:
                    cnt = int(i)
                    for _ in range(cnt):
                        del(code[pos])
    print('#%d' %tc, *code[:10])
