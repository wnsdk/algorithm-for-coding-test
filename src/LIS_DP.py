# LIS 길이만 알고 싶을 때 유용한 풀이
dp = [1] * N

for i in range(N):
    for j in range(i):
        if arr[j] < arr[i]:
            dp[i] = max(dp[i], dp[j] + 1)

max(dp)