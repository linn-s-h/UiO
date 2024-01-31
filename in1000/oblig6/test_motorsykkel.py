
#Testprogram for Motorsykkel:
from motorsykkel import Motorsykkel

def main(): #gir objekter merke og registreringsnummer
    sykkel_1 = Motorsykkel("Yamaha", "PZ3599") #lagrer forskjellige instansvarbler i objekt av samme klasse
    sykkel_2 = Motorsykkel("Ducati", "VN1923")
    sykkel_3 = Motorsykkel("Triumph", "EL5412")

    #skriver ut motorsyklene ved å kalle på metode
    sykkel_1.skriv_ut()
    sykkel_2.skriv_ut()
    sykkel_3.skriv_ut()

    sykkel_3.kjor(10) #øker km avstand til siste motorsykkel med 10
    sykkel_3.skriv_ut() #tester at km avstand til motorsykkelen har oppdatert seg


main()
