"""programmet skal la bruker skrive inn setning og skrive ut
    hvor mange ord setningen består av. til slutt skrive ut
    hvor mange ganger hvert ord forekommer i setningen
    og i tillegg hvor mange bokstaver hvert ord har"""

def antallBokstaver(tekst):
    bokstaver = len(tekst) #finner ut av antall verdier i setningslisten, inkl. mellomrom
    return bokstaver #returnerer bokstaver når funksjon blir kalt på

def antallOrd(tekst):
    ord = tekst.split() #gjør om ord fra setiningslista til verdier
    ordbok = {}

    for elem in ord: #kjører for alle indeksene som er i lista
        antall_ganger = 0 #holder styr på hvor mange ganger et ord i gjennomkjøringen forekommer i hele setningslista
        teller = 0 #holder styr på hvilken indeks i lista elem skal sammenlignes med
        while teller < len(ord): #fortsetter til neste element i lista hvis antall gjennomkjøringer av et ord er kortere enn lista
            if elem == ord[teller]: #sammenligner ordet med ord i (neste) indeks
                antall_ganger += 1 #øker antall ganger et ord forekommer med 1 hvis ordene er like
            teller += 1 #øker for hver gjennomkjøring sånn at neste indeks kan bli sammenlignet

        #lagres her for hver gang et elem har blitt sammnlignet med alle indeksene i setningslista
        ordbok[elem] = antall_ganger #elem blir key og antall_ganger blir innholdsverdien i orbok

    print("Det er", len(ord), "ord i setningen din") #antall ord i setning

    return ordbok

ordbok = antallOrd(input("Skriv en setning: "))

for ord in ordbok:
    gang = ""
    bokstav = ""
    if ordbok[ord] == 1:
        gang = "gang"
    else:
        gang = "ganger"
    if antallBokstaver(ord) == 1:
        bokstav = "bokstav"
    else:
        bokstav = "bokstaver"

    print(f"Ordet {ord} forekommer {ordbok[ord]} {gang}, og har {antallBokstaver(ord)} {bokstav}")
    #skriver ut dette for hvert verdi som finnes i ordboka
