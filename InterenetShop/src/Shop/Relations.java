package Shop;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Relations {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		String name = null;
		int c = 0;
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "sweetyy5");
		properties.setProperty("useUnicode", "true");
		properties.setProperty("characterEncoding", "UTF-8");

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/shop", properties)) {
			while (true) {
				System.out.println("Введите 1 если хотите добавить в базу кий");
				System.out.println("Введите 2 если хотите удалить из базы кий");
				System.out
						.println("Введите 3 если хотите обновить данные в базе");
				System.out
						.println("Введите 4 если хотите вывести данные на консоль");
				System.out.println("Введите 0 для выхода");
				switch (in.next()) {
				case "1":
					fillAll(conn);
					break;
				case "2":
					PreparedStatement ps = conn
							.prepareStatement("SELECT * FROM main WHERE name = ?");
					System.out.println("Введите название кия");
					name = in.next();
					c = findID(conn, ps, name);
					PreparedStatement preparedStatement = conn
							.prepareStatement("DELETE FROM main where id = ?");
					preparedStatement.setInt(1, c);
					preparedStatement.executeUpdate();
					preparedStatement.close();
					break;
				case "3":
					switchUpdate(conn);
					break;
				case "4":
					viewAll(conn);
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

	static void viewAll(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM main");
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			System.out.println(res.getInt(2) + " " + res.getInt(3) + " "
					+ res.getInt(4) + " " + res.getString(5) + " "
					+ res.getInt(6) + " " + res.getInt(7) + " " + res.getInt(8)
					+ " " + res.getInt(9) + " " + res.getInt(10) + " "
					+ res.getInt(11) + " " + res.getInt(12) + " "
					+ res.getInt(13) + " " + res.getInt(14) + " "
					+ res.getInt(15) + " " + res.getInt(16));
		}
	}

	static void fillField(PreparedStatement ps,
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

	static void switchUpdate(Connection conn) throws SQLException {
		while (true) {
			System.out.println("Введите 1 если хотите поменять ферулю");
			System.out.println("Введите 2 если хотите поменять наклейку");
			System.out.println("Введите 3 если хотите поменять тип наклейки");
			System.out.println("Введите 4 если хотите поменять скрутку");
			System.out.println("Введите 5 если хотите поменять кольцо бампера");
			System.out.println("Введите 6 если хотите поменять кольцо торцов");
			System.out.println("Введите 7 если хотите поменять амортизацию");
			System.out.println("Введите 8 если хотите поменять цену");
			System.out.println("Введите 0 для выхода в основное меню");
			int c = 0;
			String name = null;
			switch (in.next()) {
			case "1":
				System.out.println("Введите ферулю");
				name = in.next();
				ferula(conn, name);
				PreparedStatement preparedStatement = conn
						.prepareStatement("SELECT id FROM ferula where name = ?");
				c = findID(conn, preparedStatement, name);
				PreparedStatement ps = conn
						.prepareStatement("UPDATE main SET id_ferula = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "2":
				System.out.println("Введите наклейку");
				name = in.next();
				sticker(conn, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM sticker where name = ?");
				c = findID(conn, preparedStatement, name);
				ps = conn
						.prepareStatement("UPDATE main SET id_sticker = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "3":
				System.out.println("Введите тип наклейки");
				name = in.next();
				typeSticker(conn, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM type_sticker where name = ?");
				c = findID(conn, preparedStatement, name);
				ps = conn
						.prepareStatement("UPDATE main SET id_type_sticker = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "4":
				preparedStatement = conn
						.prepareStatement("SELECT id FROM material_joint where name = ?");
				System.out.println("Введите материал1 скрутки");
				name = in.next();
				materialJoint(conn, name);
				int a = findID(conn, preparedStatement, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM carving_joint where name = ?");
				System.out.println("Введите материал2 скрутки");
				name = in.next();
				carvingJoint(conn, name);
				int b = findID(conn, preparedStatement, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM joint where id_material_joint = ? AND id_carving_joint = ?");
				preparedStatement.setInt(1, a);
				preparedStatement.setInt(2, b);
				ResultSet res = preparedStatement.executeQuery();
				if (res.first()) {
					c = res.getInt("id");
				} else {
					ps = conn
							.prepareStatement("INSERT INTO joint(id_material_joint,id_carving_joint) values(?,?)");
					ps.setInt(1, a);
					ps.setInt(2, b);
					ps.executeUpdate();
					ps.close();
					preparedStatement = conn
							.prepareStatement("SELECT id FROM joint where id_material_joint = ? AND id_carving_joint = ?");
					preparedStatement.setInt(1, a);
					preparedStatement.setInt(2, b);
					ResultSet res1 = preparedStatement.executeQuery();
					if (res1.first()) {
						c = res1.getInt("id");
					}
				}
				ps = conn
						.prepareStatement("UPDATE main SET id_joint = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "5":
				System.out.println("Введите кольцо бампера");
				name = in.next();
				ringBumper(conn, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM ring_bumper where name = ?");
				c = findID(conn, preparedStatement, name);
				ps = conn
						.prepareStatement("UPDATE main SET id_ring_bumper = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "6":
				System.out.println("Введите кольцо торцов");
				name = in.next();
				ringEnd(conn, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM ring_end where name = ?");
				c = findID(conn, preparedStatement, name);
				ps = conn
						.prepareStatement("UPDATE main SET id_ring_end = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "7":
				System.out.println("Введите амортизацию");
				name = in.next();
				damper(conn, name);
				preparedStatement = conn
						.prepareStatement("SELECT id FROM damper where name = ?");
				c = findID(conn, preparedStatement, name);
				ps = conn
						.prepareStatement("UPDATE main SET id_damper = ? WHERE name = ?");
				mainUpdate(ps, c);
				break;
			case "8":
				ps = conn
						.prepareStatement("UPDATE main SET price = ? WHERE name = ?");
				System.out.println("Введите название кия");
				ps.setString(2, in.next());
				System.out.println("Введите цену данного кия");
				ps.setInt(1, in.nextInt());
				ps.executeUpdate();
				ps.close();
				break;
			default:
				return;
			}
		}
	}

	static void ferula(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO ferula(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT * FROM ferula where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static int findID(Connection conn, PreparedStatement preparedStatement,
			String name) throws SQLException {
		preparedStatement.setString(1, name);
		ResultSet res = preparedStatement.executeQuery();
		int c = 0;
		while (res.next()) {
			c = res.getInt("id");
		}
		return c;
	}

	static void sticker(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO sticker(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM sticker where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void typeSticker(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO type_sticker(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM type_sticker where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void ringBumper(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO ring_bumper(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM ring_bumper where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void ringEnd(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO ring_end(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM ring_end where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void damper(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO damper(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM damper where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void materialJoint(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO material_joint(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM material_joint where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void carvingJoint(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO carving_joint(name) values(?)");
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT name FROM carving_joint where name = ?");
		fillField(ps, preparedStatement, name);
	}

	static void mainUpdate(PreparedStatement ps, int c) throws SQLException {
		System.out.println("Введите название кия");
		String name = in.next();
		ps.setInt(1, c);
		ps.setString(2, name);
		ps.executeUpdate();
		ps.close();
	}

	static void fillAll(Connection conn) throws SQLException {
		System.out.println("Заполните всю таблицу");
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO main(id_main_material,price,id_wood,name,weight,id_ferula,id_gash_type,id_gash,id_sticker,id_type_sticker,length,id_joint,id_ring_end,id_ring_bumper,id_damper) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		PreparedStatement psGash = conn
				.prepareStatement("INSERT INTO main_material(name) values(?)");
		System.out.println("Введите основной материал");
		PreparedStatement preparedStatement = null;
		preparedStatement = conn
				.prepareStatement("SELECT * FROM main_material  where name = ?");
		String name = in.next();
		fillField(psGash, preparedStatement, name);
		int c = findID(conn, preparedStatement, name);
		ps.setInt(1, c);

		System.out.println("Введите цену данного кия");
		ps.setInt(2, in.nextInt());

		System.out.println("Заполните какое дерево используется через дефис");
		psGash = conn.prepareStatement("INSERT INTO wood(name) values(?)");
		System.out.println("Введите дерево");
		name = in.next();
		preparedStatement = conn
				.prepareStatement("SELECT * FROM wood where name = ?");
		fillField(psGash, preparedStatement, name);
		c = findID(conn, preparedStatement, name);
		ps.setInt(3, c);

		System.out.println("Введите название данного кия");
		ps.setString(4, in.next());

		System.out.println("Введите вес данного кия");
		ps.setInt(5, in.nextInt());

		System.out.println("Введите ферулю");
		name = in.next();
		ferula(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT id FROM ferula where name = ?");
		c = findID(conn, preparedStatement, name);
		ps.setInt(6, c);

		System.out.println("Введите вид запила");
		psGash = conn.prepareStatement("INSERT INTO gash_type(name) values(?)");
		name = in.next();
		preparedStatement = conn
				.prepareStatement("SELECT * FROM gash_type where name = ?");
		fillField(psGash, preparedStatement, name);
		c = findID(conn, preparedStatement, name);
		ps.setInt(7, c);

		System.out.println("Заполните какие запилы используются");
		psGash = conn.prepareStatement("INSERT INTO shaft(name) values(?)");
		System.out.println("Введите шафт");
		name = in.next();
		preparedStatement = conn
				.prepareStatement("SELECT * FROM shaft where name = ?");
		fillField(psGash, preparedStatement, name);
		int a = findID(conn, preparedStatement, name);

		PreparedStatement psGash1 = conn
				.prepareStatement("INSERT INTO gash(id_shaft,id_butt) values(?,?)");
		psGash1.setInt(1, a);

		psGash = conn.prepareStatement("INSERT INTO butt(name) values(?)");
		System.out.println("Введите турняк");
		name = in.next();
		preparedStatement = conn
				.prepareStatement("SELECT * FROM butt where name = ?");
		fillField(psGash, preparedStatement, name);
		int b = findID(conn, preparedStatement, name);

		psGash1.setInt(2, b);
		psGash1.executeUpdate();
		psGash1.close();

		preparedStatement = conn
				.prepareStatement("SELECT id FROM gash where id_shaft = ? AND id_butt = ?");
		preparedStatement.setInt(1, a);
		preparedStatement.setInt(2, b);
		ResultSet res = preparedStatement.executeQuery();
		while (res.next()) {
			c = res.getInt("id");
		}
		ps.setInt(8, c);

		System.out.println("Введите наклейку");
		name = in.next();
		sticker(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT id FROM sticker where name = ?");
		c = findID(conn, preparedStatement, name);
		ps.setInt(9, c);

		System.out.println("Введите тип наклейки");
		name = in.next();
		typeSticker(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT id FROM type_sticker where name = ?");
		c = findID(conn, preparedStatement, name);
		ps.setInt(10, c);

		System.out.println("Введите длинну данного кия");
		ps.setInt(11, in.nextInt());

		System.out.println("Заполните какая скрутка используются");
		System.out.println("Введите материал1 скрутки");
		name = in.next();
		materialJoint(conn, name);
		psGash = conn
				.prepareStatement("INSERT INTO joint(id_material_joint,id_carving_joint) values(?,?)");
		preparedStatement = conn
				.prepareStatement("SELECT * FROM material_joint where name = ?");
		a = findID(conn, preparedStatement, name);
		psGash.setInt(1, a);

		System.out.println("Введите материал2");
		name = in.next();
		carvingJoint(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT * FROM carving_joint where name = ?");
		b = findID(conn, preparedStatement, name);
		psGash.setInt(2, b);
		psGash.executeUpdate();
		psGash.close();

		preparedStatement = conn
				.prepareStatement("SELECT id FROM joint where id_material_joint = ? AND id_carving_joint = ?");
		preparedStatement.setInt(1, a);
		preparedStatement.setInt(2, b);
		res = preparedStatement.executeQuery();
		while (res.next()) {
			c = res.getInt("id");
		}
		ps.setInt(12, c);

		System.out.println("Введите кольцо торцов");
		name = in.next();
		ringEnd(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT id FROM ring_end where name = ?");
		c = findID(conn, preparedStatement, name);
		ps.setInt(13, c);

		System.out.println("Введите кольцо бампера");
		name = in.next();
		ringBumper(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT id FROM ring_bumper where name = ?");
		c = findID(conn, preparedStatement, name);
		ps.setInt(14, c);

		System.out.println("Введите амортизацию");
		name = in.next();
		damper(conn, name);
		preparedStatement = conn
				.prepareStatement("SELECT id FROM damper where name = ?");
		c = findID(conn, preparedStatement, name);
		ps.setInt(15, c);
		ps.executeUpdate();
		ps.close();
	}
}