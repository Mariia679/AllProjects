package LessonJDBC;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Connection це інтерфейс, реалізація якого є у всіх драйверах БД
		 * використовується для того, що б доступитись до БД якщо об’єкт
		 * створився, то звязок БД встановлено і можна працювати
		 * DriverManager.getConnection(String url, String user, String password)
		 * Менеджер реєструє усі драйвери які є в classpath метод поветрає
		 * Connection за url який по суті для кожної БД різний також необхідно
		 * правильно вказати користувача і пароль Connection створюється в
		 * try-with-resources для того щоб самостійно не закривати*
		 */
		Scanner in = new Scanner(System.in);
		String name = null;

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/LessonJDBC", "root", "sweetyy5")) {
			// Statement st=conn.createStatement();
			// st.execute("CREATE TABLE gash(id int PRIMARY KEY AUTO_INCREMENT, id_shaft int,id_butt int)");
			// st.close();

			// ПОПРОСИТЬ ПОСМОТРЕТЬ А ТО ЧТО-ТО Я СОМНЕВАЮСЬ В ПРАВИЛЬНОСТИ ТОГО
			// ЧТО СДЕЛАЛА

			// PreparedStatement ps = conn
			// .prepareStatement("INSERT INTO gash(id_shaft,id_butt) values(?,?)");
			// PreparedStatement preparedStatement = conn
			// .prepareStatement("SELECT id FROM shaft where name = ?");
			//name = in.next();
			// preparedStatement.setString(1, name);
			// ResultSet res = preparedStatement.executeQuery();
			// while (res.next()) {
			// ps.setInt(1, res.getInt("id"));
			// }
			// preparedStatement = conn
			// .prepareStatement("SELECT id FROM butt where name = ?");
			//name = in.next();
			// preparedStatement.setString(1, name);
			// res = preparedStatement.executeQuery();
			// while (res.next()) {
			// ps.setInt(2, res.getInt("id"));
			// }
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO shaft(name) values(?)");
			name = in.next();
			PreparedStatement preparedStatement = null;
			preparedStatement = conn
					.prepareStatement("SELECT name FROM shaft where name = ?");
			fillField(ps,preparedStatement,name);

			// ps.setString(2, "fdghd");
			// ps.setInt(3, 450);
			// ps.executeUpdate();
			// ps.setInt(1, 2);
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 650);
			// ps.executeUpdate();
			// ps.setString(1, "6x3 grab");
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 540);
			// ps.executeUpdate();
			// ps.setString(1, "Temnuj grab");
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 1200);
			// ps.executeUpdate();
			// ps.setString(1, "grab");
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 650);
			// ps.executeUpdate();
			// ps.setString(1, "Kolocok");
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 3650);
			// ps.executeUpdate();
			// ps.setString(1, "3x4 black grab");
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 250);
			// ps.executeUpdate();
			// ps.setString(1, "black grab");
			// ps.setString(2, "fdghd");
			// ps.setInt(3, 800);
			// ps.executeUpdate();
			// ps.close();
			// PreparedStatement ps =
			// conn.prepareStatement("SELECT * FROM butt");
			// ResultSet rs = ps.executeQuery();
			// while (rs.next()) {
			// System.out.println(rs.getString(2) + "   " + rs.getString(3)
			// + "   " + rs.getInt(4));
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void fillField(PreparedStatement ps,PreparedStatement preparedStatement,String name) throws SQLException{
		preparedStatement.setString(1, name);
		ResultSet res = preparedStatement.executeQuery();
		if (res.first()) {
			System.out.println("Такой материал уже есть в таблице");
		} else {
			ps.setString(1, name);
			ps.executeUpdate();
		}
		ps.close();
	}
}