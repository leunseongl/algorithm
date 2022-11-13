t = int(input())
for tc in range(1, t+1):
    s = input()
    lose = 0
    for i in s:
        if i == 'x':
            lose += 1
    if lose>=8:
        print('#%d' %tc, 'NO')
    else:
        print('#%d' %tc, 'YES')