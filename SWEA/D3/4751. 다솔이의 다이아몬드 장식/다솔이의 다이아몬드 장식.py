t = int(input())
for tc in range(1, t+1):
    s = input()
    one = '..#.' * len(s) + '.'
    two = '.#' * (len(s)*2) + '.'
    three = ''
    for i in s:
        three += '#.' + i + '.'
    three += '#'
    print(one)
    print(two)
    print(three)
    print(two)
    print(one)