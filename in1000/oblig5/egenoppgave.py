"""
1.  Skriv en funksjon cmTilTommer med ett paramter. Funksjonen skal returnere
    hvor mange tommer paramteret i funksjonen tilsvarer. For å regne om fra
    centimeter til tommer kan du dele paramteret med 2.54.
1.  Utvid programmet med å skrive et beregningsprogram for en skredder som skal
    konvertere mål i cm til tommer, slik at de kan lage en kjole til deg.
    Lag en hoved-funksjon som leser inn et filnavn, der hver linje beskriver navn
    på dine kroppsmål og selve målet i cm.
2.  I funksjonen skal disse målene bli lagt til i en ordbok med navn på målet
    som nøkkelverdi. I tillegg skal den første funksjonen bli kalt på.
3.  Kall på hoved-funksjonen med navnet på filen som argument, sånn at konverteringen
    kan bli skrevet ut.
"""

def cmTilTommer(cm):
    return cm/2.54 #returnerer resultatet av cm til tommer

def main(filnavn):
    guide = {}
    fil = open(filnavn) #åpner fil som er inndata til funksjon
    for linje in fil:
        item = linje.split(",") #gjør om tekststreng om til liste med elementer
        navn_paa_maal = item[0] #definerer første element i samlingen
        maal_i_cm = float(item[1]) #gjør om andre element i samlingen til float verdi
        guide[navn_paa_maal] = maal_i_cm #gir ny verdi i ordbok, hvor navn på mål er nøkkel

        resultat = cmTilTommer(maal_i_cm) #kaller på første funksjon med mål i cm som argument
        print(f"{navn_paa_maal}: {resultat}") #skriver ut tommer

main("storrelsesguide.csv") #kaller på hoved-funksjon med filnavn
