# SoftwareEngineeringTestingEksamen
Eksamensoppgave SET Gruppe 15

Følgende funksjonalitet er lagt til i prosjektet:

Admin: 
- Admin kan se liste over brukere, og slette de.
- Admin kan se liste over guider, og slette de.
- Admin kan se liste over turer, og slette de. 
- Når Admin sletter en tur vil turen også bli slettet i turlisten til en bruker dersom brukeren har booked turen

Bruker:
- Bruker kan opprette en bruker.
- Bruker kan redigere brukerinformasjon.
- Bruker kan se en oversikt over turer.
- Bruker kan booke en tur.
- Bruker kan se liste over bookede turer
- Bruker kan unbooke turer

Guide: 
- Guide kan opprette en Guide.
- Guide kan redigere brukerinformasjon.
- Guide kan legge til en tur
- Guide kan nå se en liste over alle turer h*n arrangerer 
- Guide kan slette en tur h*n arrangerer. Denne turen vil da også bli slettet i turlisten til en bruker dersom brukeren har booked turen


Systemet: 
- Alle brukere kan logge inn og ut
- Systemet husker hvilken profil som er innlogget.
- Systemet krever at du har et brukernavn for å kunne logge inn som Guide, Bruker eller admin, og ber deg opprette bruker dersom du ikke har et brukernavn som stemmer overens med informasjonen i databasen. 
- Systemet viser feilmeldinger dersom du har gjort noe feil/systemet ikke klarer å håndtere. 
  - f.eks:
  - Dersom du prøver å booke en tur uten å velge en tur
  - Dersom du prøver å booke en tur som allerede er booket
  - Dersom du prøver å unnbooke en tur uten å velge en tur 
  - Dersom du prøver å slette en profil(Guide, User) uten å velge en profil
  - Dersom du prøver å opprette en profil(Guide, User) uten å fylle ut alle feltene
  - Dersom du prøver å legge til en tur som guide uten å fylle ut alle feltene. 

Improvments: 
- When Admin deletes a Guide, the guides trips should also be deleted.
