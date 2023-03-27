------------------------------------------------------------------------
Dies ist die README-Datei des Projekts. Hier sollten Sie Ihr Projekt
beschreiben.
Erzählen Sie dem Leser (jemand, der nichts über dieses Projekt weiss),
alles, was er/sie wissen muss. Üblicherweise sollte der Kommentar 
zumindest die folgenden Angaben umfassen:
------------------------------------------------------------------------

PROJEKTBEZEICHNUNG:
PROJEKTZWECK:
VERSION oder DATUM:
WIE IST DAS PROJEKT ZU STARTEN:
AUTOR(EN):
BENUTZERHINWEISE:


wichtig:



Open a command prompt.

Go to the directory where you have your .java files

Create a directory build

Run java compilation from the command line

-->	javac -d ./build *.java

if there are no errors, in the build directory you should have your class tree

move to the build directory and do a

-->	jar cvf YourJar.jar *
--> (alt) java Start (public static void main(String[] args))

For adding manifest check jar command line switches
