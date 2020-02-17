def freqQuery(queries):
    d = {}
    freqs = {}
    ret_val = []
    for q in queries:

        # print("q: ", q)

        if q[0] == 1:
            d[q[1]] = d.get(q[1], 0) + 1
            freqs[d[q[1]]] = freqs.get(d[q[1]], 0) + 1
            freqs[d[q[1]] - 1] = freqs.get(d[q[1]] - 1, 1) - 1
            if freqs[d[q[1]] - 1] == 0:
                del freqs[d[q[1]] - 1]

        elif q[0] == 2:
            if q[1] in d and d[q[1]] == 1:
                freqs[1] -= 1
                if freqs[1] == 0:
                    del freqs[1]
                del d[q[1]]
            elif q[1] in d:
                d[q[1]] -= 1
                freqs[d[q[1]]] = freqs.get(d[q[1]],0) + 1
                freqs[d[q[1]] + 1] = freqs.get(d[q[1]]+1,1) - 1
                if freqs[d[q[1]] + 1] == 0:
                    del freqs[d[q[1]] + 1]
        else:
            if q[1] in freqs: ret_val.append(1)
            else: ret_val.append(0)

        # print("d: ", d)
        # print("f: ", freqs)
        # print("ret_val: ", ret_val)
        # print()
    return ret_val

if __name__ == "__main__":
    queries =[[1, 3], [2, 3], [3, 2], [1, 4], [1, 5], [1, 5], [1, 4], [3, 2], [2, 4], [3, 2]]
    freqQuery(queries)
