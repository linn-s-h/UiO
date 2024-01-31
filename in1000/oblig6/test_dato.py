
#Testprogram for Dato:
from dato import Dato

def main():
    dag = Dato(15, 12, 2002) #sender inn argumenter
    print(dag.hent_aar()) #henter år lagret i dag objektet ved å kalle på metode
                            #som returnerer instansvaribelen

    if dag.sjekk_dag(15): #hvis dag er 15
        print("Lønningsdag!")
    if dag.sjekk_dag(1): #hvis dag er 1
        print("Ny måned, nye muligheter")

    print(dag.hent_dato()) #skriver ut dato til objektet dag
                            #kan lage uendelig med objekter, så må vite hvilken det er snakk om


main()
