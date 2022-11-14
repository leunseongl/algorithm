n = int(input())
n_li = list(map(int, input().split()))
m = int(input())
m_li = list(map(int, input().split()))
n_li.sort()

res = []

for i in m_li:
    lt, rt = 0, n-1
    bool = False
    while lt <= rt:
        mid = (lt+rt)//2
        if n_li[mid] == i:
            res.append(1)
            bool = True
            break
        elif n_li[mid] > i:
            rt = mid-1
        else:
            lt = mid+1
    if bool == False:
        res.append(0)

for i in res:
    print(i, end=' ')