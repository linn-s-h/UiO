
class Hytte:

    def __init__(self, hytteNavn, antSenger, pris):
        self._hytteNavn = hytteNavn
        self._antSenger = antSenger
        self._overnattingPris = pris

    def hentNavn(self):
        return self._hytteNavn

    def totPris(self, antPersoner):
        return self._overnattingPris * antPersoner

    def sjekkPlass(self, antPersoner):
        return self._antSenger >= antPersoner

    def __str__(self):
        str = f"{self._hytteNavn}: {self._antSenger} senger ({self._overnattingPris}kr per seng)"
        return str

    def __eq__(self):
        return self._hytteNavn == annen._hytteNavn

class Tur:

    def __init__(self, tekst, hytteReferanser):
        self._tekstStreng = tekst
        self._hytterReferanser = hytteReferanser

    def skrivTur(self): #Tenk! Hvordan ser Tur() ut?
        print(f"\n{self._tekstStreng}")
        for hytte in self._hytterReferanser:
            print(hytte)

    def sjekkPrisPlass(self, antPersoner, maxBelop):
        for hytte in self._hytterReferanser:
            if not hytte.sjekkPlass(antPersoner):
                return False
            if not hytte.totPris(antPersoner) < maxBelop:
                return False

        return True

    def hentAntHytter(self):
        return len(self._hytterReferanser)

class Turplanlegger:

    def __init__(self, hyttefil, turfil):
        self._hytterOrdbok = self._hytterFraFil(hyttefil)
        self._turerListe = self._turerFraFil(turfil)

    def _hytterFraFil(self, hyttefil):

        hytter = {}

        fil = open(hyttefil, "r")
        for linje in fil:
            data = linje.strip().split(" ")
            hytteNavn = str(data[0])
            antSenger = int(data[1])
            pris = float(data[2])
            hytteReferanse = Hytte(hytteNavn, antSenger, pris)
            hytter[hytteNavn] = hytteReferanse

        fil.close()
        return hytter

    def _turerFraFil(self, turfil):

        teller = 0
        turer = [] #denne listen skal inneholde tekst-streng og referanser til hytter

        fil = open(turfil, "r")
        for linje in fil:
            if teller == 0: #linje 1
                beskrivelse = linje.strip()
                teller += 1
            elif teller == 1: #linje 2

                hytter_i_turen = []

                hData = linje.strip().split(" ")
                for hytte in hData:
                    if hytte in self._hytterOrdbok:
                        hytter_i_turen.append(self._hytterOrdbok[hytte])

                turer.append(Tur(beskrivelse, hytter_i_turen))
                teller = 0 #teller må settes til 0 igjen

        fil.close()
        return turer

    def finnTurer(self, antPersoner, maxBelop, maxAntDager):
        #maxAntDager skal sammenlignet opp mot antall hytter/overnatting per tur

        for tur in self._turerListe:
            if tur.sjekkPrisPlass(antPersoner, maxBelop): #metoder er fra Tur-klasse
                if tur.hentAntHytter() <= maxAntDager:
                    tur.skrivTur()

#Testprogram:
planleggTur = Turplanlegger("hytter.txt", "turer.txt")
planleggTur.finnTurer(7, 7000, 5)
