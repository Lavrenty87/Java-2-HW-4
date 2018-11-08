import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Chat extends JFrame {
    Chat() {
        final String[] name = {"Аноноим"};
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, 400, 400); // Размеры всего окна стартовые
        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem miFileReg = new JMenuItem("Регистрация");
        JMenuItem miFileSettab = new JMenuItem("Настройки");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mFile.add(miFileReg);
        mFile.addSeparator(); // разделительная линия в меню
        mFile.add(miFileSettab);

        JPanel setPanel = new JPanel(); // Панель настроек
        JPanel bottomPanel = new JPanel(); // Панель ввода
        JPanel centerPanel = new JPanel(); // Панель для общения

//        centerPanel.setBackground(Color.red);
        bottomPanel.setBackground(Color.lightGray);
        setPanel.setBackground(Color.lightGray);

        bottomPanel.setPreferredSize(new Dimension(1, 40));
        setPanel.setPreferredSize(new Dimension(1, 80));

        add(setPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        setPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JButton style1Butt = new JButton("Style # 1");
        JButton style2Butt = new JButton("Style # 2");
        JButton style3Butt = new JButton("Style # 3");
        JButton style4Butt = new JButton("Style # 4");
        setPanel.add(style1Butt);
        setPanel.add(style2Butt);
        setPanel.add(style3Butt);
        setPanel.add(style4Butt);
        JTextField youName = new JTextField();
        youName.setPreferredSize(new Dimension(250, 30));
        JButton remember = new JButton("Remember");
        setPanel.add(youName);
        setPanel.add(remember);

        JTextArea jta = new JTextArea();
        jta.setBackground(Color.white);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);

        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(300, 30));
        JButton jb = new JButton("Send");
        bottomPanel.add(jtf);
        bottomPanel.add(jb);

        style1Butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setBackground(Color.white);
                bottomPanel.setBackground(Color.lightGray);
                setPanel.setBackground(Color.lightGray);
                style1Butt.setBackground(Color.gray);
                style2Butt.setBackground(Color.white);
                style3Butt.setBackground(Color.white);
                style4Butt.setBackground(Color.white);
                jb.setBackground(Color.white);
            }
        });

        style2Butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setBackground(Color.white);
                bottomPanel.setBackground(Color.yellow);
                setPanel.setBackground(Color.yellow);
                style1Butt.setBackground(Color.green);
                style2Butt.setBackground(Color.red);
                style3Butt.setBackground(Color.green);
                style4Butt.setBackground(Color.green);
                jb.setBackground(Color.green);
            }
        }
        );

        style3Butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setBackground(Color.yellow);
                bottomPanel.setBackground(Color.red);
                setPanel.setBackground(Color.red);
                style1Butt.setBackground(Color.green);
                style2Butt.setBackground(Color.green);
                style3Butt.setBackground(Color.red);
                style4Butt.setBackground(Color.green);
                jb.setBackground(Color.green);
            }
        }
        );

        style4Butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setBackground(Color.BLACK);
                bottomPanel.setBackground(Color.black);
                setPanel.setBackground(Color.black);
                style1Butt.setBackground(Color.gray);
                style2Butt.setBackground(Color.gray);
                style3Butt.setBackground(Color.gray);
                style4Butt.setBackground(Color.white);
                jb.setBackground(Color.gray);
            }
        }
        );

        remember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (youName != null)
                    name[0] = youName.getText();
            }
        });

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(name[0] + ": " + jtf.getText() + "\n");
                jtf.setText(null);
                jtf.grabFocus();
            }
        });

        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jta.append(name[0] + ": " + jtf.getText() + "\n");
                    jtf.setText(null);
                    jtf.grabFocus();
                }
                super.keyReleased(e);
            }
        });
        setVisible(true);
    }
}

class MainChat {
    public static void main(String[] args) {
        new Chat();
    }
}
