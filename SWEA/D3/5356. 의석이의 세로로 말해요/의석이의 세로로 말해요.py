t = int(input())
for tc in range(1, t+1):
    word = [['@']*15 for _ in range(5)]
    big = 0
    for i in range(5):
        tmp = list(input())
        if len(tmp)>big:
            big = len(tmp)
        for j in range(len(tmp)):
            word[i][j] = tmp[j]
    res = ''
    for i in range(big):
        for j in range(5):
            if word[j][i] != '@':
                res += word[j][i]
            else:
                continue
    print('#%d' %tc, res)