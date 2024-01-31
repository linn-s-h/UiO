
"""v1"""

def minste(a, b, c):

    minste = a
    if b < a:
        minste = b
    if c < b:
        minste = c
    return minste

print(minste(3.5, 1.4, 5.8))

"""v2"""

def minste(a, b, c):
    minste = a
    if a<b and a<c:
        return a
    if b<a and b<c:
        return b
    if c<a and c<b:
        return c

print(minste(3.5, 1.4, 5.8))
print(minste(100.6, 94.3, 555.8))

"""v3"""

def minste(a, b, c):
    liste = [a, b, c]
    liste.sort() #liste.sort(reverse=True)
    return liste[0]

print(minste(3.5, 1.4, 5.8))
print(minste(100.6, 94.3, 555.8))
