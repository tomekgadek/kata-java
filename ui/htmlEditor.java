import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
 
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserValidator {
    private static final String name = "admin";
    private static final String password = "1234";
    
    public static boolean authenticate(String name, String password) {
        return (UserValidator.name.equals(name) && UserValidator.password.equals(password));
    }
}

class LoginPanel extends JPanel {
    private JTextField loginField;
    private JPasswordField passField;
    private JButton loginButton;
    private LoginListener listener;

    public String getLoginName() {
        return loginField.getText();
    }
    
    public String getPassword() {
        char[] pass = passField.getPassword();
        return new String(pass);
    }

    public LoginPanel(LoginListener listener) {
        super();

        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);

        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }
    
    private void createComponents() {
        JLabel login = new JLabel("Login: ");
        JLabel password = new JLabel("Hasło: ");
        loginField = new JTextField();
        passField = new JPasswordField();

        loginField.setPreferredSize(new Dimension(100, 25));
        passField.setPreferredSize(new Dimension(100, 25));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));
        inputPanel.add(login);
        inputPanel.add(loginField);
        inputPanel.add(password);
        inputPanel.add(passField);

        loginButton = new JButton("Zaloguj");
        inputPanel.add(new JLabel(""));
        inputPanel.add(loginButton);

        loginButton.addActionListener(listener);

        JPanel parentPanel = new JPanel();
        parentPanel.add(inputPanel, BorderLayout.CENTER);

        this.add(parentPanel);
    }
}

class HTMLPanel extends JPanel {

    private final JTextArea textArea = new JTextArea();
    private final JEditorPane editorPane = new JEditorPane();
 
    public HTMLPanel() {
        super();
        setLayout(new BorderLayout());
        createPanels();
    }
 
    private void createPanels() {

        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        JButton actionButton = new JButton("Podgląd");
        actionButton.addActionListener(new ConvertListener());
 
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        textArea.setBackground(Color.lightGray);
        helpPanel.add(textArea);
        helpPanel.add(editorPane);
        this.add(helpPanel, BorderLayout.CENTER);
        this.add(actionButton, BorderLayout.SOUTH);
    }
 
    class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String text = textArea.getText();
                    editorPane.setText(text);
                    editorPane.revalidate();
                }
            });
        }
    }
}
 
class LoginListener implements ActionListener {

    private final JFrame frame;
    private LoginPanel loginPanel;
 
    public void setPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }
 
    public LoginListener(JFrame frame) {
        this.frame = frame;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanel.getLoginName();
        String password = loginPanel.getPassword();

        if (UserValidator.authenticate(name, password)) {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JPanel htmlPanel = new HTMLPanel();
                    frame.getContentPane().removeAll();
                    frame.add(htmlPanel); // dodajemy panel html i odswiezamy widok
                    frame.validate();
                }
            });

        } else {
            JOptionPane.showMessageDialog(frame, "Niepoprawny login lub hasło", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class Frame extends JFrame {

    public Frame() {
        super("Edytor HTML");

        LoginListener listener = new LoginListener(this);
        JPanel loginPanel = new LoginPanel(listener);
        add(loginPanel);
 
        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
