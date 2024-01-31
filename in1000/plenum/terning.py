from random import randint

kast_nummer = 0
suksesser = 0
while kast_nummer < 1000:
    kast_nummer += 1
    terning1 = randint(1,6)
    terning2 = randint(1,6)
    antall_oyne = terning1 + terning2
    if antall_oyne >= 10:
        suksesser += 1

print(suksesser / 1000)
