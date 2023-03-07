# 이분탐색을 이용해 시간을 단축한 풀이 (LIS 요소들까지 알 수 있음)

# from bisect import bisect_left 한 후, bisect_left 메서드로 대체 가능
def find_idx(LIS, key):
    lo = 0
    hi = len(LIS) - 1

    while lo <= hi:
        mi = (lo + hi) // 2
        if LIS[mi] >= key:
            hi = mi - 1
        else:
            lo = mi + 1

    return lo

def find_LIS(a):
    LIS = [a[0]]
    for item in a:
        if LIS[-1] < item:
            LIS.append(item)
        else:
            LIS[find_idx(LIS, item)] = item
    return LIS

find_LIS(arr)