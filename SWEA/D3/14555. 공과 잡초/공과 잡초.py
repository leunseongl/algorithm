t = int(input())
for tc in range(1, t+1):
    s = input()
    cnt = 0
    for i in range(1, len(s)):
        if s[i] == '|':
            if s[i-1] == '(':
                cnt += 1
        elif s[i] == ')':
            if s[i-1] == '|' or s[i-1] == '(':
                cnt += 1
    print('#%d' %tc, cnt)
