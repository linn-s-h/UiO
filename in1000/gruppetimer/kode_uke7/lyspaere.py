class Lyspaere:
    def __init__(self):
        self._paa = False

    def er_paa(self):
        return self._paa

    def tenne(self):
        self._paa = True

    def slukke(self):
        self._paa = False


# Tester klassen

utelampe = Lyspaere()
assert not utelampe.er_paa()

utelampe.tenne()
assert utelampe.er_paa()
utelampe.slukke()
assert not utelampe.er_paa()

print("Alle tester kjoert og ok!")
