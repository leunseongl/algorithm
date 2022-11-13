t = int(input())
for tc in range(1, t+1):
    s = input()
    dic = {}
    flag = 0
    for i in s:
        if i in dic:
            dic[i] += 1
        else:
            dic[i] = 1
    if len(dic) != 2:
        print('#%d' %tc, 'No')
    else:
        for i in dic:
            if dic.get(i) == 2:
                continue
            else:
                flag = 1
        if flag == 1:
            print('#%d' %tc, 'No')
        else:
            print('#%d' %tc, 'Yes')