import sys
input = sys.stdin.readline

n = int(input())
dic = {}
for _ in range(n):
    s = input()
    if s in dic:
        dic[s] += 1
    else:
        dic[s] = 1

big = 0

for i in dic.items():
    if i[1] > big:
        big = i[1]

li = []
for i in dic.items():
    if i[1] == big:
        li.append(i[0])
li.sort()
print(li[0])