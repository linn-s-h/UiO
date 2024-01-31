"""dette programmet er et oppskrift på hvordan objektet skal være
    og i dette tilfellet så har objektet dato: dag, måned og år"""

class Dato:
    #konstruktør setter parametere til å være argumenter
    #og instansvariabeler som blir lagret og klassen husker for alltid
    def __init__(self, ny_dag, ny_maaned, nytt_aar): #kalles automatisk ved opprettelse av objektet dag
        self._dag = ny_dag
        self._maaned = ny_maaned
        self._aar = nytt_aar

    def hent_aar(self):
        return self._aar #returnerer år når metode blir kalt

    def hent_dato(self):
        dato = (f"{self._dag}.{self._maaned}.{self._aar}") #lagrer dato som en tekstreng "15.12.2002"
        return dato

    def sjekk_dag(self, ny_dag):
        if self._dag == ny_dag: #sjekker om parameter oppgitt er lik det som er lagret i klassen
            return True #fortsetter programmet hvis det stemmer
        else:
            return False #vil ikke trigge if-setning i testprogram
