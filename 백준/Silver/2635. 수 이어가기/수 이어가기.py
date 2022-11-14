import sys
input = sys.stdin.readline

num = int(input())
long = 0
res = []
for i in range(1, num+1):
    li = [num]
    li.append(i)

    idx = 1
    while True:
        tmp = li[idx-1]-li[idx]
        if tmp<0:
            break
        li.append(tmp)
        idx += 1
    if len(li)>long:
        long = len(li)
        res = li

print(len(res))
print(*res)