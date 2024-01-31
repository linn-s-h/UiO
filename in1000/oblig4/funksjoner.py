"""første del av programmet bruker funksjon til å summere to tall sammen,
    deretter skrive ut resultatet ved å kalle på funksjonen to ganger med valgfri argumenter.
    siste del av programmet ber bruker om å skrive inn tekst og et bokstav.
    programmet skal til slutt skrive ut hvor mange ganger bokstaven forekommer i teksten
    bruker skrev inn"""

# 1. Funksjon med to parametere ––––––––––––––––––––––––––––––––––––––––––––––––
def adder(tall1, tall2): #funksjon med to parametere
    return tall1+tall2 #returnerer summen av parameterene

print(f"Summen av 3 og 4 er {adder(3,4)}") #kaller på funksjonen med argumentet 3 og 4
print(f"Summen av 5 og 6 er {adder(5,6)}") #kaller på funksjonen med argumentet 4 og 5

# 2. og 3. Antall forekomster ––––––––––––––––––––––––––––––––––––––––––––––––––
minTekst = input("Skriv inn et ord eller tekst: ")
minBokstav = input("Skriv inn et bokstav: ")

#heeeeei
#"e"
#output 5
def tellForekomst(minTekst, minBokstav):
    teller = 0
    for i in minTekst:
        if minBokstav == i: #sjekker om input bokstav er lik elementet i hver indeks i input tekst
            teller += 1 #oppdaterer teller med 1 for hver gang det stemmer

    return teller
#printer ut resultat til bruker
print(f"Bokstaven '{minBokstav}' forekommer {tellForekomst(minTekst, minBokstav)} ganger")
