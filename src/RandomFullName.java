import java.util.ArrayList;

    //Ну создай ты уже БД.
public class RandomFullName {
    private static ArrayList<String> namesM = new ArrayList<>();
    private static ArrayList<String> namesF = new ArrayList<>();
    private static ArrayList<String> lastNamesM = new ArrayList<>();
    private static ArrayList<String> lastNamesF = new ArrayList<>();
    private static ArrayList<String> patronymicsM = new ArrayList<>();
    private static ArrayList<String> patronymicsF = new ArrayList<>();
    static {
        //мужские имена
        namesM.add("Антон");
        namesM.add("Андрей");
        namesM.add("Иван");
        namesM.add("Даниил");
        namesM.add("Федор");
        namesM.add("Максим");
        namesM.add("Валерий");
        namesM.add("Михаил");
        namesM.add("Евгений");
        namesM.add("Сергей");
        namesM.add("Станислав");
        namesM.add("Степан");
        namesM.add("Макар");
        namesM.add("Павел");
        namesM.add("Петр");
        namesM.add("Леонид");
        namesM.add("Леон");
        namesM.add("Олег");
        namesM.add("Остап");
        namesM.add("Анатолий");

        //женские имена
        namesF.add("Анна");
        namesF.add("Аделина");
        namesF.add("Алена");
        namesF.add("Ася");
        namesF.add("Белла");
        namesF.add("Валерия");
        namesF.add("Василиса");
        namesF.add("Глория");
        namesF.add("Диана");
        namesF.add("Дора");
        namesF.add("Евгения");
        namesF.add("Екатерина");
        namesF.add("Лариса");
        namesF.add("Людмила");
        namesF.add("Сабрина");
        namesF.add("Софья");
        namesF.add("Татьяна");
        namesF.add("Тина");
        namesF.add("Юнона");
        namesF.add("Яна");

        //Мужские фамилии
        lastNamesM.add("Артемьев");
        lastNamesM.add("Беляков");
        lastNamesM.add("Беспалов");
        lastNamesM.add("Григорьев");
        lastNamesM.add("Денисов");
        lastNamesM.add("Евсеев");
        lastNamesM.add("Исаков");
        lastNamesM.add("Коновалов");
        lastNamesM.add("Наумов");
        lastNamesM.add("Некрасов");
        lastNamesM.add("Петров");
        lastNamesM.add("Сафонов");
        lastNamesM.add("Семёнов");
        lastNamesM.add("Фомин");
        lastNamesM.add("Фёдоров");
        lastNamesM.add("Устинов");
        lastNamesM.add("Шаров");
        lastNamesM.add("Шилов");
        lastNamesM.add("Яковлев");
        lastNamesM.add("Якушев");

        //Женские фамилии
        lastNamesF.add("Артемьева");
        lastNamesF.add("Белякова");
        lastNamesF.add("Беспалова");
        lastNamesF.add("Григорьева");
        lastNamesF.add("Денисова");
        lastNamesF.add("Евсеева");
        lastNamesF.add("Исакова");
        lastNamesF.add("Коновалова");
        lastNamesF.add("Наумова");
        lastNamesF.add("Некрасова");
        lastNamesF.add("Петрова");
        lastNamesF.add("Сафонова");
        lastNamesF.add("Семёнова");
        lastNamesF.add("Фомина");
        lastNamesF.add("Фёдорова");
        lastNamesF.add("Устинова");
        lastNamesF.add("Шарова");
        lastNamesF.add("Шилова");
        lastNamesF.add("Яковлева");
        lastNamesF.add("Якушева");

        //Мужские отчества
        patronymicsM.add("Адамович");
        patronymicsM.add("Арсенович");
        patronymicsM.add("Бориславович");
        patronymicsM.add("Валентинович");
        patronymicsM.add("Васильевич");
        patronymicsM.add("Гавриилович");
        patronymicsM.add("Георгиевич");
        patronymicsM.add("Давидович");
        patronymicsM.add("Данилович");
        patronymicsM.add("Дмитриевич");
        patronymicsM.add("Егорович");
        patronymicsM.add("Ермолаевич");
        patronymicsM.add("Ефстафьевич");
        patronymicsM.add("Игнатович");
        patronymicsM.add("Игоревич");
        patronymicsM.add("Матвеевич");
        patronymicsM.add("Трифонович");
        patronymicsM.add("Федосеевич");
        patronymicsM.add("Филатович");
        patronymicsM.add("Харламович");

        //Женские отчества
        patronymicsF.add("Адамовна");
        patronymicsF.add("Арсеновна");
        patronymicsF.add("Бориславовна");
        patronymicsF.add("Валентиновна");
        patronymicsF.add("Васильевна");
        patronymicsF.add("Гаврииловна");
        patronymicsF.add("Георгиевна");
        patronymicsF.add("Давидовна");
        patronymicsF.add("Даниловна");
        patronymicsF.add("Дмитриевна");
        patronymicsF.add("Егоровна");
        patronymicsF.add("Ермолаевна");
        patronymicsF.add("Ефстафьевна");
        patronymicsF.add("Игнатовна");
        patronymicsF.add("Игоревна");
        patronymicsF.add("Матвеевна");
        patronymicsF.add("Трифоновна");
        patronymicsF.add("Федосеевна");
        patronymicsF.add("Филатовна");
        patronymicsF.add("Харламовна");
    }

    static  int i = 0;

    public static String getMaleFullName(){

        int rnd1 = randIndex();
        int rnd2 = randIndex();
        int rnd3 = randIndex();

        if (rnd1 == 13 || rnd1 == 14) {
            if(i == 100)
            {
                while (rnd1 == 13 || rnd1 == 14)
                    rnd1 = randIndex();
            } else {
                i++;
            }
        }


        return  lastNamesM.get(rnd1) + " " + namesM.get(rnd2) + " " + patronymicsM.get(rnd3);

    }

    public static String getFemaleFullName(){
        int rnd1 = randIndex();
        int rnd2 = randIndex();
        int rnd3 = randIndex();

        return lastNamesF.get(rnd1) + " " + namesF.get(rnd2) + " " + patronymicsF.get(rnd3);
    }

    private static int randIndex(){
        return  (int) (Math.random() * (19));
    }
}
