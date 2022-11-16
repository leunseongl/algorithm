t = int(input())
for tc in range(1, t+1):
    word = input()
    long = len(word)//2
    cnt = 0
    for i in range(long):
        if word[i] == word[-1-i] or word[i] == '?' or word[-1-i] == '?':
            cnt += 1
        else:
            break
    if cnt == long:
        print('#%d' %tc, 'Exist')
    else:
        print('#%d' %tc, 'Not exist')