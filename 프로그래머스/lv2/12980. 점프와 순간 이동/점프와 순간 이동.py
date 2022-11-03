def solution(n):
    cnt = 0
    while n:
        if n%2 == 0:
            n = n//2
        else:
            cnt += 1
            n -= 1
    return cnt