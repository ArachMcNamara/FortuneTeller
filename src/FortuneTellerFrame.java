import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;
    private Random rand = new Random();

    public FortuneTellerFrame()
    {
        super("Fortune Teller");


        Font titleFont = new Font("Serif", Font.BOLD, 36);
        Font fortuneFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 16);


        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon("fortune.png"); // put image file in project folder
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setFont(titleFont);
        topPanel.add(titleLabel);


        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(fortuneFont);
        JScrollPane scrollPane = new JScrollPane(fortuneArea);


        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);


        fortunes = new ArrayList<>();
        fortunes.add("You will ace your next lab.");
        fortunes.add("Coffee will power your code today.");
        fortunes.add("A bug you fear is actually a feature.");
        fortunes.add("You will forget a semicolon… and find it fast.");
        fortunes.add("Your Git commit message will be legendary.");
        fortunes.add("An IntelliJ shortcut will change your life.");
        fortunes.add("You will fix a bug by accident.");
        fortunes.add("StackOverflow will save you at 2 AM.");
        fortunes.add("Your code will compile on the first try.");
        fortunes.add("You will impress Prof. Wulf.");
        fortunes.add("Your next refactor will be beautiful.");
        fortunes.add("You will remember to push to GitHub.");


        readButton.addActionListener(e -> showNewFortune());
        quitButton.addActionListener(e -> System.exit(0));


        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = (int)(screenSize.width * 0.75);
        int height = (int)(screenSize.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    private void showNewFortune()
    {
        int index;
        do
        {
            index = rand.nextInt(fortunes.size());
        } while (index == lastIndex);

        lastIndex = index;
        fortuneArea.append(fortunes.get(index) + "\n");
    }
}
