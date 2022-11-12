import itertools
t = int(input())
for tc in range(1, t+1):
    n = input()
    if len(n) == 1:
        print('#%d' %tc, 'impossible')
    else:
        cnt = 0
        for i in itertools.permutations(n, len(n)):
            tmp = ''
            for j in i:
                tmp += j
            if tmp[0] != '0' and int(tmp)>int(n):
                if int(tmp) % int(n) == 0:
                    cnt += 1
        if cnt > 0:
            print('#%d' %tc, 'possible')
        else:
            print('#%d' %tc, 'impossible')