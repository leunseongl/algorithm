import sys

n = int(sys.stdin.readline())
n_li = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_li = list(map(int, sys.stdin.readline().split()))

dic = dict()

for i in n_li:
    try:
        dic[i] += 1
    except:
        dic[i] = 1

for i in m_li:
    try:
        print(dic[i], end=' ')
    except:
        print(0, end=' ')