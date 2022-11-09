for tc in range(1, 11):
    n = int(input())
    table = [list(input().split()) for _ in range(n)]
    tmp = ''
    cnt = 0
    for i in range(n):
        for j in range(n):
            if table[j][i] != '0':
                tmp += table[j][i]
            else:
                continue
        cnt += tmp.count('12')
        tmp = ''
    print('#%d' %tc, cnt)