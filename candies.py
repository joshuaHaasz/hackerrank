def candies(n, arr):
    candies = 1
    marker, marker_val = 0, candies
    total = candies
    # print("arr: ", arr)
    # print("marker_val: ", marker_val)
    # print("adj_val: ", None)
    # print("candies: ", candies)
    # print("total: ", total)
    # print()
    for i in range(1, n):
        if arr[i] > arr[i-1]:
            candies += 1
            marker, marker_val = i, candies
            adj, adj_val = None, None
            total += candies
        elif arr[i] == arr[i-1]:
            candies = 1
            marker, marker_val = i, candies
            adj, adj_val = None, None
            total += candies
        else:
            if i == marker + 1:
                adj, adj_val = i, 1
                if marker_val == adj_val:
                    marker_val += 1
            if candies == 1:
                total += i - marker
                adj_val += 1
                if adj_val == marker_val:
                    total += 1
                    marker_val += 1
            else:
                candies = 1
                total += candies

        # print("arr: ", arr)
        # print("marker_val: ", marker_val)
        # print("adj_val: ", adj_val)
        # print("candies: ", candies)
        # print("total: ", total)
        # print()
    return total

if __name__ == "__main__":
    arr = [1,9,3,2,1]
    n = len(arr)
    res = candies(n,arr)
    print(res)























    #     if arr[i] < arr[i - 1]:
    #         if candies == 1:
    #             if len(cache) > 1 and cache[1] + 1 == cache[0]:
    #
    #                 for j in range(len(cache)): cache[j] += 1
    #                 cache.append(1)
    #
    #                 total += i - marker + 1
    #                 # for j in range(marker,i):
    #                 #     c_arr[j] += 1
    #             else:
    #                 total += i - marker
    #                 for j in range(len(cache)): cache[j] += 1
    #                 cache.append(1)
    #                 # for j in range(marker+1,i):
    #                 #     c_arr[j] += 1
    #         else:
    #             candies = 1
    #             total += candies
    #             cache.append(1)
    #
    #         if arr[i] == arr[i - 1]:
    #             marker = i
    #             cache = [1]
    #     else:
    #         marker = i
    #         candies += 1
    #         cache = [candies]
    #         total += candies
    #     # c_arr.append(candies)
    #     # counts.append(total)
    #     # print_vars(arr, c_arr, counts, cache, marker, total)
    #
    # return total

def print_vars(arr, c_arr, counts, cache, marker, soln):
    print("arr: ", arr)
    print("c_arr: ", c_arr)
    print("cache: ", cache)
    print("marker: ", marker)
    print("soln: ", soln)
    print(sum(c_arr))
    print()
