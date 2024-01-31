"""
1.  Dette programmet er et system som lar bruker holde styr på, legge til,
    slette bursdager og skrive ut sine venners bursdager fra ordbok eller
    ordbok av lister.
2.  Lag en ordbok hvor navnet på vennene er nøkkelverdien og bursdagsatoen
    deres er innholdsverdien. Deretter bruk en if-setning for å la bruker velge
    mellom flere alternativer til hvordan de kan endre eller holde styr på lista.
3.  Bruk for-løkker inne i if-setninger for å utføre de forskjellige mulighetene.
    Husk at du if-setningene skal være i samme innrykk.
4.  Sett deretter if-setningene i en funskjon sånn at ordboken av bursdagslister
    refresher seg for hver gang bruker gjør en endring. På slutten av funksjonen
    skal du spørre bruker om de vil fortsette å endre på listen, og kall på
    funksjonen hvis bruker skriver inn ja.
"""
#startpunktet av funksjonen
bursdager_original = {"lars":"11/04",
                    "kaja": "07/12",
                    "julie":"04/07",
                    "natalie":"26/03",
                    "jonas":"30/11"}

#setter resten i en funksjon sånn at ordboken oppdaterer seg for hver gjennomkjøring
def gjenta(bursdager):
    #bruker kan velge mellom flere måter å endre ordboken av bursdager på
    spm = input("""Ønsker du å:
    \n(a) Se hele bursdagslisten?
    \n(b) Sjekke når noen har bursdag?
    \n(c) Legge til en bursdag?
    \n(d) Eller slette en bursdag?\n""").lower()

    if spm == "a":
        for navn in bursdager: #kjører for alle indeks i ordboka
            print(navn, bursdager[navn]) #skriver ut key og verdi som tilhører key

    elif spm == "b":
        for person in bursdager:
            print(person) #skriver ut alle keys i ordboka som bruker kan velge mellom
        inpPerson = input("Hvem da? ").lower()
        if inpPerson in bursdager: #hvis navnet er i orboka, finner frem verdi tilsvarende spesifisert key
            print(inpPerson, "har bursdag", bursdager.get(inpPerson))

    elif spm == "c":
        inpLeggTilNavn = input("Skriv in navn: ")
        inpLeggTilDato = input("Skriv inn bursdagsdato i format [dd/mnd]: ")
        bursdager[inpLeggTilNavn] = inpLeggTilDato #legger til ny verdi i ordboka
        for navn in bursdager:
            print(navn, bursdager[navn]) #printer ut ny bursdagsliste med
                                         #alle nøkkelverdier og tilhørende verdi
    elif spm == "d":
        slett = input("Hvem vil du slette fra listen? ") #brukers input er indeks
        bursdager.pop(slett) #sletter key og verdi fra basert på indeksen

    else:
        print("Ugyldig.")

    #spør bruker om de vil forsette og gjentar funksjonen hvis ja
    fortsette = input("Vil du fortsette? ").lower()
    if fortsette == "ja":
        gjenta(bursdager) #kaller på funksjonen

gjenta(bursdager_original)
