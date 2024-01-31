alder = int(input("skriv inn alder:" ))

if alder < 6 and alder > 3:
    print("Lek i skogen")
elif alder < 3:
    print("Lek i lekegrinda")

#eller

if alder < 3:
    print("Lek i lekegrinda")
elif alder < 6:
    print("Lek i skogen")

#eller løsning med møsting

if alder < 6:
    if alder < 3:
        print("Lek i lekegrinda")
    else:
        print("Lek i skogen")
