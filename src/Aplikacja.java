import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplikacja extends JFrame implements ActionListener {

    JButton buttonKopiuj, buttonWklej, buttonInfo;
    JMenuItem jMenuItemKopiuj, jMenuItemWklej, jMenuItemInfo;
    JTextArea textArea;

    Aplikacja(){
        super("Edytor tekstu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        Image imageIconFrame = new ImageIcon(getClass().getClassLoader().getResource("frame.png")).getImage();
        setIconImage(imageIconFrame);
        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();

        JScrollPane jScrollPane = new JScrollPane(textArea);
        panel.add(jScrollPane, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        ImageIcon imageIconKopiuj = new ImageIcon(getClass().getClassLoader().getResource("kopiuj.png"));
        ImageIcon imageIconWklej = new ImageIcon(getClass().getClassLoader().getResource("wklej.png"));
        ImageIcon imageIconZamkij = new ImageIcon(getClass().getClassLoader().getResource("zamknij.png"));
        ImageIcon imageIconInfo = new ImageIcon(getClass().getClassLoader().getResource("info.png"));
        buttonKopiuj = new JButton(imageIconKopiuj);
        buttonWklej = new JButton(imageIconWklej);
        buttonInfo = new JButton(imageIconInfo);
        JButton jButtonZamkij = new JButton(imageIconZamkij);
        jButtonZamkij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int nr = JOptionPane.showConfirmDialog( Aplikacja.this,   "Czy chcesz wyłączyć aplikację?",   "Pytanie",   JOptionPane.YES_NO_OPTION);
                    if(nr==0)
                        System.exit(0);
                }
            });

        toolBar.add(jButtonZamkij);
        toolBar.add(buttonKopiuj);
        toolBar.add(buttonWklej);
        toolBar.add(buttonInfo);
        buttonKopiuj.addActionListener(this);
        buttonWklej.addActionListener(this);
        buttonInfo.addActionListener(this);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuEdycja = new JMenu("Edycja");
        JMenu menuPlik = new JMenu("Plik");
        JMenu menuInfo = new JMenu("Informacja");
        jMenuBar.add(menuPlik);
        jMenuBar.add(menuEdycja);
        jMenuBar.add(menuInfo);
        jMenuItemKopiuj = new JMenuItem("Kopiuj", imageIconKopiuj);
        jMenuItemWklej = new JMenuItem("Wklej", imageIconWklej);
        jMenuItemInfo = new JMenuItem("Info", imageIconInfo);
        JMenuItem jMenuItemZamkij = new JMenuItem("Zamknij", imageIconZamkij);
        jMenuItemZamkij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr = JOptionPane.showConfirmDialog( Aplikacja.this,   "Czy chcesz wyłączyć aplikację?",   "Pytanie",   JOptionPane.YES_NO_OPTION);
                if(nr==0)
                System.exit(0);
            }
        });

        menuPlik.add(jMenuItemZamkij);
        menuEdycja.add(jMenuItemKopiuj);
        menuEdycja.add(jMenuItemWklej);
        menuInfo.add(jMenuItemInfo);
        jMenuItemKopiuj.addActionListener(this);
        jMenuItemWklej.addActionListener(this);
        jMenuItemInfo.addActionListener(this);


        panel.add(toolBar, BorderLayout.NORTH);
        setContentPane(panel);
        setJMenuBar(jMenuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Aplikacja();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o==buttonKopiuj || o==jMenuItemKopiuj){
            textArea.copy();
        }else if (o==buttonWklej || o==jMenuItemWklej){
            textArea.paste();
        }else if (o==buttonInfo || o==jMenuItemInfo){
            JOptionPane.showMessageDialog(Aplikacja.this,
                    "Aplikacja z wykładu nr 6 pokazująca działanie przykładowych \n" +
                            "komponentów graficznych jak paski narzędziowe, menu i inne.\n\n" +
                            "autor programu: Daniel");
        }
    }
}
