for tc in range(1, 11):
    dump = int(input())
    data = list(map(int, input().split()))
    for _ in range(dump):
        data.sort()
        data[0] += 1
        data[-1] -= 1
    print('#%d' %tc, max(data)-min(data))
