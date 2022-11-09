for tc in range(1, 11):
    n = int(input())
    code = list(map(int, input().split()))
    do = int(input())
    this = list(input().split())
    com = ''
    pos = cnt = -1
    for i in range(len(this)):
        if this[i] in ['I', 'D', 'A']:
            com = this[i]
            pos = cnt = -1
        else:
            if com == 'I':
                if pos == -1:
                    pos = int(this[i])
                    continue
                else:
                    if cnt == -1:
                        cnt = int(this[i])
                        continue
                    code.insert(pos, int(this[i]))
                    pos += 1
            elif com == 'D':
                if pos == -1:
                    pos = int(this[i])
                    continue
                else:
                    if cnt == -1:
                        cnt = int(this[i])
                        for _ in range(cnt):
                            del code[pos]
            elif com == 'A':
                if cnt == -1:
                    cnt = int(this[i])
                code.append(int(this[i]))
    print('#%d' %tc, *code[:10])

