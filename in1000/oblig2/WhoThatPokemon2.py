
print("Hei! Velkommen til Pokemon Quiz!")

r = "*** Det var riktig! ***"
f = "*** Det var feil ***"
e = "*** Det var et ugyldig svar ***"
i = 0

def start():
    print()
    først = input("Hvilken evolusjon av Eevee er vanntype?\nVaperon\nFlareon\nJolteon\nSvar: ").lower()
    print()
    if først == "vapereon":
        print(r)
        i += 1
    elif først == "flareon":
        print(f)
    elif først == "jolteon":
        print(f)
    else:
        print(e)

def klar():
    test = input("Er du klar? ")
    if test.lower() == "ja":
        start()
    elif test.lower() == "nei":
        klar()
    else:
        print("Alright, du kan gå ut av quizen.")

klar() #sender programmet til linje 21 til å starte med

print()
andre = input("Hvor mange pokemon arter er det så langt i spillet?\nUnder 800\nMinst 800\n800\nSvar: ").lower()
print()
if andre == "under 800":
    print(f)
elif andre == "minst 800":
    print(r)
    i += 1
elif andre == "800":
    print(f)
else:
    print(e)

print()
tredje = input("Hvilken pokemon er den første i pokedexen?\nSquirtle\nPikachu\nBulbasaur\nSvar: ").lower()
print()
if tredje == "squirtle":
    print(f)
elif tredje == "pikachu":
    print(f)
elif tredje == "bulbasaur":
    print(r)
    i += 1
else:
    print(e)

print()
fjerde = input("Hvilken type attack er ikke effektiv mot Chikorita?\nWater\nFlying\nPoison\nSvar: ").lower()
print()
if fjerde == "water":
    print(r)
    i += 1
elif fjerde == "flying":
    print(f)
elif fjerde == "poison":
    print(f)
else:
    print(e)

print()
print("Det er et tårn i Violet City kalt Madatsubomi Tower, bestående av dilligente munker.")
print("Disse munkene trener hovedsakelig bare Bellsprout, bortsett fra lederen som også bruker Hoothoot.")
femte = input("Hvem?\nSage Nico\nSage Chow\nSage Edmond\nSage Jin\nSage Neal\nSage Troy\nSvar: ").lower()
print()
if femte == "sage nico":
    print(f)
elif femte == "sage chow":
    print(f)
elif femte == "sage edmond":
    print(f)
elif femte == "sage jin":
    print(f)
elif femte == "sage neal":
    print(f)
elif femte == "sage troy":
    print(r)
    i += 1
else:
    print("*** Ja, det var litt mange navn kanskje... ***")

print()
print("Du fikk" + str(i) + "av 5 riktige." )
