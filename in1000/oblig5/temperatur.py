""""dette programmet skal lese inn data fra to filer. den ene filen inneholder
    høyeste temperatur i hver måned mellom årene 1750 og 2017. den andre inneholder
    temperaturen hver dag i 2018. programmet skal lese inn data fra den første filen
    og skrive det ut. så skal det lese inn data fra andre filen og sammenligne høyeste
    temperaturer i første filen med dagstemperatur hver måned i 2018, deretter skrive
    ut beskjed til terminal dersom det er ny varmerekord. """


def min_fil(filnavn):

    temperatur_maaned = {}

    apne_fil = open(filnavn) #åpner fil som er inndata til funksjon
    for linje in apne_fil:
        biter = linje.split(",") #gjør om tekststreng om til liste med elementer
        maaned = biter[0] #velger første element i samling
        temperatur = float(biter[1]) #velger andre element i samling
        temperatur_maaned[maaned] = temperatur #gir ny verdi ordbok

    for key, value in temperatur_maaned.items(): #skriver ut ordboken som funksjonen returnerer
        print(f"{key} : {value}")

    return temperatur_maaned

def main(temperatur_maaned, temperatur_dag):
    apne_dag_fil = open(temperatur_dag) #tar vare på filobjektet i en variabel
    for linje in apne_dag_fil: #går gjennom hver linje i fil
        biter = linje.split(",") #gjør om tekststreng til verdier i en samling
        biter[2] = float(biter[2]) #konverterer daglig temperatur i 2018 til en float verdi
        if biter[2] > temperatur_maaned[biter[0]]: #hvis dagstemperatur en måned i 2018 er høyere enn de siste årene
            print(f"Ny varmerekord på {biter[1]}. {biter[0]}: {float(biter[2])} grader Celsius")
            print(f"(gammel varmerekord {temperatur_maaned[biter[0]]} grader celius)\n")
            temperatur_maaned[biter[0]] = biter[2] #oppdaterer varmeste temperatur


#temp er returverdien til funksjon min_fil, "temp = temperatur_maaned"
temp = min_fil("max_temperatures_per_month.csv") #kaller på funksjon i en variabel med filnavn som argument
main(temp, "max_daily_temperature_2018.csv") #funksjonskallet har returvedien fra første funksjon i tillegg til filnavn som argument

"""main(min_fil("max_temperatures_per_month.csv"), "max_daily_temperature_2018.csv")"""
#kunne gjort det på denne måten
