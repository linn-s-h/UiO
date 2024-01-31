""" dette programmet skal lage epost til studenter basert på brukernavnet
    deres. bruker kan lage så mange ønsket og skal lagres til en samling.
    hele samnlingen skal kunne oppdateres og skrives ut, for hver gang ny epost er lagt til"""


def lagBrukernavn(fullt_navn):
    fullt_navn = fullt_navn.split( ) #gjør om fornavn og etternavn til seperate verdier i en samling
    brukernavn = fullt_navn[0] + fullt_navn[1][0] #gir fornavn og den første bokstaven i etternavnet

    return brukernavn

def lagEpost(prefix, suffix):
    epost = prefix + "@" + suffix #sender dette når funksjonen blir kalt på

    return epost

def skrivUtEposter(ordbok):
    for elem in ordbok: #går gjennom hvert element i ordbok (som da er evaluert til student_epost)
        print(lagEpost(elem, ordbok[elem])) #printer ut epost


def hoved_prosedyre():

    student_epost = {} #ordbok med alle epost som blir laget
    fortsett_program = True

    while (fortsett_program == True): #så lenge if-setning gir true så vil programmet fortsette

        bruker_inp = input("Tast inn i for å lage e-post, \np for å se alle e-post \neller s for å avslutte: ").lower()

        if bruker_inp == "i":
            prefix = input("Skriv inn navnet: ").lower() #bruker skriver inn fullt navn som blir til prefix
            suffix = input("Skriv inn e-post suffix: ").lower() #bruker skriver inn suffix som legges til slutten av e-post

            brukernavn = lagBrukernavn(prefix) #kaller på funksjon med prefix som argument og definerer det i en variabel
            epost = lagEpost(brukernavn, suffix) #kaller på funksjon med brukernavn og suffix som argument, som gir fullstendig e-post
            student_epost[brukernavn] = suffix #lagrer ny verdi i ordbok for e-poster

        if bruker_inp == "p":
            skrivUtEposter(student_epost) #kaller på funksjon som skriver ut epost bestående av brukernavn og e-post suffix
        if bruker_inp == "s":
            fortsett_program = False #gir false og avslutter programmet

hoved_prosedyre()
