package fr.pgah;

import java.util.Random;

public class App {

  public static void main(String[] args) {
    int caseObjectif = 20;
    int nbLancers = 5;

    répéterJusquaGagné(nbLancers, caseObjectif);
  }

  public static void répéterJusquaGagné(int nbLancers, int caseObjectif) {
    Random generateur = new Random();
    boolean gagné = false;
    int compteurSimulations = 0;
    while (!gagné) {
      compteurSimulations++;
      int caseCourante = 0;
      for (int i = 1; i <= nbLancers; i++) {
        caseCourante = lancerDeDés(generateur, caseCourante, i);
      }

      gagné = déterminerRésultatPartie(caseCourante, caseObjectif, compteurSimulations);
    }
  }

  public static int lancerDeDés(Random generateur, int caseCourante, int numéroLancer) {
    int lancer = generateur.nextInt(6) + 1;
    caseCourante = caseCourante + lancer;
    System.out.println(String.format("Lancer %d : vous avez fait %d. Vous êtes sur la case %d.",
        numéroLancer, lancer, caseCourante));
    return caseCourante;
  }

  public static boolean déterminerRésultatPartie(int caseCourante, int caseObjectif,
      int compteurSimulations) {
    boolean gagné = false;
    if (caseCourante == caseObjectif) {
      System.out.println("Vous avez gagné !");
      System.out.println("Il aura fallu " + compteurSimulations + " simulations pour gagner.");
      gagné = true;
    } else if (caseCourante > caseObjectif) {
      System.out.println("Vous dépassez, vous avez perdu !");
    } else {
      System.out.println("Il vous en manque pour arriver à " + caseObjectif + " !");
    }
    return gagné;
  }
}
