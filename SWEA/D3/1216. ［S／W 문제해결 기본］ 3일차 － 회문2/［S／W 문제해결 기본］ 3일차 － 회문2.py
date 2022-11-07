#우선은 tc 빼고, 100
for _ in range(10):
    tc = int(input())
    board = [list(input()) for _ in range(100)]
    long = 0

    for i in range(100):
        for j in range(100, long, -1):
            for k in range(100-j+1):
                tmp = board[i][j:j+k]
                if tmp == tmp[::-1]:
                    if len(tmp)>long:
                        long = len(tmp)

    Sero_lst = []
    Sero_sub_lst = ''
    for x in range(100):
        for y in board:
            Sero_sub_lst += y[x]
        Sero_lst.append(Sero_sub_lst)
        Sero_sub_lst =''

    for sero_data in Sero_lst:
        for M in range(100, long, -1):
            if long > M:
                break
            for k in range(100-M+1):
                if sero_data[k:M+k] == sero_data[k:M+k][::-1]:
                    if len(sero_data[k:M+k]) > long:
                        long = len(sero_data[k:M+k])
                        
    print('#%d' %tc, long)

