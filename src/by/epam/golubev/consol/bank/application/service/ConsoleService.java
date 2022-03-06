package by.epam.golubev.consol.bank.application.service;

public class ConsoleService {

    public void creteConsoleForCustomerMenu() {
        System.out.print("Выберите действие");
        System.out.print("\n1.Войти в аккаунт");
        System.out.print("\n2.Зарегистрироватся");
        System.out.print("\n3.Выход");
    }

    public void creteConsoleForEnterCustomerMenu() {
        System.out.print("Выберите действие");
        System.out.print("\n1.Создать счёт");
        System.out.print("\n2.Переводы");
        System.out.print("\n3.Пополнить счёт");
        System.out.print("\n4.Изменить данные пользователя");
        System.out.print("\n5.Меню администратора");
        System.out.print("\n6.Выход из аккаунта");
    }

    public void creteConsoleForTransactionMenu() {
        System.out.print("Выберите действие");
        System.out.print("\n1.Перевести на другой свой счёт");
        System.out.print("\n2.Перевести на другой счёт");
        System.out.print("\n3.Назад");
    }
    public void createConsoleForAdminMenu(){
        System.out.print("Выберите действие");
        System.out.print("\n1.Список пользователей");
        System.out.print("\n2.Дать права администратора");
        System.out.print("\n3.Удалить пользователя");
        System.out.print("\n4.Назад");
    }
}
