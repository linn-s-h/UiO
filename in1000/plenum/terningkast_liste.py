
terningkast = []
kast = int(input("kast terningen: "))
terningkast.append(kast)
kast = int(input("kast terningen: "))
terningkast.append(kast)
kast = int(input("kast terningen: "))
terningkast.append(kast)
kast = int(input("kast terningen: "))
terningkast.append(kast)
kast = int(input("kast terningen: "))
terningkast.append(kast)
print(terningkast)

poeng = terningkast.count(4) * 4
print(poeng)

mengde = set(terningkast)
if len(mengde) == 1:
    print("yatzy!")

mengde = set(terningkast)
if len(mengde) == 2:
    print("fire like eller hus!")

mengde = set(terningkast)
if len(mengde) == 2 and terningkast.count(terningkast[0]) in [2,3]:
    print("hus!")


allergier = {"carine sundby" : ["rotgrønnsaker, laktose, jordbær"],
            "kristin rise kirkeby" : ["mandler", "hasselnøtt", "pistasj"],
            "dina dalberg" : ["gluten", "egg", "soya"]}

print("Sjekk person for allergier")
person = input("Navn: ")
if person in allergier:
    print(allergier.get(person))
