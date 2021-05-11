import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikacjaDino extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new AplikacjaDino();
    }
    JLabel label1 = new JLabel();;
    JLabel label2 = new JLabel();
    JButton buttonKopiuj, buttonZamknij, buttonInfo, buttonTrex, buttonDiplo, buttonRaptor;
    JMenuItem menuItemZamknij, menuItemInfo;
    JTextField textField;


    AplikacjaDino(){
        super("Aplikacja z dinozaurami");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        Image imageIconFrame = new ImageIcon(getClass().getClassLoader().getResource("dino.png")).getImage();
        setIconImage(imageIconFrame);
        JPanel panel = new JPanel(new BorderLayout());
        textField = new JTextField();
        JScrollPane scrollPane = new JScrollPane(textField);

        JToolBar toolBar = new JToolBar();
        JToolBar toolBar1 = new JToolBar();
        ImageIcon imageIconKopiuj = new ImageIcon(getClass().getClassLoader().getResource("kopiuj.png"));
        ImageIcon imageIconinfo = new ImageIcon(getClass().getClassLoader().getResource("info.png"));
        ImageIcon imageIconZamknij = new ImageIcon(getClass().getClassLoader().getResource("zamknij.png"));
        buttonKopiuj = new JButton(imageIconKopiuj);
        buttonInfo = new JButton(imageIconinfo);
        buttonZamknij = new JButton(imageIconZamknij);
        toolBar.add(buttonKopiuj);
        toolBar.add(buttonInfo);
        toolBar.add(buttonZamknij);
        buttonKopiuj.addActionListener(this);
        buttonInfo.addActionListener(this);
        buttonZamknij.addActionListener(this);


        buttonTrex = new JButton("T-rex");
        buttonTrex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setIcon(null);
                label1 = new JLabel(new ImageIcon("grafika/trex.png"));
                textField.add(label2);
                label2.setBounds(0,0,400,30);
                label2.setText("Wzrost:6.1m  Masa:8000kg Szybkosc:27km/h");
                textField.add(label1);
                label1.setBounds(0,40,400,300);
            }
        });
        buttonDiplo = new JButton("Diplo");
        buttonDiplo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setIcon(null);
                label1 = new JLabel(new ImageIcon("grafika/diplo.png"));
                textField.add(label2);
                label2.setBounds(0,0,400,30);
                label2.setText("Wzrost:33m Masa:16000kg Szybkosc:?");
                textField.add(label1);
                label1.setBounds(0,40,400,300);

            }
        });
        buttonRaptor = new JButton("Raptor");
        buttonRaptor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setIcon(null);
                label1 = new JLabel(new ImageIcon("grafika/raptor.png"));
                textField.add(label2);
                label2.setText("Wzrost:170cm Masa:20kg Szybkosc:40km/h");
                label2.setBounds(0,0,400,30);
                textField.add(label1);
                label1.setBounds(0,40,400,300);

            }
        });
        toolBar1.add(buttonTrex);
        toolBar1.add(buttonDiplo);
        toolBar1.add(buttonRaptor);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuPlik = new JMenu("Plik");
        JMenu menuInfo = new JMenu("Info");
        jMenuBar.add(menuPlik);
        jMenuBar.add(menuInfo);
        menuItemZamknij = new JMenuItem("Zamknij", imageIconZamknij);
        menuItemInfo = new JMenuItem("Info", imageIconinfo);
        menuPlik.add(menuItemZamknij);
        menuInfo.add(menuItemInfo);
        menuItemZamknij.addActionListener(this);
        menuItemInfo.addActionListener(this);


        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(toolBar1, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(panel);
        setJMenuBar(jMenuBar);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o==buttonKopiuj){
            textField.copy();
        }else if (o==buttonInfo || o==menuItemInfo){
            JOptionPane.showMessageDialog(AplikacjaDino.this, "Jest to aplikacja o dinozaurach. " +
                    "\nWypisane jest jak wygladaly, ile miały wysokosci, wagi i jak szybko biegaly." +
                    "\n\n Stworzył Daniel");
        }else if (o==buttonZamknij || o==menuItemZamknij){
            int nr = JOptionPane.showConfirmDialog( AplikacjaDino.this,
                    "Czy chcesz wyłączyć aplikację?",   "Pytanie",   JOptionPane.YES_NO_OPTION);
            if(nr==0)
            System.exit(0);
        }
    }
}
