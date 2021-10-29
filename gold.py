def price(troy_price, weight, unit, purity, percentage):
    troy = {"GN" : 0.0021, "GM": 0.0321, "PN": 0.05, "TR": 1, "ON": 0.9115}

    carat = {24: 1.00, 22: 0.917, 18: 0.75, 14: 0.584, 12: 0.50, 8: 0.333, 6 : 0.25, 1: 0.04167}

    cost = float(float(float(weight * float(troy_price * (troy[unit]))) * carat[purity]) * (100-percentage))/100

    return cost

print(round(price(1675.38, 6, "GM", 12, 30), 2))
