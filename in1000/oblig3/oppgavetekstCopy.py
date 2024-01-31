

print("Stemmer hovedstaden? (ja/nei)")

quiz = []
spm = input("Vietnam - Hanoi\n").lower()
quiz.append(spm)
spm = input("Kambosja - Manila\n").lower()
quiz.append(spm)
spm = input("Indonesia - Jakarta\n").lower()
quiz.append(spm)
spm = input("Timor-Leste - Dili\n").lower()
quiz.append(spm)

if quiz.count("ja") == 3:
    print("Riktig!")
else:
    print("Feil.")



spørsmål = ["Hvilken farge er vannmelon på innsiden?\n",
            "Hvilken farge er agurk på utsiden?\n",
            "Hvilken form har kloden vår?\n"]

svar = ["rosa", "blå", "rød",
        "fiolett", "grønn", "hvit",
        "sylinder", "kube", "kule"]
i = 0
while i < len(spørsmål):
    print(spørsmål[i])
    print(alternativer[i])
    i = i + 1
    inp = input().lower()

    if inp == svar[i]:
        print("riktig!")
    else:
        print("feil!")
