class Student:
    def __init__(self):
        self._poeng = 0

    def hent_poeng(self):
        return self._poeng

    def registrer_poeng(self, antall):
        self._poeng += antall


