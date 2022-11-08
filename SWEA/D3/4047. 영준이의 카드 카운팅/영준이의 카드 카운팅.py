t = int(input())
for tc in range(1, t+1):
    s = input()
    li = []
    tmp = ''
    flag = 0
    for i in s:
        tmp += i
        if len(tmp) == 3:
            if tmp in li:
                flag = 1
                break
            else:
                li.append(tmp)
                tmp = ''
    dic = {'S': 0, 'D': 0, 'H': 0, 'C': 0}
    if flag == 1:
        print('#%d' %tc, 'ERROR')
    else:
        print('#%d' %tc, end=' ')
        for i in li:
            sh = i[0]
            dic[sh] += 1
        for i in dic:
            print(13 - dic[i], end=' ')
        print()