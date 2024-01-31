
i = 1
inpSvar = input("vil du telle? ")
if inpSvar == "y":
    inp = input("tell til ")
    while i < int(inp) + 1:
        print(i)
        i += 1
else:
    print("din teiting")

"""
5 skriv inn verdi
6 når i er mindre enn input, start igjen
8 legg til 1 til i
"""
