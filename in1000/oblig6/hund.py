"""dette programmet er et oppskrift på hvordan objektet skal være
    og i dette tilfellet så har objektet pluto: alder og vekt"""

class Hund:

    def __init__(self, alder, vekt): #parametere som forventer argumenter sendt inn fra testprogram
        #setter alder, vekt og metthet til objektet pluto
        self._alder = alder
        self._vekt = vekt
        self._metthet = 10

    def hent_alder(self):
        return self._alder #returnerer verdi ved metodekall (returnerer self sin instans)

    def hent_vekt(self): #grensesnitt som tilbyr objektet til å endre vekt
        return self._vekt #returnerer vekt når metode blir kalt

    def spring(self):
        self._metthet = self._metthet -1 #metthet minsker med 1 for hver gjennomkjøring
        if self._metthet < 5: #hvis mindre enn 5
            self._vekt = self._vekt -1 #minsker vekt med 1

    def spis(self, mengde): #mengde er hvor mye mat objektet får i seg, forventer argument
        self._metthet += mengde #legger til mengde i metthet
        if self._metthet > 7: #hvis metthet større enn 7
            self._vekt += 1 #øker vekt med 1
