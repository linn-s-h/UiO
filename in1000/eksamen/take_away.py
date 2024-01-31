
class Rett:

    def __init__(self, navn, pris, innholdsstoffer):
        self._navnPaaRett = navn
        self._pris = float(pris)
        self._innholdsstoffer = []

    def sjekkInnholdOK(self, innholdsstoffer):
        for stoff in innholdsstoffer:
            if stoff in self._innholdsstoffer:
                return False
        return True

    def __str__(self):
        return f"{self._navnPaaRett} ({self._pris}kr): {self._innholdsstoffer}"

class Kategori:

    def __init__(self, kategorinavn, retter):
        self._kategorinavn = kategorinavn
        self._retter = retter #Liste med Rett-objekter

    def hentOkRetter(self, innholdsstoffer):
        okRetter = []
        for rett in self._retter:
            if rett.sjekkInnholdOK(innholdsstoffer):
                okRetter.append(rett)

        return okRetter

class Meny:

    def __init__(self, kategoriliste):
        self._meny = {}
        for kategorinavn in kategoriliste:
            nyKat = self._lesKategoriFil(kategorinavn, ".txt")
            self._meny[kategorinavn] = nyKat

    def hentRedusertMeny(self, innholdsstoffer):
        okMeny = {}
        for kat in self._meny:
            okRetter = self._meny[kat].hentOkRetter(innholdsstoffer)
            okMeny[kat] = Kategori(kat, okRetter)

        return okMeny

class Kunde:

    def __init__(self, tlfnummer, innholdsstoffer):
        self._tlfnummerKunde = tlfnummer
        self._innholdsstoffer = innholdsstoffer

    def velgRetter(self, meny):
        okMeny = meny.hentRedusertMeny(self._innholdsstoffer)
        bestilling = []
        for kat in okMeny:
            visKategori = ""
            print(kat.upper(),":")
            for rett in okMeny[kat]:
                visKategori.append(rett)
            print(visKategori)
            bestillRett = input("Hva ønsker du å bestille?\n> ")
            if not bestillRett == " ":
                bestilling.append(bestillRett)

        return bestilling

class TakeAway:

    def __init__(self, kategoriliste, kundefil):
        self._ferdigMeny = kategoriliste #Liste med kategorier som skal brukt til å starte tjenesten
        self._kundeKatalog = self._lesKundefil(kundefil)

    def betjenKunde(self, tlfnummer):
        kunde = self._kundeKatalog[tlfnummer] #referanse til Kunde-objekter #Kunde(data[0], data[1:])
        bestilling = kunde.velgRetter(self._ferdigMeny) #hente bestilling fra velgRetter i klasse Kunde
        self._lagOgLeverMat(bestilling)

    def _lagOgLeverMat(self, bestilling):
        skrivUtBestilling = ""
        skrivUtBestilling += bestilling
        print(f"Bestillingen din er klargjort: {skrivUtBestilling}. Takk for at du bestilte hos oss!")

    def _lesKundefil(self, kundefil):
        kunder = {}
        fil = open(kundefil, "r")
        for linje in fil:
            data = linje.strip().split()
            kunder[data[0]] = Kunde(data[0], data[1:])
        fil.close()
        return kunder


#Hovedprogram
tjeneste = TakeAway(["Forretter", "Hovedretter, Desserter"], "kunder.txt")
tlf = input("Hei! Hva er tlfnummeret ditt?\n> ")
fortsettTjeneste = True
while fortsettTjeneste == True:
    if tlf != " ":
        tjeneste.betjenKunde(tlf)
        tlf = input("Hei! Hva er tlfnummeret ditt?\n> ")
    else:
        fortsettTjeneste = False
