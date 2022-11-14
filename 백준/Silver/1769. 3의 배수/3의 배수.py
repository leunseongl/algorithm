def DFS(String, cnt):
    if len(String) > 1:
        cnt += 1
        tot = 0
        for i in String:
            tot += int(i)
        DFS(str(tot), cnt)
    else:
        if int(String) % 3 == 0:
            print(cnt)
            print('YES')
        else:
            print(cnt)
            print('NO')

n = input()
cnt = 0
DFS(n, cnt)