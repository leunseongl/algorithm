mo = ['a', 'e', 'i', 'o', 'u']
t = int(input())
for tc in range(1, t+1):
    word = input()
    res = ''
    for i in word:
        if i in mo:
            continue
        else:
            res += i
    print('#%d' %tc, res)