def format_text(tekst, filnavn, maks_ord):
    tekst_copy = tekst
    ord = tekst_copy.strip().split(" ")
    fil = open(filnavn, "w")

    max = 0
    for i in ord:
        if max >= maks_ord:
            fil.write("\n" + i + " ")
            max += 1
        else:
            fil.write(i + " ")
            max += 1

format_text("jeg heter Sujani", "format.txt", 2)