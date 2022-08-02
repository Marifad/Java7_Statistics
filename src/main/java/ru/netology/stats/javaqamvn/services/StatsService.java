package ru.netology.stats.javaqamvn.services;

public class StatsService {

    //сумма всех продаж
    public long sumSales(long[] sales) {
        long sumSales = 0;
        for (long sale : sales) {
            sumSales = sumSales + sale;

        }
        return sumSales;
    }


    //средняя сумма продаж в месяц
    public long getAverageSales(long[] sales) {
        int q = 0;
        long sumSales = sumSales(sales);
        for (long sale : sales) {
            q = q + 1;
        }
        long average = sumSales / q;
        return average;
    }

    //номер месяца, в котором был максимум продаж
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {

            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

    //номер месяца, в котором был минимум продаж
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    //кол-во месяцев, в которых продажи ниже среднего
    public int getLessThanAverage(long[] sales) {
        long averageSales = getAverageSales(sales);
        int i = 0;
        for (long sale : sales) {
            if (sale < averageSales) {
                i = i + 1;
            }
        }
        return i;
    }

    //кол-во месяцев, в которых продажи выше среднего
    public int getMoreThanAverage(long[] sales) {
        long averageSales = getAverageSales(sales);
        int i = 0;
        for (long sale : sales) {
            if (sale > averageSales) {
                i = i + 1;
            }
        }
        return i;
    }
}
