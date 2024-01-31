#
dag = input("Skriv inn dagen i første dato: ") #ber om å få et tall
maaned = input("Skriv inn maaned i første dato: ") #ber om neste tall
dag2 = input("Skriv inn dagen i andre dato: ")
maaned2 = input("Skriv inn maaned i andre dato: ")

#printer ut variabler for å få oversikt og vise rekkefølge
første_dato = dag + "/" + maaned
andre_dato = dag2 + "/" + maaned2

print(første_dato)
print(andre_dato)

#bruker int for å behandle string som heltall
if (maaned) < (maaned2): #
    print("Riktig rekkefølge!") #skriver ut beskjed til bruker
elif (maaned) == (maaned2):
    if (dag) < (dag2):
        print("Riktig rekkefølge!") #skriver ut beskjed til bruker
    elif (dag) == (dag2):
        print("Samme dato!") #skriver ut annen beskjed til bruker
    else:
        print("Feil rekkefølge!")

else:
    print("Feil rekkefølge!")
