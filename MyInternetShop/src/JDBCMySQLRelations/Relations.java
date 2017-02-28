package JDBCMySQLRelations;

import java.sql.*;
import java.util.Scanner;

public class Relations {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String name = null;

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/shop", "root", "sweetyy5")) {
			if (conn == null) {
				System.out.println("Нет соединения с БД!");
				System.exit(0);
			}
			System.out.println("Введите 1 если хотите добавить в базу кий");
			System.out.println("Введите 2 если хотите удалить из базы кий");
			System.out.println("Введите 3 если хотите обновить данные в базе");
			System.out
					.println("Введите 4 если хотите вывести данные на консоль");
			System.out.println("Введите 0 для выхода");
			while (true) {
				switch (in.next()) {
				case "1":

					// Заполнение основного материала

					System.out.println("Заполните основной материал кия");
					PreparedStatement ps = conn
							.prepareStatement("INSERT INTO main_material(name) values(?)");
					System.out.println("Введите основной материал");
					name = in.next();
					PreparedStatement preparedStatement = null;
					preparedStatement = conn
							.prepareStatement("SELECT name FROM main_material  where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение дерева

					System.out
							.println("Заполните какое дерево используется через дефис");
					ps = conn
							.prepareStatement("INSERT INTO wood(name) values(?)");
					System.out.println("Введите дерево");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM wood where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение феруля

					System.out.println("Заполните какая феруля используется");
					ps = conn
							.prepareStatement("INSERT INTO ferula(name) values(?)");
					System.out.println("Введите ферулю");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM ferula where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение вида запила

					System.out
							.println("Заполните какой вид запила используется");
					ps = conn
							.prepareStatement("INSERT INTO gash_type(name) values(?)");
					System.out.println("Введите вид запила");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM gash_type where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение наклейки

					System.out.println("Заполните какая наклейка используется");
					ps = conn
							.prepareStatement("INSERT INTO sticker(name) values(?)");
					System.out.println("Введите наклейку");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM sticker where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение типа наклейки

					System.out
							.println("Заполните какой тип наклейки используется");
					ps = conn
							.prepareStatement("INSERT INTO type_sticker(name) values(?)");
					System.out.println("Введите тип наклейки");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM type_sticker where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение кольцо торцов

					System.out
							.println("Заполните какоe кольцо торцов используется");
					ps = conn
							.prepareStatement("INSERT INTO ring_end(name) values(?)");
					System.out.println("Введите кольцо торцов");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM ring_end where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение кольцо бампера

					System.out
							.println("Заполните какоe кольцо бампера используется");
					ps = conn
							.prepareStatement("INSERT INTO ring_bumper(name) values(?)");
					System.out.println("Введите кольцо бампера");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM ring_bumper where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение амортизацию

					System.out
							.println("Заполните какая амортизация используется");
					ps = conn
							.prepareStatement("INSERT INTO damper(name) values(?)");
					System.out.println("Введите амортизацию");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM damper where name = ?");
					fillField(ps, preparedStatement, name);

					// Заполнение запилов

					System.out.println("Заполните какие запилы используются");
					System.out.println("Заполните шафт");
					ps = conn
							.prepareStatement("INSERT INTO shaft(name) values(?)");
					System.out.println("Введите шафт");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM shaft where name = ?");
					fillField(ps, preparedStatement, name);

					PreparedStatement psGash = conn
							.prepareStatement("INSERT INTO gash(id_shaft,id_butt) values(?,?)");
					preparedStatement = conn
							.prepareStatement("SELECT id FROM shaft where name = ?");
					preparedStatement.setString(1, name);
					ResultSet res = preparedStatement.executeQuery();
					psGash.setInt(1, res.getInt("id"));

					System.out.println("Заполните турняк");
					ps = conn
							.prepareStatement("INSERT INTO butt(name) values(?)");
					System.out.println("Введите турняк");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM butt where name = ?");
					fillField(ps, preparedStatement, name);

					preparedStatement = conn
							.prepareStatement("SELECT id FROM butt where name = ?");
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(2, res.getInt("id"));
					psGash.executeUpdate();
					psGash.close();

					// Заполнение скрутки

					System.out.println("Заполните какая скрутка используются");
					System.out.println("Заполните материал скрутки");
					ps = conn
							.prepareStatement("INSERT INTO material_joint(name) values(?)");
					System.out.println("Введите материал скрутки");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM material_joint where name = ?");
					fillField(ps, preparedStatement, name);

					psGash = conn
							.prepareStatement("INSERT INTO joint(id_material_joint,id_carving_joint) values(?,?)");
					preparedStatement = conn
							.prepareStatement("SELECT id FROM material_joint where name = ?");
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(1, res.getInt("id"));

					System.out.println("Заполните вид резьбы");
					ps = conn
							.prepareStatement("INSERT INTO carving_joint(name) values(?)");
					System.out.println("Введите вид резьбы");
					name = in.next();
					preparedStatement = conn
							.prepareStatement("SELECT name FROM carving_joint where name = ?");
					fillField(ps, preparedStatement, name);

					preparedStatement = conn
							.prepareStatement("SELECT id FROM carving_joint where name = ?");
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(2, res.getInt("id"));
					psGash.executeUpdate();
					psGash.close();

					// Заполнение всей таблицы

					System.out.println("Заполните всю таблицу");
					ps = conn
							.prepareStatement("INSERT INTO main(id_main_material,price,id_wood,name,weight,id_ferula,id_gash_type,id_gash,id_sticker,id_type_sticker,length,id_joint,id_ring_end,id_ring_bumper,id_damper) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

					preparedStatement = conn
							.prepareStatement("SELECT id FROM main_material where name = ?");
					System.out.println("Введите основной материал");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(1, res.getInt("id"));

					System.out.println("Введите цену данного кия");
					psGash.setInt(2, in.nextInt());

					preparedStatement = conn
							.prepareStatement("SELECT id FROM wood where name = ?");
					System.out
							.println("Введите дерево какое используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(3, res.getInt("id"));

					System.out.println("Введите название данного кия");
					psGash.setString(4, in.next());

					System.out.println("Введите вес данного кия");
					psGash.setInt(5, in.nextInt());

					preparedStatement = conn
							.prepareStatement("SELECT id FROM ferula where name = ?");
					System.out
							.println("Введите ферулю которая используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(6, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM gash_type where name = ?");
					System.out
							.println("Введите вид запила который используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(7, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM shaft where name = ?");
					System.out.println("Введите шафт данного кия");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					int a = res.getInt("id");
					preparedStatement = conn
							.prepareStatement("SELECT id FROM butt where name = ?");
					System.out.println("Введите турняк данного кия");
					name = in.next();
					preparedStatement.setString(1, name);
					ResultSet res1 = preparedStatement.executeQuery();
					int b = res1.getInt("id");
					preparedStatement = conn
							.prepareStatement("SELECT id FROM gash where id_shaft = ? AND id_butt = ?");
					preparedStatement.setInt(1, a);
					preparedStatement.setInt(2, b);
					res = preparedStatement.executeQuery();
					psGash.setInt(8, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM sticker where name = ?");
					System.out
							.println("Введите наклейку которая используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(9, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM type_sticker where name = ?");
					System.out
							.println("Введите тип наклейки которая используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(10, res.getInt("id"));

					System.out.println("Введите длинну данного кия");
					psGash.setInt(11, in.nextInt());

					preparedStatement = conn
							.prepareStatement("SELECT id FROM material_joint where name = ?");
					System.out.println("Введите материал скрутки данного кия");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					a = res.getInt("id");
					preparedStatement = conn
							.prepareStatement("SELECT id FROM carving_joint where name = ?");
					System.out.println("Введите резьбу скрутки данного кия");
					name = in.next();
					preparedStatement.setString(1, name);
					res1 = preparedStatement.executeQuery();
					b = res1.getInt("id");
					preparedStatement = conn
							.prepareStatement("SELECT id FROM joint where id_material_joint = ? AND id_carving_joint = ?");
					preparedStatement.setInt(1, a);
					preparedStatement.setInt(2, b);
					res = preparedStatement.executeQuery();
					psGash.setInt(12, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM ring_end where name = ?");
					System.out
							.println("Введите кольцо торцов которое используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(13, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM ring_bumper where name = ?");
					System.out
							.println("Введите кольцо бампера которое используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(14, res.getInt("id"));

					preparedStatement = conn
							.prepareStatement("SELECT id FROM damper where name = ?");
					System.out
							.println("Введите амортизацию которое используется в данном кие");
					name = in.next();
					preparedStatement.setString(1, name);
					res = preparedStatement.executeQuery();
					psGash.setInt(15, res.getInt("id"));
					psGash.executeUpdate();
					psGash.close();

					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					ps = conn.prepareStatement("SELECT * FROM butt");
					res = ps.executeQuery();
					while (res.next()) {
						System.out.println(res.getInt(2) + " " + res.getInt(3)
								+ " " + res.getInt(4) + " " + res.getString(5)
								+ " " + res.getInt(6) + " " + res.getInt(7)
								+ " " + res.getInt(8) + " " + res.getInt(9)
								+ " " + res.getInt(10) + " " + res.getInt(11)
								+ " " + res.getInt(12) + " " + res.getInt(13)
								+ " " + res.getInt(14)+" "+res.getInt(15)+" "+res.getInt(16));
					}
					break;
				default:
					in.close();
					return;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void fillField(PreparedStatement ps,
			PreparedStatement preparedStatement, String name)
			throws SQLException {
		preparedStatement.setString(1, name);
		ResultSet res = preparedStatement.executeQuery();
		if (res.first()) {
			System.out.println("Уже есть в таблице");
		} else {
			ps.setString(1, name);
			ps.executeUpdate();
		}
		ps.close();
	}

}
