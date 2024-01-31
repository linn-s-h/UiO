#dette programmet er en quiz med if <conditions> og ramser opp flere svaralternativer
#programmet starter først med kalle på prosedyren klar() på linje 34

print("Hei! Velkommen til Pokemon Quiz!")

r = "*** Det var riktig! ***"
f = "*** Det var feil ***"
e = "*** Det var et ugyldig svar ***"

def start():
    print()
    først = input("Hvilken evolusjon er Eevee er vanntype?\na) Vapereon\nb) Flareon\nc) Jolteon\nSvar: ").lower()
    print()
    if først == "a" or først == "vapereon":
        print(r)
    if først == "b" or først == "flareon":
        print(f)
    if først == "c" or først == "jolteon":
        print(f)
    else:
        print(e)

def klar():
    test = input("Er du klar? ")
    if test.lower() == "ja":
        start() #kaller på prosedyren som starter selve quizen
    elif test.lower() == "nei":
        print("Alright, du kan gå ut av quizen.")
        exit(0) #stopper programmet
    else:
        print("Det forstod jeg ikke helt.")
        klar() #kaller prosedyren igjen siden programmet ikke skjønner input

klar() #sender programmet til linje 23

print()
andre = input("Hvor mange pokemon arter er det så langt i spillet?\na) Under 800\nb) Minst 800\nc) 800\nSvar: ").lower()
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
tredje = input("Hvilken pokemon er den første i pokedexen?\na) Squirtle\nb) Pikachu\nc) Bulbasaur\nSvar: ").lower()
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
fjerde = input("Hvilken type attack er ikke effektiv mot Chikorita?\na) Water\nb) Flying\nc) Poison\nSvar: ").lower()
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
print("Munkene trener hovedsakelig bare Bellsprout, bortsett fra lederen som også bruker Hoothoot.")
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
