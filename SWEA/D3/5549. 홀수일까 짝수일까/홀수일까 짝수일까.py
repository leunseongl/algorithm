t = int(input())
for tc in range(1, t+1):
    n = int(input())
    if n%2 == 0:
        print('#%d' %tc, 'Even')
    else:
        print('#%d' %tc, 'Odd')