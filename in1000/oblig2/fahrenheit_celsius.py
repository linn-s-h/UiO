#programmet skal konvertere fra fahrenheit til celsius
#og bruker angir grader i fahrenheit de ønsker å konvertere

fahrenheit = int(input("Konverter fra fahrenheit til celsius: "))
print(fahrenheit, "fahrenheit")

celsius = ((fahrenheit) - 32) * 5/9 #bruker formell fra oppgaven
print(celsius, "celsius")
print(f"{fahrenheit} i fahrenheit er {celsius} i celsius.") #printer ut konverteringen til bruker
