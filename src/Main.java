import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    //main

    private static final String url = "jdbc:mysql://localhost:3306/ptmk";
    private static final String user = "root";
    private static final String password = "admin";

    private static Connection con;
    private static Statement stnt;
    private static ResultSet res;

    public static void main(String[] args) {


        try {
            con = DriverManager.getConnection(url, user, password);
            stnt = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            boolean input = false;
            while(!input) {
                System.out.println("Выберите пуннкт меню: ");
                System.out.println("1. Добавить строку в таблицу");
                System.out.println("2. Создать миллион записей в таблице");
                System.out.println("3. Выбрать все строки с уникальными ФИО + дата");

                int choise = scanner.nextInt();

                if (choise == 1) {
                    addUser();
                } else if (choise == 2) {
                    createBillionUsers();
                } else if (choise == 3) {
                    selectUniqueUsers();
                } else {
                    System.out.println("Выыйти? (yes/no)");
                    if(scanner.nextLine().contains("yes"))
                        input = true;
                }
            }



        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException sqlExF) {
            }
            try {
                stnt.close();
            } catch (SQLException sqlExF) {
            }
            try {
                res.close();
            } catch (SQLException sqlExF) {
            }
        }
    }


    public static void addUser() throws SQLException, IOException, ParseException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ФИО: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату в формате ДД.ММ.ГГГГ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dateStr = scanner.nextLine();
        System.out.println("Введите ваш пол m/f: ");
        char sex = (char) scanner.nextByte();

        java.sql.Date date = new Date(sdf.parse(dateStr).getTime());

        commitToSQL(name, date, sex);



    }

    public static void createBillionUsers() throws SQLException {

        for (int i = 1; i < 1000000; i++) {
            int rnd = (int) (Math.random() * 2);
            if(rnd == 0) {
                commitToSQL(RandomFullName.getMaleFullName(), RandomDate.getRandomDate(), 'm');
            } else {
                commitToSQL(RandomFullName.getFemaleFullName(), RandomDate.getRandomDate(), 'f');
            }
        }
    }

    public static void selectUniqueUsers() throws SQLException {

        String req = "SELECT * FROM ptmk.users where fullname in \n" +
                "(SELECT DISTINCT fullname from ptmk.users) and birth in (SELECT distinct birth from ptmk.users) ORDER BY fullname;";

        res = stnt.executeQuery(req);

        while (res.next()) {
            String resultFIO = res.getString(1);
            Date date = res.getDate(2);
            char sex = (char) res.getByte(3);

            System.out.println(resultFIO + " " + date + " " + sex);

        }
    }

    public static void commitToSQL(String fullname, Date birth, char sex) throws SQLException{
        String add = "INSERT INTO ptmk.users (fullname, birth, sex) VALUES (" + "'" + fullname + "'" + ", "
                + "'" + birth + "'" + ", " + "'" +sex + "'" + ");";

        stnt.executeUpdate(add);
    }
}