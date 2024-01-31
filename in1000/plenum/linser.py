from random import shuffle

linser = ["H", "H", "V", "V"]

utproving = 0
suksesser = 0

while utproving < 10000:
    utproving += 1
    shuffle(linser)
    valg1 = linser[0]
    valg2 = linser[1]
    if valg1 != valg2:
        suksesser += 1

print(suksesser/10000)
