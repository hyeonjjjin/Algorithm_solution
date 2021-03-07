def solution11(n):
    return list(map(int, list((str(n))[::-1])))

print(solution11(12345))