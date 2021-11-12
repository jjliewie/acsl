def say(m, a, cur):
    if cur >= m:
        return a
    temp = 1
    string = ""
    if len(a) == 1:
        return say(m, "11 ", cur + 1)
    for i in range(1, len(a)):
        if a[i] == a[i-1]:
            temp += 1
        else:
            string += (str(temp) + a[i-1])
            temp = 1
    return say(m, string + " ", cur + 1)

def sol(m, n, p):
    t = say(m, '1', 1)
    return t[n-1:n+p+1]

print(sol(10, 10, 5))
