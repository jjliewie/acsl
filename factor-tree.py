def isprime(n):
    boolean = True
    for i in range(2, n):
        if n%i == 0:
            boolean = False
    return boolean

def factor_tree(a):
    if isprime(a) or a == 1:
        return [a]
    
    divisors = []
    cnt = 2
    use = []
    do = True
    counter = []

    while a != 1 and do:
        if isprime(cnt) and do:
            c = 0

            while a % cnt == 0 and a!=1:
                c += 1
                a /= cnt 
                if a != 1:
                    use.append(cnt)
                    use.sort(reverse=True)
                    k = str(int(a)) + ' * '

                    for i in range(len(use)):
                        if i != len(use)-1:
                            k += str(use[i]) + ' * '
                        else:
                            k += str(use[i])
                    divisors.append(k)
                if isprime(int(a)):
                    do = False
            if c != 0:
                counter.append((cnt, c))
        if int(a) != 1 and isprime(int(a)):
            counter.append((int(a), 1))
        cnt += 1
    counter.reverse()
    j = ''
    for i in range(len(counter)):
        if i != 0:
            j += ' * '
        if counter[i][1] != 1:
            j += str(counter[i][0]) + "^" + str(counter[i][1])
        else:
            j += str(counter[i][0])
    divisors.append(j)
    return divisors

print(factor_tree(81))
