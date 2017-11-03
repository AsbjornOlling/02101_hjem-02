02101 Indledende programmering Hjemmeopgave 2

**Gruppens medlemmer**

Asbjørn Kjær Olling (S163615)

Oliver Sander Poulsen (s174122)

**Arbejdsdelingen**

Rapport:

Oliver Sander Poulsen og Asbjørn Kjær Olling.

**Problem 1 \[Text analysis\]:**

Asbjørn Kjær Olling

**Problem 2 \[Run a Simulation\]:**

Asbjørn Kjær Olling

**Problem 3 \[Design a Class\]:**

Asbjørn Kjær Olling

**Beskrivelse af programmer**

**Problem 1 \[Text analysis\]:**

I programmet Text analysis bruges der en scanner til at åbne tekstfilen,
der skal analyseres. Der startes et whileloop, hvor der ses på en enkelt
linje af gangen.

Hver linje deles op i ord, og objektet ”wordCount” tæller op med én for
hvert ord. Derudover oprettes der et array hvor alle ord, der ikke
allerede findes i arrayet, tilføjes til det. Til sidst er der objektet
”immediateRepetitions”, der tæller hvor mange gange det samme ord går
igen.

I tilfælde af at wordCount skulle overgå maxNoOfWords, vil whileloopet
stoppe.

**Problem 2 \[Run a Simulation\]:**

**Problem 3 \[Design a Class\]:**

Den første konstruktør sætter MovingPoints punkt i origo, med en vinkel
på 90 og en hastighed på 0. Herefter vil den anden konstruktør tjekke
for indputs for ”move”, ”turnBy” og ”accelerateBy”, så MovingPoint kan
bevæge sig rundt. I metoden ”move”, udregnes de nye x og y koordinater
ud fra retningen (vinklen omregnet til radianer), hastigheden og
duration.\
”turnBy” kan ændres så retningens værdi kun kan findes indenfor
intervallet \[0;360\].\
Til sidst er der ”acclerateBy”, der er ændringen i hastigheden. Her
sikres det, at hastigheden ikke kan være negativ, så hvis hastigheden
sættes til noget negativt, vil den blive ændret til 0.

Herudover har vi lavet en løsning, hvor en negativ hastighed vil medføre
at punktet vender 180 grader og bevæger sig i den modsatte regning. F.
eks. Hvis punktet bevæger sig med 10 og modtager en ændring på -12, vil
den nu bevæge sig 2, men nu i den modsatte retning.
