import math

def solution(w, h):
    res = w*h - (w+h-math.gcd(w,h))
    return res