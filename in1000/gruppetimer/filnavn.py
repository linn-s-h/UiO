def skrivUtElementer(ordbok):
    for element in ordbok:
        prnt(f"(elem) koster {ordbok[elem]}kr.")

def lagOrdbok(filnavn):
    ordbok = {}

    #for element i samling
    fil = open(filnavn, "r") #"w" hvis du skal skrive

    for linje in fil:
        data = linje.split() #.strip() fjerner new lines
        nokkel = data[0]
        verdi = float(data[1])
        ordbok[nokkel] = verdi

    return ordbok #outputen ordbok

vare_ordbok = lagOrdbok("varer.csv") #kaller funksjonen ved å lagre det i et variabelnavn
print(vare_ordbok)
skrivUtElementer(ordbok)
