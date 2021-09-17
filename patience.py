def patience(k):
    use = []
    if k[0][0].lower() == 'a':
        use.append([1])
    else:
        use.append([int(k[0][0])])
    
    suit = [[k[0][1]]]

    cnt = 0

    for i in range(1, len(k)):
        
        r = 0
        if k[i][0].lower() == 'a':
            r = 1
        elif k[i][0].lower() == 'j':
            r = 11
        elif k[i][0].lower() == 'q':
            r = 12
        elif k[i][0].lower() == 'k':
            r = 13
        else:
            r = int(k[i][0])
        
        put = False
        for t in range(len(use)):
            d = len(use[t])-1

            if r == 13 and int(use[t][d]) == 1 and suit[t][d] != k[i][1]:
                use[t].append(r)
                suit[t].append(k[i][1])
                put = True

            elif r <= int(use[t][d]) and suit[t][d] != k[i][1]:
                use[t].append(r)
                suit[t].append(k[i][1])
                put = True
        if not put:
            use.append([r])
            suit.append([k[i][1]])

    length = []
    maximum = 0
    print(use)

    for j in use:
        if len(j) > maximum:
            maximum = len(j)

    for i in use:
        if len(i) == maximum:
            length.append(i)
    
    minimum = float('inf')

    if len(length) > 1:
        for g in length:
            if sum(g) < minimum:
                minimum = sum(g)
        return minimum
    
    return sum(length[0])

print(patience(['4H','AC','KC','5C','6C','3D','4C','2D']))
