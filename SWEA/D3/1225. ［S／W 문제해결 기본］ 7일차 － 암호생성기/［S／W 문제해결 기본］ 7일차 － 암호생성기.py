for _ in range(10):
    tc = int(input())
    data = list(map(int, input().split()))
    cycle = 1
    while True:
        tmp = data.pop(0)
        tmp -= cycle
        if tmp > 0:
            data.append(tmp)
        else:
            data.append(0)
            print('#%d' %tc, *data)
            break
        cycle += 1
        if cycle == 6:
            cycle = 1