t = int(input())
for tc in range(1, t+1):
    alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
         's','t','u','v','w','x','y','z']
    w = list(input())
    cnt = 0
    for i in range(len(w)):
        if alpha[i] == w[i]:
            cnt += 1
        else:
            break
    print('#%d' %tc, cnt)