dic = {'ZRO':0, 'ONE':1, 'TWO':2, 'THR':3, 'FOR':4, 'FIV':5, 'SIX':6, 'SVN':7, 'EGT':8, 'NIN':9}
t = int(input())
for tc in range(1, t+1):
    a, n = input().split()
    li = list(input().split())
    li.sort(key=lambda x:dic[x])
    print('#%d' %tc)
    print(*li)