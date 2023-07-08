n = 1000
chk = [False, False] + [True] * n

for i in range(2, int(n ** 0.5) + 1):
    if chk[i]:
        # i를 제외한 i의 배수를 제외하기
        for j in range(2 * i, n, i):
            chk[j] = False
            
primes = [i ** 2 for i in range(2, n) if chk[i]]
