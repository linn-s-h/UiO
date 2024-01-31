
def stjerner(numb):

    stjerner = ""
    for iterasjon in range(numb):
        stjerner += "*"
        print(stjerner)


numb = int(input("skriv inn et tall: "))
print(stjerner(numb))
