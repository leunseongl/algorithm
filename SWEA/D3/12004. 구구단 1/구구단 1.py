t = int(input())
for tc in range(1, t+1):
    num = int(input())
    flag = 0
    for i in range(1, 10):
        for j in range(1, 10):
            tmp = i*j
            if tmp == num:
                flag = 1
    if flag == 1:
        print('#%d' %tc, 'Yes')
    else:
        print('#%d' %tc, 'No')