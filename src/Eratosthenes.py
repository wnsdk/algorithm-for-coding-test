n = 1000
a = [False, False] + [True] * (n - 1)
primes = []

for i in range(2, n + 1):
    if a[i]:
        # i를 제외한 i의 배수를 제외하기
        primes.append(i)
        for j in range(2 * i, n + 1, i):
            a[j] = False
