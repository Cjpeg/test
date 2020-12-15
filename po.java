package h14;

import java.awt.*;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class po extends Applet {

    Button restartbutton;
    TextField txtvak;
    Label Rules;
    String txtvakgrabber, bot = "", humantext = "";
    String winorlose1 = "";
    int amount = 23;
    int userinput;
    boolean Playerturn;

    public void init() {
        resize(700, 400);
        restartbutton = new Button("Reset");
        txtvak = new TextField(10);
        Rules = new Label("How much damage are you going to do");
        txtvak.addActionListener(new Game());
        restartbutton.addActionListener(new Resetlistener());
        add(restartbutton);
        add(txtvak);
        add(Rules);
    }

    public void paint(Graphics g) {
        g.drawString(humantext, 69, 65);
        g.drawString(bot, 69, 85);
        g.drawString(winorlose1, 69, 300);
        g.drawString("give your adc the minion", 20, 40);
        g.drawString("The total of hp left = " + amount, 105, 130);
    }


    public class Game implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            txtvakgrabber = txtvak.getText();
            userinput = Integer.parseInt(txtvakgrabber);

            for (int Player_turn_loop = 0; Player_turn_loop == 0; Player_turn_loop++) {
                Playerturn = true;
                if (amount == 0) {
                    break;
                }


                if (userinput <= 3 && userinput >= 0) {
                    if (amount == 1) {
                        userinput = 1;
                    }

                    amount = amount - userinput;
                    humantext = "You did " + userinput + " damage";
                    txtvak.setText("");
                } else {
                    humantext = "you can only 1 2 or 3 damage";
                    bot = "";
                    repaint();
                    break;
                }
                if (amount == 0) {
                    winorlose1 = "you took his minion he isnt going to like that";
                    repaint();
                    break;
                }


                Playerturn = false;
                int random = (int) (Math.random() * 3 + 1);
                if (amount == 1) {
                    amount = amount - 1;
                    bot = "your adc did 1 damage";
                    System.out.println(amount);
                } else if (amount == 2 || amount == 3 || amount == 4) {
                    bot = "your adc did " + (amount - 1) + " damage";
                    amount = 1;
                    System.out.println(amount);
                } else if (amount == 6 || amount == 7 || amount == 8) {
                    bot = "your adc did " + (amount - 5) + " damage";
                    amount = 5;
                    System.out.println(amount);
                } else if (amount == 10 || amount == 11 || amount == 12) {
                    bot = "your adc did " + (amount - 9) + " damage";
                    amount = 9;
                    System.out.println(amount);
                } else if (amount == 14 || amount == 15 || amount == 16) {
                    bot = "your adc did " + (amount - 13) + " damage";
                    amount = 13;
                } else if (amount == 18 || amount == 19 || amount == 20) {
                    bot = "your adc did " + (amount - 17) + " damage";
                    amount = 17;
                } else if (amount == 22) {
                    bot = "your adc did " + (amount - 21) + " damage";
                    amount = 21;
                } else if (!Playerturn) {
                    amount = amount - (random + 1);
                    bot = "your adc did " + (random + 1) + " damage";
                    System.out.println(amount);
                }


                Playerturn = true;
                if (amount < 0) {
                    amount = 0;
                    break;
                }

                if (amount == 0 && Playerturn) {
                    winorlose1 = "gg you gave the minion";
                    repaint();
                    break;
                }
                repaint();
            }

        }
    }

    public class Resetlistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            amount = 23;
            bot = "";
            humantext = "";
            winorlose1 = "";
            repaint();
        }
    }
}

