min_fil = open("alder.csv.rtfd")

for linje in min_fil:
    eldst = 0
    biter = linje.split(":")
    for aldertekst in biter:
        alder = int(aldertekst)
        if alder > eldst:
            eldst = alder
    print(eldst)

#eller

min_fil = open("alder.csv.rtfd")

maksalder = 0
eldste_navn = ""

for linje in min_fil:
    biter = linje.split(":")
    navn = biter[0]
    alder = int(biter[1])
    if alder > maksalder:
        maskalder = alder
        eldste_navn = navn

print(eldste_navn)
