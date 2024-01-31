from person import Person

#lag en funksjon tar inn en liste med personer, og returner den som er høyest
def hoyest(listen):
    max_person = listen[0]
    for i in range(1, len(listen)): #hopper over første person, fordi første person kan ikke være høyere enn seg selv
        if listen[i] >= hoyereEnn(max_person):
            max_person = listen[i]

    return max_person

#instanser av klassen med navn/alder/vekt/høyde jeg velger selv
person_1 = Person("Mari", 23, 65, 178)
person_2 = Person("Lars", 20, 60, 171)
person_3 = Person("Linn", 20, 58, 168)

print(person_1.skrivUtInfo())
print(person_2.skrivUtInfo())
print(person_3.skrivUtInfo())

liste = [person_1, person_2, person_3]

for _ in range(5):
    print(liste[0].skrivUtHilsen())

for _ in range(5):
    print(liste[1].skrivUtHilsen())

for _ in range(5):
    print(liste[2].skrivUtHilsen())
