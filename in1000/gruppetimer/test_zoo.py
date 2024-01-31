from dyr import Dyr

def main():

    sau = Dyr("sau", "Dolly")
    hund = Dyr("hund", "Fido")
    sau_2 = Dyr("sau", "Dolly")

    print(sau.hent_art())
    print(sau) #erstattes av strengen "hei" fra magisk metode #bryr seg bare om __str__ metode
    print(hund) #printer "hei" igjen

    a = 2
    b = 3
    c = a == b #dette er en sammenligning

    print(sau == sau_2) #True #print(sau.__eq__(sau_2))
    print(sau == hund) #False

main()
