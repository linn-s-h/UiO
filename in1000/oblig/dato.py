"""
dette programmet ber om og leser inn to datoer,
angitt to varibler for hver dato som skal være heltall
for dag og måned. deretter skriver ut positiv eller negativ beskjed
basert på rekkefølge av datoene.
"""

dag = input("Skriv inn dagen i første dato: ") #ber om å få et tall på dag
maaned = input("Skriv inn maaned i første dato: ") #ber deretter om å få tall på måned
dag2 = input("Skriv inn dagen i andre dato: ") #ber om å få neste tall på annen dag
maaned2 = input("Skriv inn maaned i andre dato: ") #ber deretter om å få neste tall på annen måned

#printer ut verdi for å få oversikt og vise rekkefølge
første_dato = dag + "/" + maaned
andre_dato = dag2 + "/" + maaned2

print(første_dato)
print(andre_dato)

#bruker int for å behandle string som heltall
if int(maaned) < int(maaned2): #automatisk riktig rekkefølge dersom måneden i første dato kommer først i tallrekken
    print("Riktig rekkefølge!")

elif int(maaned) == int(maaned2):
    if int(dag) < int(dag2): #finner ut av rekkefølge dersom måned er det samme utifra dag
        print("Riktig rekkefølge!") #skriver ut riktig rekkefølge ettersom dag i første dato kommer først i tallrekken
    elif int(dag) == int(dag2):
        print("Samme dato!") #skriver ut annen beskjed til bruker hvis datoene er helt like
    else:
        print("Feil rekkefølge!") #skriver ut feil rekkefølge siden dag i første dato ikke kommer først i tallrekken

else:
    print("Feil rekkefølge!") #automatisk feil rekkefølge hvis måned i første dato ikke kommer først i tallrekken
