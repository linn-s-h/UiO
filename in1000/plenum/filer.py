def hoved():

    fil = open("eksempler.txt", "a")

    fil_2 = open("eks.txt", "r")

    """for linje in fil_2:
        print(linje)""" #to måter å lese linjer

    liste = fil_2.readlines() #gjør om til liste av linjer
    for element in liste:
        fil.write(element)

    fil_2.close()
    fil.close()

hoved()
