package mylaba2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
public  class Formula extends JFrame {

    private JButton button1 = new JButton("Вычислить"); // создаем кнопки
    private JButton button2 = new JButton("Очистить");
    private JButton button3 = new JButton("M+");
    private JButton button4 = new JButton("MC");
    private JTextField input_x = new JTextField(""); // создаем текстовое поле для ввода
    private JTextField input_y = new JTextField("");
    private JTextField input_z = new JTextField("");
    private JTextField result = new JTextField("");
    private JLabel label1 = new JLabel("  Введите х:"); // создаем подписи к текстовым полям
    private JLabel label2 = new JLabel("  Введите y:");
    private JLabel label3 = new JLabel("  Введите z:");
    private JLabel label4 = new JLabel("  Результат:");
    private JRadioButton radio1 = new JRadioButton("Формула 1"); // создаем радиокнопки
    private JRadioButton radio2 = new JRadioButton("Формула 2");

    Double resultat = 0.0;
    Double sum = 0.0;


    // классы для расчетных формул

    public Double formula1(Double x, Double y, Double z) {
        return (Math.sin(3.14*y*y)+Math.log(y*y)) / (Math.sin(3.14*z*z) + Math.sin(x) + Math.log(z*z) + x*x + Math.exp(Math.cos(z*x)));
    }


    public Double formula2(Double x, Double y, Double z) {
        return y*x*x / (Math.log(Math.pow(z,y)) + Math.pow(Math.cos(Math.pow(x,1/3)),2));
    }


    public Formula() {
        super("Вычисление формулы"); // заголовок окна

        this.setBounds(300, 300, 500, 400); // размеры окна
        this.setDefaultCloseOperation(Formula.EXIT_ON_CLOSE); // обработка закрытия окна

        Container container = this.getContentPane(); // контейнер под содержимое
        container.setLayout(new GridLayout(7, 2, 2, 2)); // в виде таблицы

        // добавляем содержимое

        ButtonGroup group = new ButtonGroup(); // группируем радиокнопки
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(label1);
        container.add(input_x);

        input_x.setBackground(Color.lightGray);
        container.add(label2);
        container.add(input_y);

        input_y.setBackground(Color.lightGray);
        container.add(label3);
        container.add(input_z);

        input_z.setBackground(Color.lightGray);
        container.add(label4);
        container.add(result);

        result.setBackground(Color.lightGray);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(button1);
        group1.add(button2);
        group1.add(button3);
        group1.add(button4);

        button1.addActionListener(new ButtonEvent1()); // обработка нажатия кнопки
        container.add(button1);
        button1.setBackground(Color.GREEN); // задаем цвет кнопок

        button2.addActionListener(new ButtonEvent2());
        container.add(button2);
        button2.setBackground(Color.RED);

        button3.addActionListener(new ButtonEvent3());
        container.add(button3);
        button3.setBackground(Color.CYAN);

        button4.addActionListener(new ButtonEvent4());
        container.add(button4);
        button4.setBackground(Color.GRAY);

    }

    // обрабатываем нажатие каждой кнопки

    class ButtonEvent1 implements ActionListener { // кнопка Вычислить

        public void actionPerformed (ActionEvent i) {

            Double x = Double.parseDouble(input_x.getText()); // из текста в число
            Double y = Double.parseDouble(input_y.getText());
            Double z = Double.parseDouble(input_z.getText());

            if(radio1.isSelected()) // если флаг на кнопка 1
                resultat = formula1(x, y, z);

            else
                resultat = formula2(x, y, z);
            result.setText(resultat.toString()); // результат в текст и вывести в текстовом поле
        }
    }

    class ButtonEvent2 implements ActionListener { // кнопка Очистить

        public void actionPerformed (ActionEvent i) {

            input_x.setText("");
            input_y.setText("");
            input_z.setText("");

            result.setText("");
        }
    }

    class ButtonEvent3 implements ActionListener { // кнопка М+

        public void actionPerformed (ActionEvent i) {

            sum = sum + resultat;
            result.setText(sum.toString());
        }
    }

    class ButtonEvent4 implements ActionListener { // кнопка МС

        public void actionPerformed (ActionEvent i) {

            sum = 0.0;
            result.setText("");
        }
    }


}
