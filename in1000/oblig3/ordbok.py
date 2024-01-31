#dette programmet inneholder varer med angitt pris
#deretter ber bruker om å legge til en ny vare med ny pris i katalogen

#nøkkel/verdi-par hvor nøkkel er vare og verdi er prisen
butikk = {"melk":14.90, "brød2":24.90, "youghurt":12.90, "pizza":39.90}
print(butikk)

#spør bruker om to nye varer og om å angi pris på de
vare1 = input("Legg til en vare: ")
pris1 = input("Bestem pris på varen: ")
vare2 = input("Legg til enda en vare: ")
pris2 = input("Bestem pris på varen: ")

#legger til ny verdi i ordboken
butikk[vare1] = pris1
butikk[vare2] = pris2
print(butikk)
