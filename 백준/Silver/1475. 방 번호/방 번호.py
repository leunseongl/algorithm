num = input()
li = [0] * 10
for i in num:
    if int(i) == 6 or int(i) == 9:
        li[6] += 1
    else:
        li[int(i)] += 1

li[6] = (li[6]+1)//2
print(max(li))