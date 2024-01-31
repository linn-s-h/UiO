
def forkort_lagliste(lagliste):
    #return list(set(lagliste)) 

    liste = []
    for elem in lagliste:
        if not (elem in liste):
            liste.append(elem)

    return liste

print(forkort_lagliste(["LINN", "SANDER", "LARS", "LARS"]))
