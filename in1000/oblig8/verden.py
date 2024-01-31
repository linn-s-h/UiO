from rutenett import Rutenett

class Verden:
    def __init__(self, rader, kolonner):
        self._rutenett = Rutenett(rader, kolonner) #oppretter rutenett objekt som instans, krever to argumenter
        self._generasjonsnummer = 0 #generasjonsnummer settes til lik 0
        self._rutenett.fyll_med_tilfeldige_celler()
        self._rutenett.koble_celler()

    def tegn(self): #metode som tegner rutenett, samt forteller generasjonsnummer og ant levende celler
        self._rutenett.tegn_rutenett()
        print(f"Generasjonsnummer: {self._generasjonsnummer} – Antall levende celler: {self._rutenett.antall_levende()}")

    def oppdatering(self): #metode som:

        for celle in self._rutenett.hent_alle_celler(): #teller antall levende naboer for hver celle
            celle.tell_levende_naboer()

        for celle in self._rutenett.hent_alle_celler(): #oppdaterer status på hver celle
            celle.oppdater_status()                     #som gir neste generasjons rutenett

        self._generasjonsnummer += 1 #oppdaterer generasjonsnummer
