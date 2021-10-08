def solution(m, n, p):

    a = "1"
    k = 1

    def one(m, n, p, a, k):
        if k == m:
            return(a[n-1: n+p])
        alist = [[a[0]]]
        cnt = 1
        idx = 0
        while cnt < len(a):
            if a[cnt-1] == a[cnt]:
                alist[idx].append(a[cnt])
            else:
                alist.append([a[cnt]])
                idx += 1
            cnt += 1
        use = ""
        for x in alist:
            use += str(len(x))
            use += x[0]
        return(one(m, n, p, use, k+1))
    
    return(one(m, n, p, a, k))
    
print(solution(10, 10, 5))
