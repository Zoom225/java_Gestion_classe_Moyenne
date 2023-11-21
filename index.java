import java.util.Scanner;

public class index{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables pour la classe
        int totalEtudiants = 0;
        int totalEchecsMatiere1 = 0;
        int totalEchecsMatiere2 = 0;
        int etudiantsSansEchec = 0;
        double totalNotesMatiere1 = 0;
        double totalNotesMatiere2 = 0;

        // Saisie des données pour chaque étudiant
        System.out.println("Entrez les données pour chaque étudiant (matricule = 0 pour arrêter) :");

        while (true) {
            System.out.print("Matricule de l'étudiant : ");
            int matricule = scanner.nextInt();

            // Vérification pour arrêter le programme
            if (matricule == 0) {
                break;
            }

            // Saisie des résultats pour chaque matière
            System.out.print("Note en matière 1 (/20) : ");
            double noteMatiere1 = scanner.nextDouble();

            System.out.print("Note en matière 2 (/20) : ");
            double noteMatiere2 = scanner.nextDouble();

            // Calcul de la moyenne
            double moyenne = (noteMatiere1 + noteMatiere2) / 2;

            // Affichage des résultats pour chaque étudiant
            System.out.println("Résultats pour l'étudiant " + matricule + ":");
            System.out.println("Moyenne : " + moyenne);
            System.out.println("Nombre d'échecs : " + nombreEchecs(noteMatiere1, noteMatiere2));

            // Mise à jour des statistiques pour la classe
            totalEtudiants++;
            totalNotesMatiere1 += noteMatiere1;
            totalNotesMatiere2 += noteMatiere2;

            if (nombreEchecs(noteMatiere1, noteMatiere2) == 0) {
                etudiantsSansEchec++;
            }

            totalEchecsMatiere1 += (noteMatiere1 < 10) ? 1 : 0;
            totalEchecsMatiere2 += (noteMatiere2 < 10) ? 1 : 0;
        }

        // Affichage des statistiques pour la classe
        System.out.println("\nStatistiques pour l'ensemble de la classe :");
        System.out.println("Moyenne en matière 1 : " + totalNotesMatiere1 / totalEtudiants);
        System.out.println("Moyenne en matière 2 : " + totalNotesMatiere2 / totalEtudiants);
        System.out.println("Nombre d'échecs en matière 1 : " + totalEchecsMatiere1);
        System.out.println("Nombre d'échecs en matière 2 : " + totalEchecsMatiere2);
        System.out.println("Nombre d'étudiants sans échec : " + etudiantsSansEchec);
    }

    // Fonction pour calculer le nombre d'échecs
    private static int nombreEchecs(double noteMatiere1, double noteMatiere2) {
        int echecs = 0;
        echecs += (noteMatiere1 < 10) ? 1 : 0;
        echecs += (noteMatiere2 < 10) ? 1 : 0;
        return echecs;
    }
}
