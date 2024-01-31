def skriv_med_trykk(parameter):
    print(parameter + "!")

i = 0
cont = True
while i < 5 and cont == True:
    inn = input("Gi meg et kraftuttrykk! ")
    if (inn.lower() == "nei"):
        cont = False
    else:
        skriv_med_trykk(inn)
