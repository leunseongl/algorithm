def pibo(x):
    if x<=1:
        return x
    else:
        return pibo(x-1)+pibo(x-2)

n = int(input())
print(pibo(n))