def prosedyre():
    alder = int(input("Hva er alderen din? "))
    billettpris = 0
    if alder <= 17:
        print("Billettpris: 30kr")
    elif alder > 17 < 63:
        print("Billettpris: 50kr")
    elif alder > 63:
        print("Billettpris: 35kr")

prosedyre()
