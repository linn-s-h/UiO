
class Rektangel:

    def __init__(self, lengde, bredde):
        self._lengde = lengde
        self._bredde = bredde

    def areal(self):
        return self._lengde * self._bredde

    def endre_storrelse(self, ny_lengde, ny_bredde):
        self._lengde += ny_lengde
        self._bredde += ny_bredde

        
