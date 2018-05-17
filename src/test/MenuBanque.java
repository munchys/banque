package test;

import exception.InferieurAZeroException;
import exception.SoldeInsuffisantException;
import model.Compte;
import model.CompteEpargne;
import model.ComptePayant;
import model.CompteSimple;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBanque {
    private String nomBanque;
    private Scanner sc;
    private ArrayList<Compte> listCompte;
    public MenuBanque(String nomBanque)
    {
        this.nomBanque = nomBanque;
        this.sc = new Scanner(System.in);
        listCompte = new ArrayList<>();
    }

    public void menuRetirerArgent(Compte compte)
    {
        System.out.println("Veuillez indiquer le montant a retirer :");
        try
        {
            float montant = sc.nextFloat();
            sc.nextLine();
            compte.retirer(montant);
        }
        catch (InferieurAZeroException e)
        {
            System.out.println(e.getMessage());
            menuRetirerArgent(compte);
            return ;
        }
        catch (SoldeInsuffisantException e)
        {
            System.out.println(e.getMessage());
            menuRetirerArgent(compte);
            return ;
        }
        catch (Exception e)
        {
            sc.next();
            System.out.println("Indiquez un float positif svp !");
            menuRetirerArgent(compte);
        }
    }

    public void menuVerserArgent(Compte compte)
    {
        System.out.println("Veuillez indiquer le montant a verser :");
        try
        {
            float montant = sc.nextFloat();
            sc.nextLine();
            compte.verser(montant);
        }
        catch (InferieurAZeroException e)
        {
            System.out.println(e.getMessage());
            menuVerserArgent(compte);
            return ;
        }
        catch (Exception e)
        {
            sc.next();
            System.out.println("Indiquez un float positif svp !");
            menuVerserArgent(compte);
        }
    }

    public void menuGererCompte(Compte compte)
    {
        System.out.println("Que voulez vous faire avec votre compte ?");
        System.out.println("1- Affichez les informations");
        System.out.println("2- Verser de l'argent");
        System.out.println("3- Retirer de l'argent");
        if (compte instanceof CompteEpargne)
        {
            System.out.println("4- Calculer l'interet");
        }
        System.out.println("5- Quitter");
        try
        {
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1)
            {
                System.out.println("Votre compte : " + compte);
            }
            else if (option == 2)
            {
                this.menuVerserArgent(compte);
            }
            else if (option == 3)
            {
                this.menuRetirerArgent(compte);
            }
            else if (option == 4 && compte instanceof CompteEpargne)
            {
                CompteEpargne compteEpargne = (CompteEpargne)compte;
                compteEpargne.calculInteret();
            }
            else if (option == 5)
            {
                return;
            }
            else
            {
                System.out.println("Merci d'indiquez un chiffre correspondant au menu");
            }
            menuGererCompte(compte);
        }
        catch (Exception es)
        {
            sc.next();
            System.out.println("Merci d'indiquez un chiffre correspondant au menu");
            menuGererCompte(compte);
        }
    }

    public float menuGetSoldeDepart()
    {
        System.out.println("Indiquez le solde de départ :");
        try
        {
            float solde = sc.nextFloat();
            sc.nextLine();
            if (solde < 0)
            {
                System.out.println("Merci d'indiquez un solde positif");
                return menuGetSoldeDepart();
            }
            return solde;
        }
        catch (Exception e)
        {
            sc.next();
            System.out.println("Indiquez un float positif svp !");
            return menuGetSoldeDepart();
        }

    }

    public void menuCreerCompteSimple()
    {
        System.out.println("Pour créer un compte simple merci d'indiquer un float correspondant à l'autorisation de découvert");
        try
        {
            float decouvert = sc.nextFloat();
            sc.nextLine();
            float solde = menuGetSoldeDepart();

            Compte compteSimple = new CompteSimple(solde, decouvert);
            this.listCompte.add(compteSimple);
            menuGererCompte(compteSimple);
        }
        catch (Exception e)
        {
            sc.next();
            System.out.println("Veuillez indiquer un float");
            menuCreerCompteSimple();
        }
    }
    public void menuCreerCompteEpargne()
    {
        System.out.println("Pour créer un compte épargne merci d'indiquer un float correspondant au taux d'intéret");
        try
        {
            float taux = sc.nextFloat();
            sc.nextLine();
            float solde = menuGetSoldeDepart();

            Compte compteEpargne = new CompteEpargne(solde, taux);
            this.listCompte.add(compteEpargne);
            menuGererCompte(compteEpargne);
        }
        catch (Exception e)
        {
            sc.next();
            System.out.println("Veuillez indiquer un float");
            menuCreerCompteEpargne();
        }
    }

    public void menuCreerComptePayant()
    {
        float solde = menuGetSoldeDepart();

        Compte comptePayant = new ComptePayant(solde);
        this.listCompte.add(comptePayant);
        menuGererCompte(comptePayant);
    }



    public void menuCreerCompte()
    {
        System.out.println("Choisissez le type de compte a créer:");
        System.out.println("1- Compte simple");
        System.out.println("2- Compte épargne");
        System.out.println("3- Compte payant");
        System.out.println("4- Quitter");
        try {
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1)
            {
                this.menuCreerCompteSimple();
            }
            else if (option == 2)
            {
                this.menuCreerCompteEpargne();
            }
            else if (option == 3)
            {
                this.menuCreerComptePayant();
            }
            else if (option == 4)
            {
                return ;
            }
            else
            {
                System.out.println("Veuillez indiquez un entier correspondant au menu");
                menuCreerCompte();
            }
        }
        catch (Exception e)
        {
            sc.next();
            System.out.println("Veuillez indiquez un entier correspondant au menu");
            menuCreerCompte();
        }

    }

    public void menuLister(){
        System.out.format("il y a %d comptes :\n", Compte.getNbComptes());
        for(Compte compte : this.listCompte){
            System.out.println(compte);
            System.out.println("-------------");
        }
    }

    public void menuBienvenue()
    {
        System.out.println("Bienvenue dans la banque " + this.nomBanque + " !");
        boolean end = false;
        while (!end) {
            System.out.println("Voici le menu :");
            System.out.println("1- Listez les comptes");
            System.out.println("2- Créer un compte");
            System.out.println("3- Gérer un compte");
            System.out.println("4- Quitter");
            try {
                int option = sc.nextInt();
                sc.nextLine();
                if (option == 1)
                {
                    this.menuLister();
                }
                else if (option == 2)
                {
                    this.menuCreerCompte();
                }
                else if (option == 3)
                {

                }
                else if (option == 4)
                {
                    end = true;
                }
                else
                {
                    System.out.println("Veuillez indiquez un entier correspondant au menu");
                }
            }
            catch (Exception e)
            {
                sc.next();
                System.out.println("Veuillez indiquez un entier correspondant au menu");
            }
        }
    }
}
