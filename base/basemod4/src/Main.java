import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dataBase = "jdbc:mysql://localhost:3306/mod4";
        String user = "root";
        String password = "root";

        try {
            // Устанавливаем соединение с базой данных
            Connection connection = DriverManager.getConnection(dataBase, user, password);

            // Выбираем пользователя с логином "john" из таблицы users
            String selectedUser = "SELECT * FROM users WHERE login = ?";
            PreparedStatement userSt = connection.prepareStatement(selectedUser);
            userSt.setString(1, "john");
            ResultSet userResultSet = userSt.executeQuery();

            //Если user - john, в userId помещяется его id, если нет, то -1
            int userId = -1;
            if (userResultSet.next()) {
                userId = userResultSet.getInt("id");
            }

            // Выбираем товары из таблицы items, принадлежащие категории "hats"
            String selectedItem = "SELECT * FROM items WHERE category = ?";
            PreparedStatement itemSt = connection.prepareStatement(selectedItem);
            itemSt.setString(1, "hats");
            ResultSet itemsResultSet = itemSt.executeQuery();

            // Вставляем новые заказы в таблицу orders
            String insertOrder = "INSERT INTO orders (user_id, item_id) VALUES (?, ?)";
            PreparedStatement orderSt = connection.prepareStatement(insertOrder);

            //вставка нового заказа в orders
            while (itemsResultSet.next()) {
                int itemId = itemsResultSet.getInt("id");
                orderSt.setInt(1, userId);
                orderSt.setInt(2, itemId);
                orderSt.executeUpdate();
            }
            // Выводим содержимое таблицы orders с именами
            String selectedOrder = "SELECT u.login, i.title " + "FROM orders o " +
                    "JOIN users u ON o.user_id = u.id " + "JOIN items i ON o.item_id = i.id";
            ResultSet ordersResultSet = connection.createStatement().executeQuery(selectedOrder);

            //Вывод заказов
            System.out.println("Все заказы:");
            while (ordersResultSet.next()) {
                String userLogin = ordersResultSet.getString("login");
                String itemTitle = ordersResultSet.getString("title");
                System.out.println(userLogin + " " + itemTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}