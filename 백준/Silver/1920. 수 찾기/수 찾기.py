n = int(input())
n_li = list(map(int, input().split()))
m = int(input())
m_li = list(map(int, input().split()))
n_li.sort()

for i in m_li:
    lt, rt = 0, n-1
    boolean = False
    while lt <= rt:
        mid = (lt+rt)//2
        if n_li[mid] == i:
            print(1)
            boolean = True
            break
        elif n_li[mid] > i:
            rt = mid-1
        else:
            lt = mid+1

    if boolean == False:
        print(0)