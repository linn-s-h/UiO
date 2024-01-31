class StudentMedNavn:
    def __init__(self, navn):
        self._poeng = 0
        self._navn = navn

    def hent_poeng(self):
        return self._poeng

    def registrer_poeng(self, antall):
        self._poeng += antall

    def skriv_ut(self):
        print(self._navn, "har totalt", self._poeng, "poeng")


