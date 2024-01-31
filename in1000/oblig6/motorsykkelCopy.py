
class Motorsykkel:

    def __init__(self, merke, registreringsnummer):

        self._kilometeravstand = 0
        self._merke = merke
        self._registreringsnummer = registreringsnummer

    def kjor(self, km):
        self._kilometeravstand += km

    def hent_kilometeravstand(self):
        return self._kilometeravstand

    def hent_merke(self):
        return self._merke

    def hent_registreringsnummer(self):
        return self._registreringsnummer

    def skriv_ut(self):
        print(self.hent_kilometeravstand())
        print(self.hent_merke())
        print(self.hent_registreringsnummer())

        """return self.hent_kilometeravstand, self.hent_merke, self.hent_registreringsnummer"""

        #Testprogrammet
        """print(sykkel_3.hent_kilometeravstand())""" #kunne gjort det på denne måten
