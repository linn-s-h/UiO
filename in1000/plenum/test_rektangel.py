
from rektangel import Rektangel

def main():

    rektangel = Rektangel(10, 22)
    print(rektangel.areal())
    rektangel.endre_storrelse(5,-10)
    print(rektangel.areal())

    """
    rek3 = Rektangel(5,2)
    print(rek3.areal())

    rek3.endre(-2,-1)
    print(rek3.areal())
    """

main()
