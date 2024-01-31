
class Onske:

    def __init__(self, beskrivelse, antall, mimPris):
        self._beskrivelse = beskrivelse
        self._antall = antall
        self._mimPris = mimPris

    def passer(self, maxPris):
        return self._antall == 0 and self._mimPris >= maxPris

    def valgt(self):
        self._antall += 1
        return self._beskrivelse

    def __str__(self):
        return str({self._beskrivelse}), "Minimumspris:", str({self._mimPris})

class Onskeliste:

    def __init__(self):
        self._onsker = []

    def nytt_onske(self, beskrivelse, ant, mimPris):
        onske = Onske(beskrivelse, ant, mimPris)
        self._onsker.append(onske)

    def hent_onsker(self, maxPris):
        onskerOversikt = []
        for onske in self._onsker:
            if onske.passer(maxPris):
                onskerOversikt.append(onske)
            else:
                onskerOversikt.append("Ikke valgbart onske")

        return onskerOversikt #oversikt over ønsker som passer for giver å oppfylle (innenfor max pris)

    def onske_oppfylles(self, valgtOnske):
        self._onsker[valgtOnske].valgt() #gir beskrivelse av ønske som blir oppfylt

class Gave:

    def __init__(self, beskrivelse, gaveGiver):
        self._beskrivelse = beskrivelse
        self._gaveGiver = gaveGiver

    def __str__(self):
        str = f"{self._beskrivelse} – Fra {self._gaveGiver}"
        return str

class Juleferiekalender:

    #når det er en parameter i konstruktøren som ikke skal brukes til en instansvariabel,
    #så betyr det at det skal brukes til noe annet i konstruktøren og ikke andre metoder
    def __init__(self, antDager):
        self._kalender = {}
        self._opprett_kalender() #trenger ikke metode, kan gjøres i konstruktøren

    def opprett_kalender(self):
        dagnummer = 25
        for i in range(antDager):
            self._kalender[dagnummer] = None
            dagnummer += 1
            if dagnummer == 32: #eller > 31, vi vil at 31 skal med
                dagnummer = 1

    def ny_gave(self, beskrivelse, gaveGiver, dagnummer):
        ny_gave = Gave(beskrivelse, gaveGiver)
        self._kalender[dagnummer] = ny_gave

    def hent_dagens_gave(self, dagnummer):

        gave = self._kalender[dagnummer]

        if dagnummer > 24:
            mnd = "desember"
        if dagnummer < 25:
            mnd = "januar"
        if not gave == None:
            gaveTekst = "Ingen gave i dag"
        else:
            gaveTekst = str(gave)

        return f"{dagnummer}. {mnd}: {gaveTekst}"

    def hent_ant_dager(self):
        return len(self._kalender) #antDager blir 31 dager men starter fra 0,1,2...

class Julegavefikser:

    def __init__(self, antDager, nesteDag):
        self._kalender = Juleferiekalender(antDager)
        self._nesteDag = 25 #første dagen etter jula, starten på juleferien
        self._onskeliste = Onskeliste() #oppretter liste av onsker som onskeliste
        self.les_onsker_fra_fil(filnavn) #trengs egt ikke

    def les_onsker_fra_fil(self, filnavn):

        fil = open(filnavn, "r")
        for linje in fil:
            data = linje.strip().split(";")
            beskrivelse = data[0]
            antall = int(data[1])
            mimPris = int(data[2])
            self._onskeliste.nytt_onske(beskrivelse, antall, mimPris)

        fil.close()

    #utvide-metoder:
    def velg_gave(self, giver):
        maxPris = int(input("Hva er max pris på det du vil gi i gave? "))
        tilpassetOnsker = self._onskeliste.hent_onsker(maxPris)

        onskeNr = 0
        for onske in tilpassetOnsker:
            print(f"Onske {onskeNr}: {onske}") #nummerert oversikt
            onskeNr += 1

        valgtOnske = int(input("Hvilken gave vil du gi? "))
        beskrivelse = self._onskeliste.onske_oppfylles(valgtOnske) #ønske blir oppdatert som gitt 1 gang
                                                                   #og beskrivelsen oppdatert
        antDager = self._kalender.hent_ant_dager()
        dag = 24+antDager #antDager er 31
        dato = f"{dag}. desember" #None
        if dag > 31: #kan IKKE være '== 32', for da vil ikke if sjekken gå
            dato = f"{dag-31}. januar"
        #Dette er egentlig bare masse unødvendig bullshit.

        print(f"Juleferiekalender starter fra og med 25. desember og slutter {dato}")
        valgtDag = int(input("Hvilken dag i kalenderen vil du legge gaven? "))
        self._kalender.ny_gave(beskrivelse, giver, valgtDag)

    def ny_dag(self):
        apnetLuke = self._kalender.hent_dagens_gave(self._nesteDag)
        self._nesteDag += 1
        if self._nesteDag == 32:
            self._nesteDag = 1
        return apnetLuke
