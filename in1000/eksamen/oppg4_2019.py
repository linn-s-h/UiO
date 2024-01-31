
class Rett:

    def __init__(self, navn, pris, innholdsstoffer):
        self._navn = navn
        self._pris = pris
        self._innholdsstoffer = []

    def sjekkInnholdOK(self, innholdsstoffer):
        for stoff in innholdsstoffer:
            if stoff in self._innholdsstoffer:
                return False

        return True

    def __str__(self):
        return f"Rett: {self._navn} Pris: {self._pris} Innholdsstoffer: {self._innholdsstoffer}"

class Kategori:

    def __init__(self, kategorinavn, retter):
        self._kategorinavn = kategorinavn
        self._retter = retter

    def hentOkRetter(self, innholdsstoffer):
        ok_retter = []
        for rett in self._retter:
            if rett.sjekkInnholdOK(innholdsstoffer):
                ok_retter.append(rett)

        return ok_retter

    def skrivUtRetter(self):
        print(f"Til {self._kategorinavn}")
        for rett in self._retter:
            print(rett)

class Meny:

    def __init__(self, kategorier): #forrett, hovedrett, desserter
        self._meny = {} #kateforinavn : Kategori()
        for kategorinavn in kategoerier:
            kat_obj = self._les_kategori_fil(kategorinavn + txt)
            self._meny[kategorinavn] = kat_obj

    def hent_redusert_meny(self, innholdsstoffer):
        ny_ordbok = {}
        for kategori in self._meny:
            retter = self._meny[kategori].hentOkRetter(innholdsstoffer)
            if len(retter) > 0: #legger retter til i menyen
                ny_ordbok[kategori] = self._meny[kategori]

        return ny_ordbok

class Kunde:

    def __init__(self, tlfnr, innholdsstoffer):
        self._tlfnr = tlfnr
        self._innholdsstoffer = innholdsstoffer

    def velgRetter(self, meny):
        bestillinger = []
        kategori_ordbok = meny.hent_redusert_meny(innholdsstoffer)

        for kategorinavn in kategori_ordbok:
            kategori_ordbok[kategorinavn].skrivUtRetter()
            svar = input("Velg retten du ønsker: ")
            if svar != "":
                bestillinger.append(svar)

        return bestillinger #pannekake, biff, is

class Takeaway:

    def __init__(self, navn_liste, kundefil):
        self._meny = Meny(kategorier)
        self._kundekatalog = self._les_kundefil(kundefil)
        #tlfnr : Kunde()

    def betjenkunde(self):
        if tlfnr in self._kundekatalog:
            kunde = self._kundekatalog[tlfnr]
            bestillinger = kunde.velgRetter(self._meny)
            self.lag_og_lever_mat(bestillinger)
        else:
            print(f"Beklager, vi fant ikke tlfnr: {tlfnr}")

    def lag_og_lever_mat(self, bestilling):
        print("Dette har du bestilt")
        nr = 1
        for rett in bestillinger:
            print(f"{nr}: {rett}") #1. Biff
            nr += 1

def hovedprogram():

    kategorier = ["Forretter", "Hovedretter", "Desserter"]
    takeaway = Takeaway(kategorier, "kunder.txt")
    kunde_nr = input("Telefonnummer: ")
    while kunde_nr != "":
        takeaway.betjenkunde(kunde_nr)
        kunde_nr = input("Skriv inn telefonnummer eller hitt enter for å avslutte: ")

hovedprogram()
