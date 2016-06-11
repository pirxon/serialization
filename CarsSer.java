import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * <b>Cериализация и десириализация объектов Car</b>
 * 
 * @author Slatin Vadim
 * @see Car
 */
public class CarsSer {
	/** Создаю коллекцию cars для добавления объектов  */
	public static ArrayList<Car> cars = new ArrayList<Car>(); 
	
	public static void main(String[] args) {
		/** Вызываем десириализацию объекта из файла file.ser. записываем объект в коллекцию. При первом запуске 
		 * комментируем строку т.к. файл ещё не создан */
		cars = (ArrayList<Car>) deser("file");
		
		/** Выввод количества объектов в коллекции */
		System.out.println("Уже имеем "+cars.size()+" машины");
		
		/** Создаем новый объект с заданными значениями
		 * @param carModel модель машины
		 * @param carNumber номер машины
		 */
		Car car = new Car();
		car.setCarModel(JOptionPane.showInputDialog(null,"Введите модель машины"));
		car.setCarNumber(JOptionPane.showInputDialog(null,"Введите номер  машины"));
		
		/** добавляем объект в коллекцию, вывожу все объекты и размер коллекции */ 
		cars.add(car);
		for(Car a: cars) {
			System.out.println(a.getCarModel()+ " " + a.getCarNumber());
		}
		System.out.println("Добавил машину, теперь их - "+cars.size());
		
		/**	Сериализуем коллекцию в файл */
		ser("file", cars); 
}

	/**
	 * Десириализация, восстановление объекта из файла
	 * @param file_name задаем имя файла
	 * @return возвращает объект
	 */
	public static Object deser(String file_name) {
		Object retObject = null;
		try {
			FileInputStream filein = new FileInputStream(file_name+".ser");
			ObjectInputStream in = new ObjectInputStream(filein);
			retObject = in.readObject(); 
			filein.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("Файл не найден");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Ошибка ввода-вывода");
			System.exit(2);
		} catch (ClassNotFoundException e) {
			System.out.println("Класс не найден");
			System.exit(3);
		}
		return retObject;
	}

	/**
	 * Сириализация, сохраняем состояние объекта в файл
	 * @param file_name задаем имя файла
	 * @param obj задаем объект
	 */
	public static void ser(String file_name, Object obj) {
		try {
			FileOutputStream fileout = new FileOutputStream(file_name+".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(obj);
			fileout.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("Файл не найден");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Ошибка ввода/вывода");
			System.exit(2);
		}
	}

	
}
