n, m = map(int, input().split())
small = 2147000000
res = 0
shop_six = []
shop_one = []

for _ in range(m):
    a, b = map(int, input().split())
    shop_six.append((a, b))
    shop_one.append((a,b))

shop_six.sort()
shop_one.sort(key=lambda x:(x[1],x[0]))

if shop_six[0][0] <= shop_one[0][1]*6:
    res = shop_six[0][0] * (n//6) + shop_one[0][1] * (n % 6)
    if shop_six[0][0] < shop_one[0][1] * (n % 6):
        res = shop_six[0][0] * (n//6+1)
else:
    res = shop_one[0][1] * n

print(res)