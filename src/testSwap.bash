#/bin/bash
#Redefinit a chaque fois le CLASSPATH de maniere a trouver en tete
#le .jar qui contient l'implementation courante

# Mettre le fichier de test (ici TestFV.java et testSwap.bash dans le répertoire
# qui contient les .jar
# Mettre aussi les deux .jar pour junit: hamcrest-core-1.3.jar et junit-4.11.jar
# ou adapter le scripr ci-dessous

# Peu importe le premier .jar qu'on utilise pour compiler qui contient les
# tests (ici TestFV.java)
javac -classpath  .:./main/resources/implementations/swapA.jar:./hamcrest-core-1.3.jar:./junit-4.13.1.jar ./test/java/TestFV.java

# suppose accessible les deux .jar pour junit (hamcrest-core-1.3.jar et junit-4.11.jar)
for f in .main/ressources/implementations/swapA.jar ; do
   echo "Traitement de: " $f
   java -classpath .:$f:./hamcrest-core-1.3.jar:./junit-4.13.1.jar
     org.junit.runner.JUnitCore ../target/test-classes/TestFV
done
