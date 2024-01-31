"""dette programmet er et oppskrift på hvordan objektet skal være
    og i dette tilfellet så er et objekt motorsykkel med kilometeravstand, merke og
    registreringsnummer"""

class Motorsykkel: #hva vi skal modullere

    def __init__(self, merke, registreringsnummer): #konstruktør med parametre og forventer argument fra testprogrammet
        #setter kilometeravstand, merke og registreringsnummer
        self._kilometeravstand = 0
        self._merke = merke
        self._registreringsnummer = registreringsnummer

    def kjor(self, km): #metode som øker verdi til instantvaribelen med argument i testprogram
        self._kilometeravstand += int(km)

    def hent_kilometeravstand(self): #metode som returnerer oppdatert km
        return self._kilometeravstand

    def skriv_ut(self): #metode som skriver ut tilstanden til objekt
        print(self._kilometeravstand)
        print(self._merke)
        print(self._registreringsnummer)
