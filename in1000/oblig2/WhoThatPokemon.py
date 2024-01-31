#dette programmet er en quiz med if conditions og ramser opp flere svaralternativer
#programmet starter med å kalle på prosedyren klar() --> linje 40

print("Hei! Velkommen til Pokemon Quiz!")

#tilbakemelding om svaret er korrekt eller ikke
r = "*** Det var riktig! ***"
f = "*** Det var feil ***"
e = "*** Det var et ugyldig svar ***"

def start():
    print()
    print("Hvilken evolusjon av Eevee er vanntype?") #starter med spørsmålet
    print("a) Vapereon") #viser flere svaralternativer bruker kan velge mellom
    print("b) Flareon")
    print("c) Jolteon")
    først = input("Svar: ").lower()
    print()
    #gir bruker mulighet til å svare på to måter uten at det gir false
    if først == "a" or først == "vapereon":
        print(r) #printer ut riktig svar
    elif først == "b" or først == "flareon":
        print(f) #printer ut feil svar
    elif først == "c" or først == "jolteon":
        print(f)
    else:
        print(e) #printer ut feilmelding

def klar():
    test = input("Er du klar? ")
    if test.lower() == "ja":
        start() #kaller på ny prosedyre som starter selve quizen
    elif test.lower() == "nei":
        print("Alright, du kan gå ut av quizen.")
        exit(0) #stopper programmet
    else:
        print("Det forstod jeg ikke helt.")
        klar() #kaller prosedyren igjen siden programmet ikke skjønner input

klar() #sender programmet til linje 29

#resten av quizen fortsetter her og utføres på samme måte som prosedyren start()
print()
print("Hvor mange pokemon arter er det så langt i spillet?")
print("a) Under 800")
print("b) Minst 800")
print("c) 800")
andre = input("Svar: ").lower()
print()

if andre == "a" or andre == "under 800":
    print(f)
elif andre == "b" or andre == "minst 800":
    print(r)
elif andre == "c" or andre == "800":
    print(f)
else:
    print(e)

print()
print("Hvilken pokemon er den første i pokedexen?")
print("a) Squirtle")
print("b) Pikachu")
print("c) Bulbasaur")
tredje = input("Svar: ").lower()
print()
if tredje == "a" or tredje == "squirtle":
    print(f)
elif tredje == "b" or tredje == "pikachu":
    print(f)
elif tredje == "c" or tredje == "bulbasaur":
    print(r)
else:
    print(e)

print()
print("Hvilken type attack er ikke effektiv mot Chikorita?")
print("a) Water")
print("b) Flying")
print("c) Poison")
fjerde = input("Svar: ").lower()
print()

if fjerde == "a" or fjerde == "water":
    print(r)
elif fjerde == "b" or fjerde == "flying":
    print(f)
elif fjerde == "c" or fjerde == "poison":
    print(f)
else:
    print(e)

print()
print("Det er et tårn i Violet City kalt Madatsubomi Tower, bosatt av dilligente munker.")
print("Disse munkene trener hovedsakelig bare Bellsprouts, bortsett fra lederen som også bruker Hoothoot.")
#prøver meg frem på en annen formatering hvor svaralternativer og input er i samme programsetning
femte = input("Hvem?\na) Sage Nico\nb) Sage Chow\nc) Sage Edmond\nd) Sage Jin\ne) Sage Neal\nf) Sage Troy\nSvar: ").lower()
print()
if femte == "a" or femte == "sage nico":
    print(f)
elif femte == "b" or femte == "sage chow":
    print(f)
elif femte == "c" or femte == "sage edmond":
    print(f)
elif femte == "d" or femte == "sage jin":
    print(f)
elif femte == "e" or femte == "sage neal":
    print(f)
elif femte == "f" or femte == "sage troy":
    print(r)
else:
    print(e)

print()
print("Takk for at du tok quizen!") #avlsutter quizen med en takkehilsen
print()
