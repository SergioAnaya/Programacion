public class Main {

    public static void main(String[] args) {

        RankingPilotos ranking=new RankingPilotos();


        ranking.añadirPiloto(new Piloto(1 ,"Bottas V." ,"Mercedes"), 1);
        ranking.añadirPiloto(new Piloto(2 ,"Vettel S.","Ferrari"),2);
        ranking.añadirPiloto(new Piloto(3 ,"Verstappen M.", "Red Bull"),3);
        ranking.añadirPiloto(new Piloto(4 ,"Leclerc C.","Ferrari"),4);
        ranking.añadirPiloto(new Piloto(5 ,"Hamilton L.", "Mercedes"),5);
        ranking.añadirPiloto(new Piloto(6 ,"Albon A.", "Red Bull"),6);
        ranking.añadirPiloto(new Piloto(7 ,"Sainz Jr. C.", "McLaren"),7);
        ranking.añadirPiloto(new Piloto(8 ,"Norris L.", "McLaren"),8);
        ranking.añadirPiloto(new Piloto(9 ,"Ricciardo D.", "Renault"),9);
        ranking.añadirPiloto(new Piloto( 10 ,"Gasly P.","Toro Rosso"),10);
        ranking.añadirPiloto(new Piloto(11 ,"Hülkenberg N.", "Renault"),11);
        ranking.añadirPiloto(new Piloto(12 ,"Magnussen K.", "Haas"),12);
        ranking.añadirPiloto(new Piloto(13 ,"Kvyat D.","Toro Rosso"),13);
        ranking.añadirPiloto(new Piloto(14 ,"Stroll L.", "Racing Point"),14);
        ranking.añadirPiloto(new Piloto(15 ,"Grosjean R.", "Haas"),15);
        ranking.añadirPiloto(new Piloto(16 ,"Giovinazzi A.", "Alfa Romeo"),16);
        ranking.añadirPiloto(new Piloto(17 ,"Räikkönen K.", "Alfa Romeo"),17);
        ranking.añadirPiloto(new Piloto(18 ,"Russel G.", "Williams"),18);
        ranking.añadirPiloto(new Piloto(19 ,"Kubica R.", "Williams"),19);
        ranking.añadirPiloto(new Piloto(20 ,"Pérez S.", "Racing Point"),20);

        System.out.println("ORDENADOS POR NOMBRE");
        ranking.ordenarPilotosPorNombre();
        System.out.println(ranking.toString());

        System.out.println("ORDENADOS POR POSICION DE SALIDA");
        ranking.ordenarPilotosPorPosicionDeSalida();
        System.out.println(ranking.toString());


        ranking.adelantarPiloto("Hamilton L.");
        ranking.adelantarPiloto("Hamilton L.");
        ranking.adelantarPiloto("Magnussen K.");
        ranking.adelantarPiloto("Magnussen K.");
        ranking.adelantarPiloto("Magnussen K.");
        System.out.println("PUNTO 3");
        System.out.println(ranking.toString());

        ranking.descalificarPiloto("Albon A.");
        ranking.descalificarPiloto("Grosjean R.");
        System.out.println("PUNTO 4");
        System.out.println(ranking.toString());

        ranking.retrasarPiloto("Norris L.");
        ranking.retrasarPiloto("Norris L.");

        System.out.println("PUNTO 5");
        System.out.println(ranking.toString());

    }

}